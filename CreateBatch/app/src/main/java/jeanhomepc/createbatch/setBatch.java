package jeanhomepc.createbatch;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class setBatch extends AppCompatActivity {

    InputStream is=null;
    String result=null;
    String line=null;
    int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        //---Button view---
        Button button = (Button) findViewById(R.id.btnProceed);
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
                if ((((CheckBox) v).isChecked()) && (!ifHalfChecked())) {
                    RadioButton rb = (RadioButton) findViewById(R.id.rbAccept);
                    rb.setVisibility(View.VISIBLE);
                    DisplayToast("Full batch selected");

                    TextView txtFull = (TextView) findViewById(R.id.txtFull);
                    txtFull.setVisibility(View.VISIBLE);


                } else if (ifHalfChecked()) {
                    DisplayToast("Half batch already selected");
                    checkBox.setChecked(false);
                } else {

                    RadioButton rb = (RadioButton) findViewById(R.id.rbAccept);
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
                    RadioButton rb = (RadioButton) findViewById(R.id.rbAccept);
                    rb.setVisibility(View.VISIBLE);
                    DisplayToast("Half batch selected");
                    TextView txtHalf = (TextView) findViewById(R.id.txtHalf);
                    txtHalf.setVisibility(View.VISIBLE);
                } else if (ifFullChecked()) {
                    DisplayToast("Full batch already selected");
                    checkBox2.setChecked(false);
                } else {
                    RadioButton rb = (RadioButton) findViewById(R.id.rbAccept);
                    rb.setVisibility(View.INVISIBLE);
                    DisplayToast("Half batch is unchecked");
                    TextView txtHalf = (TextView) findViewById(R.id.txtHalf);
                    txtHalf.setVisibility(View.INVISIBLE);
                }
            }
        });

        //---Radio Button---
        RadioButton rb = (RadioButton) findViewById(R.id.rbAccept);
        rb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // setBatch bnr = new setBatch();

                //txtView("New product batch nr: " +String.valueOf(bnr.getNew()));
                //DisplayToast("New product batch nr: " +String.valueOf(bnr.getNew()));
                DisplayToast("New batch accepted press proceed button to continue with batch initialization");
                Button button = (Button) findViewById(R.id.btnProceed);
                button.setVisibility(View.VISIBLE);

            }


        });
    }

        public String txtView(String s){
        return s;
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








   /* public void update() {
        {
            ContentValues values=new ContentValues();
            values.put("Batch_Nr",getNew());
            values.put("State",state());
            values.put("Current_Process",currP());
            values.put("Current_Owner",currO());
            values.put("Initialized",init());
            chemtech.insert(Table_name,null,values);

            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

            nameValuePairs.add(new BasicNameValuePair("Batch_Nr",getString(getNew())));
            nameValuePairs.add(new BasicNameValuePair("State",state()));
            nameValuePairs.add(new BasicNameValuePair("Current_Process",getString(currP())));
            nameValuePairs.add(new BasicNameValuePair("Current_Owner",currO()));
            nameValuePairs.add(new BasicNameValuePair("Initialized",init()));

            try
            {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://192.168.40.1");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
                Log.e("pass 1", "connection success ");
            }
            catch(Exception e)
            {
                Log.e("Fail 1", e.toString());
                Toast.makeText(getApplicationContext(), "Invalid IP Address",
                        Toast.LENGTH_LONG).show();
            }

            try
            {
                BufferedReader reader = new BufferedReader
                        (new InputStreamReader(is,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();
                Log.e("pass 2", "connection success ");
            }
            catch(Exception e)
            {
                Log.e("Fail 2", e.toString());
            }

            try
            {
                JSONObject json_data = new JSONObject(result);
                code=(json_data.getInt("code"));

                if(code==1)
                {
                    Toast.makeText(getBaseContext(), "Update Successfully",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Sorry, Try Again",
                            Toast.LENGTH_LONG).show();
                }
            }
            catch(Exception e)
            {
                Log.e("Fail 3", e.toString());
            }
        }


        }*/
    }

