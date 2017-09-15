package mightyvaccine.gemchem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiaan Rademeyer on 2017/09/15.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "spinner1";

    private static final String TABLE_LABELS = "batches";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";

    public DBHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldDB,int newDB){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LABELS);

        onCreate(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CATEGORIES_TABLE = "CREATE TABLE " + TABLE_LABELS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT)";
        db.execSQL(CREATE_CATEGORIES_TABLE);
    }

    public void insertBatch(String batch)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, batch);

        db.insert(TABLE_LABELS, null,values);
        db.close();
    }


    public List<String> getAllBatches()
    {
        List<String> batches = new ArrayList<String>();

        String selectQuery = "SELECT * FROM " + TABLE_LABELS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst())
        {
            batches.add(cursor.getString(1));
        }
        while (cursor.moveToNext());


        cursor.close();
        db.close();

        return batches;

    }
    {

    }


}
