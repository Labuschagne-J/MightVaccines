package com.example.ruan.message.mMySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Ruan on 2017/09/14.
 */

public class downloader extends AsyncTask<Void, Void, String>
{
    Context c;
    String urlAddress;
    Spinner sp;

    ProgressDialog pd;

    public downloader(Context c, String urlAddress, Spinner sp) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.sp = sp;
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();

        pd = new ProgressDialog(c);
        pd.setTitle("Fetch");
        pd.setMessage("Fetching...");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params)
    {
        return null;
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);

        pd.dismiss();

        if(s == null)
        {
            Toast.makeText(c, "Unable to retrieve", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(c, "Success", Toast.LENGTH_SHORT).show();

            dataparser parser = new dataparser(c, sp, s);
            parser.execute();
        }
    }

    private String downloadData()
    {
        HttpURLConnection con = connector.connect(urlAddress);
        if(con == null)
        {
            return null;
        }
        InputStream is = null;
        try {
            is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;
            StringBuffer response = new StringBuffer();

            if(br != null)
            {
                while((line = br.readLine()) != null)
                {
                    response.append(line + "\n");
                }

                br.close();
            }
            else{
                return null;
            }

            return response.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(is != null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
