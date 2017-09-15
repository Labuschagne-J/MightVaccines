package jeanhomepc.createbatch;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_batch);

        final EditText etName = (EditText) findViewById(R.id.edtUser);

        TextView textView = (TextView) findViewById(R.id.textView);
         final String[] nmr = {getString(generatePIN())};
         final String[] currentstate = new String[1];
         final String[] currentprocess = new String[1];
         final String[] currentuser = new String[1];
         final TextView[] txtView = new TextView[1];

        nmr[0] = getString(generatePIN());
        currentstate[0] = "ns";
        currentprocess[0] = "1";
        currentuser[0] = etName.toString();



     Button button = (Button) findViewById(R.id.btnProceed);
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
                    final String nr = getString(generatePIN());


            txtView[0] = (TextView) findViewById(R.id.textView);
            Response.Listener<String> responselistener = new Response.Listener<String>(){

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if(success)
                        {
                            Intent intent = new Intent(Product.this,setBatch.class);
                            Product.this.startActivity(intent);
                        }
                        else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(Product.this);
                            builder.setMessage("Register failed")
                                    .setNegativeButton("Retry",null)
                                    .create()
                                    .show();

                        }

                    } catch (JSONException e1) {
                        e1.printStackTrace();
                    }
                }
            };


            RegisterRequest registerRequest = new RegisterRequest(nmr[0], currentstate[0], currentprocess[0], currentuser[0],responselistener );
            RequestQueue queue = Volley.newRequestQueue(Product.this);
            queue.add(registerRequest);


        }
    });}





    private void DisplayToast(String msg) {
        Toast.makeText(getBaseContext(), msg,
                Toast.LENGTH_SHORT).show();
    }

    public int generatePIN()
    {

        //generate a 4 digit integer 1000 <10000
        return(int)(Math.random()*9000)+1000;

        //Store integer in a string


    }

     /*   //---Button view---
        Button button= (Button) findViewById(R.id.btnProceed);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_set_batch);
                DisplayToast("Clicked");
            }
        });

        //---Checkbox view full---
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkFull);
        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ( (((CheckBox) v).isChecked()) && (!ifHalfChecked()) ) {
                    RadioButton rb= (RadioButton) findViewById(R.id.rbAccept);
                    rb.setVisibility(View.VISIBLE);
                    DisplayToast("Full batch selected");
                    TextView txtFull = (TextView) findViewById(R.id.txtFull);
                    txtFull.setVisibility(View.VISIBLE);
                } else if (ifHalfChecked()) {
                    DisplayToast("Half batch already selected");
                    checkBox.setChecked(false);
                } else {
                    RadioButton rb= (RadioButton) findViewById(R.id.rbAccept);
                    rb.setVisibility(View.INVISIBLE);
                    DisplayToast("Full batch unchecked");
                    TextView txtFull = (TextView) findViewById(R.id.txtFull);
                    txtFull.setVisibility(View.INVISIBLE);
                }
            }
        });

        //---Checkbox view half---
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkHalf);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((((CheckBox) v).isChecked()) && (!ifFullChecked())) {
                    RadioButton rb= (RadioButton) findViewById(R.id.rbAccept);
                    rb.setVisibility(View.VISIBLE);
                    DisplayToast("Half batch selected");
                    TextView txtHalf = (TextView) findViewById(R.id.txtHalf);
                    txtHalf.setVisibility(View.VISIBLE);
                } else if (ifFullChecked()) {
                    DisplayToast("Full batch already selected");
                    checkBox2.setChecked(false);
                } else {
                    RadioButton rb= (RadioButton) findViewById(R.id.rbAccept);
                    rb.setVisibility(View.INVISIBLE);
                    DisplayToast("Half batch is unchecked");
                    TextView txtHalf = (TextView) findViewById(R.id.txtHalf);
                    txtHalf.setVisibility(View.INVISIBLE);
                }
            }
        });

        //---Radio Button---
        RadioButton rb= (RadioButton) findViewById(R.id.rbAccept);
        rb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                DisplayToast("New batch accepted press proceed button to continue with batch initialization");
                Button button= (Button) findViewById(R.id.btnProceed);
                button.setVisibility(View.VISIBLE);

            }


    });
    }
        private void DisplayToast(String msg){
            Toast.makeText(getBaseContext(), msg,
                    Toast.LENGTH_SHORT).show();
        }

        public boolean ifFullChecked(){
            boolean x;
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkFull);
            if(checkBox1.isChecked())
                x = true;
            else
                x = false;

            return x;

        }

        public boolean ifHalfChecked(){
            boolean z ;
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkHalf);
            if(checkBox2.isChecked())
                z = true;
            else
                z = false;
            return z;
        }


            public void updateDB(int SO, int NaCl, int PTLA, int Sele, int Mag, int Zink, int Copper, int Chr, int totalVolume) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "update " + Stock + " set" +
                        " SO_H2O -= " + SO +
                        " NaCl -= " + NaCl +
                        " PTLA -= " + PTLA +
                        " Selenium_Salt -= " + Sele +
                        " Magnesium_Salt -= " + Mag +
                        " Zink_Salt -= " + Zink +
                        " Copper_Salt -= " + Copper +
                        " Chromium_Salt -= " + Chr +
                        " CurrentVolume += " + totalVolume;
                Object[] bindArgs = {"bar"};
                try {
                    db.execSQL(sql, bindArgs);
                    return true;
                } catch (SQLException ex) {
                    Log.d(tag, "update data failure");
                    return false;
                }
            }

            public void setNewBatch(String batchType, int batchCode, int empNr) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql = "Insert Into " + Batch + " Values(" + batchCode + "," + batchType + "," + empNr + ")";
                Object[] bindArgs = {"bar"};
                try {
                    db.execSQL(sql, bindArgs);
                    return true;
                } catch (SQLException ex) {
                    Log.d(tag, "update data failure");
                    return false;
                }
            }*/
        }






