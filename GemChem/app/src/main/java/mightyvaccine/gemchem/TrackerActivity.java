package mightyvaccine.gemchem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TrackerActivity extends AppCompatActivity {
    View view;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    TextView txt9;
    TextView txt0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    int count1 = 1;
    int count2 = 1;
    int count3 = 1;
    int batchNumber = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracker);

        view = this.getWindow().getDecorView();
        view.setBackgroundResource(R.color.grey);
        txt1 = (TextView) findViewById(R.id.lblA);
        txt2 = (TextView) findViewById(R.id.lblB);
        txt3 = (TextView) findViewById(R.id.lblC);
        txt4 = (TextView) findViewById(R.id.lblD);
        txt5 = (TextView) findViewById(R.id.lblE);
        txt6 = (TextView) findViewById(R.id.lblF);
        txt7 = (TextView) findViewById(R.id.lblG);
        txt8 = (TextView) findViewById(R.id.lblH);
        txt9 = (TextView) findViewById(R.id.lblI);
        txt0 = (TextView) findViewById(R.id.label);
        btn1 = (Button)findViewById(R.id.btnStart);
        btn2 = (Button)findViewById(R.id.btnEnd);
        btn3 = (Button)findViewById(R.id.btnHelp);
        btn4 = (Button)findViewById(R.id.btnStock);
        btn5 = (Button)findViewById(R.id.btnDone);
        btn6 = (Button)findViewById(R.id.btnCont);

        txt0.setText("" + batchNumber);

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                btn1 = (Button) findViewById(R.id.btnStart);
                btn2 = (Button) findViewById(R.id.btnEnd);
                btn3 = (Button) findViewById(R.id.btnHelp);
                btn4 = (Button) findViewById(R.id.btnStock);
                btn1.setVisibility(View.GONE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);

                    if (count1 == 7) {
                        txt7.setText("In Progress  ");
                        txt7.setBackgroundResource(R.color.orange);
                        count1 = 0;
                    } else if (count1 == 6) {
                        txt6.setText("In Progress  ");
                        txt6.setBackgroundResource(R.color.orange);
                    } else if (count1 == 5) {
                        txt5.setText("In Progress  ");
                        txt5.setBackgroundResource(R.color.orange);
                    } else if (count1 == 4) {
                        txt4.setText("In Progress  ");
                        txt4.setBackgroundResource(R.color.orange);
                    } else if (count1 == 3) {
                        txt3.setText("In Progress  ");
                        txt3.setBackgroundResource(R.color.orange);
                    } else if (count1 == 2) {
                        txt2.setText("In Progress  ");
                        txt2.setBackgroundResource(R.color.orange);
                    } else {
                        txt1.setText("In Progress  ");
                        txt1.setBackgroundResource(R.color.orange);
                    }
                    count1++;
                }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                btn1 = (Button)findViewById(R.id.btnStart);
                btn2 = (Button)findViewById(R.id.btnEnd);
                btn3 = (Button)findViewById(R.id.btnHelp);
                btn4 = (Button)findViewById(R.id.btnStock);
                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                btn4.setVisibility(View.GONE);

                if(count2==7) {
                    txt7.setText("Finnished  ");
                    txt7.setBackgroundResource(R.color.green);
                    txt8.setVisibility(View.VISIBLE);
                    txt8.setBackgroundResource(R.color.green);
                    txt9.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.GONE);
                    btn5.setVisibility(View.VISIBLE);
                    count2=0;
                }
                else if(count2==6){
                    txt6.setText("Finnished  ");
                    txt6.setBackgroundResource(R.color.green);
                }
                else if(count2==5){
                    txt5.setText("Finnished  ");
                    txt5.setBackgroundResource(R.color.green);
                }
                else if(count2==4){
                    txt4.setText("Finnished  ");
                    txt4.setBackgroundResource(R.color.green);
                }
                else if(count2==3){
                    txt3.setText("Finnished  ");
                    txt3.setBackgroundResource(R.color.green);
                }
                else if(count2==2){
                    txt2.setText("Finnished  ");
                    txt2.setBackgroundResource(R.color.green);
                }
                else{
                    txt1.setText("Finnished  ");
                    txt1.setBackgroundResource(R.color.green);
                }
               count2++;
            }

        });

        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                btn1 = (Button)findViewById(R.id.btnStart);
                btn2 = (Button)findViewById(R.id.btnEnd);
                btn3 = (Button)findViewById(R.id.btnHelp);
                btn4 = (Button)findViewById(R.id.btnStock);

                btn1.setVisibility(View.GONE);
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                btn4.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.VISIBLE);

                count3=count1 - 1;

                if(count3==7) {
                    txt7.setText("Please Help!!!  ");
                    txt7.setBackgroundResource(R.color.red);
                }
                else if(count3==6){
                    txt6.setText("Please Help!!!  ");
                    txt6.setBackgroundResource(R.color.red);
                }
                else if(count3==5){
                    txt5.setText("Please Help!!!  ");
                    txt5.setBackgroundResource(R.color.red);
                }
                else if(count3==4){
                    txt4.setText("Please Help!!!  ");
                    txt4.setBackgroundResource(R.color.red);
                }
                else if(count3==3){
                    txt3.setText("Please Help!!!  ");
                    txt3.setBackgroundResource(R.color.red);
                }
                else if(count3==2){
                    txt2.setText("Please Help!!!  ");
                    txt2.setBackgroundResource(R.color.red);
                }
                else {
                    txt1.setText("Please Help!!!  ");
                    txt1.setBackgroundResource(R.color.red);
                }

            }

        });

        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                btn1 = (Button)findViewById(R.id.btnStart);
                btn2 = (Button)findViewById(R.id.btnEnd);
                btn3 = (Button)findViewById(R.id.btnHelp);
                btn4 = (Button)findViewById(R.id.btnStock);

                btn1.setVisibility(View.GONE);
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.GONE);
                btn6.setVisibility(View.VISIBLE);

                count3=count1 - 1;

                if(count3==7) {
                    txt7.setText("Need Stock!!!  ");
                    txt7.setBackgroundResource(R.color.red);
                }
                else if(count3==6){
                    txt6.setText("Need Stock!!!  ");
                    txt6.setBackgroundResource(R.color.red);
                }
                else if(count3==5){
                    txt5.setText("Need Stock!!!  ");
                    txt5.setBackgroundResource(R.color.red);
                }
                else if(count3==4){
                    txt4.setText("Need Stock!!!  ");
                    txt4.setBackgroundResource(R.color.red);
                }
                else if(count3==3){
                    txt3.setText("Need Stock!!!  ");
                    txt3.setBackgroundResource(R.color.red);
                }
                else if(count3==2){
                    txt2.setText("Need Stock!!!  ");
                    txt2.setBackgroundResource(R.color.red);
                }
                else {
                    txt1.setText("Need Stock!!!  ");
                    txt1.setBackgroundResource(R.color.red);
                }

            }

        });

        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                btn1 = (Button)findViewById(R.id.btnStart);
                btn2 = (Button)findViewById(R.id.btnEnd);
                btn3 = (Button)findViewById(R.id.btnHelp);
                btn4 = (Button)findViewById(R.id.btnStock);

                btn1.setVisibility(View.GONE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn6.setVisibility(View.GONE);

                count3=count1 - 1;

                if(count3==7) {
                    txt7.setText("In Progress  ");
                    txt7.setBackgroundResource(R.color.orange);
                }
                else if(count3==6){
                    txt6.setText("In Progress  ");
                    txt6.setBackgroundResource(R.color.orange);
                }
                else if(count3==5){
                    txt5.setText("In Progress  ");
                    txt5.setBackgroundResource(R.color.orange);
                }
                else if(count3==4){
                    txt4.setText("In Progress  ");
                    txt4.setBackgroundResource(R.color.orange);
                }
                else if(count3==3){
                    txt3.setText("In Progress");
                    txt3.setBackgroundResource(R.color.orange);
                }
                else if(count3==2){
                    txt2.setText("In Progress  ");
                    txt2.setBackgroundResource(R.color.orange);
                }
                else {
                    txt1.setText("In Progress  ");
                    txt1.setBackgroundResource(R.color.orange);
                }

            }

        });


        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                batchNumber+=11;
                txt0.setText("" + batchNumber);
                txt1.setText(".....  ");
                txt1.setBackgroundResource(R.color.grey);
                txt2.setText(".....  ");
                txt2.setBackgroundResource(R.color.grey);
                txt3.setText(".....  ");
                txt3.setBackgroundResource(R.color.grey);
                txt4.setText(".....  ");
                txt4.setBackgroundResource(R.color.grey);
                txt5.setText(".....  ");
                txt5.setBackgroundResource(R.color.grey);
                txt6.setText(".....  ");
                txt6.setBackgroundResource(R.color.grey);
                txt7.setText(".....  ");
                txt7.setBackgroundResource(R.color.grey);
                txt8.setVisibility(View.GONE);
                txt8.setBackgroundResource(R.color.grey);
                txt9.setVisibility(View.GONE);
                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.GONE);
                btn4.setVisibility(View.GONE);
                btn5.setVisibility(View.GONE);

            }

        });
    }

}