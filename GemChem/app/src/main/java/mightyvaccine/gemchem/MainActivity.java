package mightyvaccine.gemchem;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v7.widget.AppCompatEditText;

import com.example.ruan.message.mMySQL.downloader;

public class MainActivity extends AppCompatActivity
{
    //Connection
    final static String urlAddress = "http://143.160.159.1/android/connectionMessaging.php";

    //Notification
    NotificationCompat.Builder Notification;
    private static final int uniqueID = 745; // identify die notification. Gebruik empnum as uniqueID?

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notification = new NotificationCompat.Builder(this);
        Notification.setAutoCancel(true); //Delete die notification op die status bar

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //Spinner
        final Spinner sp = (Spinner) findViewById(R.id.spinnerUser);

        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                new downloader(MainActivity.this, urlAddress, sp ).execute();;
            }
        });
    }
    public String stringName()
    {
        EditText input = (EditText) findViewById(R.id.txtUserName);
        return input.getText().toString();
    }


    public String stringNotification()
    {
        EditText input = (EditText) findViewById(R.id.txtNotification);
        return input.getText().toString();
    }

    public void btnNotificationClicked(View view) //wat gebeur as jy op die notify button click
    {
        //Design van notification
        //if(uniquenum nie in die databasis is nie)
        //  {
        //    Toast.makeText(MightyVaccines.this,"That employee doesnt exist.", Toast.LENGTH_LONG.show();
        // }
        // else
        // {
        Notification.setSmallIcon(R.drawable.ic_vaccine);
        Notification.setTicker("Mighty Vaccines"); //Database username from whom sent the notification
        Notification.setWhen(System.currentTimeMillis()); //Kyk wanneer die notifcation gestuur is
        Notification.setAutoCancel(true);
        Notification.setContentTitle(stringName());
        Notification.setContentText(stringNotification());
        //}



        //wanneer user op notification click stuur terug na die app toe
        Intent intent = new Intent(this, MainActivity.class); //op watter page die user moet terug gaan
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT); //Give access to phone to access app
        Notification.setContentIntent(pendingIntent);

        //Sending the notification to device
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, Notification.build()); // Param is die uniqueID en die Notification self
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
