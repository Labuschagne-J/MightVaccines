package com.example.ruan.message.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ruan.message.mDataObject.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ruan on 2017/09/14.
 */

public class dataparser extends AsyncTask<Void, Void, Integer>
{

    Context c;
    Spinner sp;
    String jsonData;

    ProgressDialog pd;
    ArrayList<String> users = new ArrayList<>();

    public dataparser(Context c, Spinner sp, String jsonData) {
        this.c = c;
        this.sp = sp;
        this.jsonData = jsonData;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        pd.dismiss();
        if(result == 0)
        {
            Toast.makeText(c, "Unable to Parse", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(c, "Parsed success", Toast.LENGTH_SHORT).show();

            ArrayAdapter adapter = new ArrayAdapter(c,android.R.layout.simple_list_item_1,users);
            sp.setAdapter(adapter);

            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
            {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    Toast.makeText(c, users.get(position), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent)
                {

                }
            });

        }

    }

    private int parseData()
    {
        try
        {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo = null;

            users.clear();
            test t = null;

            for(int i = 0; i < ja.length();i++)
            {
                jo = ja.getJSONObject(i);

                String name = jo.getString("Username");
                String empNum = jo.getString("Password");

                t = new test();
                t.setEmpNum(empNum);
                t.setName(name);

                users.add(name);
            }

            return 1;
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return 0;
    }
}
