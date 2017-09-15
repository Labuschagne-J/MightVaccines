package mightyvaccine.tracker;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class BatchSelect extends AppCompatActivity implements OnItemSelectedListener
{

    Spinner spinner;
    Button btn;
    Button btnAdd;

    EditText inputBatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch);

        spinner = (Spinner) findViewById(R.id.spinner);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        inputBatch = (EditText) findViewById(R.id.input_batch);

        spinner.setOnItemSelectedListener(this);

        loadSpinnerData();
        btn = (Button) findViewById(R.id.btnNext);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View l) {
                setContentView(R.layout.tracker);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg) {
                String batch = inputBatch.getText().toString();

                if (batch.trim().length() > 0) {
                    DBHandler db = new DBHandler(getApplicationContext());

                    db.insertBatch(batch);

                    inputBatch.setText("");

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(inputBatch.getWindowToken(), 0);

                    loadSpinnerData();
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter Batch number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void loadSpinnerData()
    {
        DBHandler db = new DBHandler(getApplicationContext());

        List<String> batches = db.getAllBatches();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, batches);

        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String batch = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "You selected: " + batch, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg) {

    }
}

