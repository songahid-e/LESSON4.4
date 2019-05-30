package com.example.lesson44;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    private Intent intent;
    private String message;
    private Bundle extras;
    private EditText _etName, _etAddress, _etPhone, _etNote;
    private TextView _tvOrder;
    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        initializeViews();
        initializeObjects();
        if(extras != null) {
            message = extras.getString(MainActivity.EXTRA_MESSAGE);
            _tvOrder.setText(message);
        }

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
            adapter = ArrayAdapter.createFromResource(this,
                    R.array.labels_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource
                    (android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
        }

    }

    private void initializeViews() {
        _tvOrder = findViewById(R.id.tvOrder);
        _etName = findViewById(R.id.etName);
        _etAddress = findViewById(R.id.etAddress);
        _etPhone = findViewById(R.id.etPhone);
        _etNote = findViewById(R.id.etNote);
        spinner = findViewById(R.id.label_spinner);
    }

    private void initializeObjects() {
        intent = getIntent();
        extras = intent.getExtras();
        spinner = findViewById(R.id.label_spinner);
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rdbSameDay:
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service_label));
                break;
            case R.id.rdbNextDay:
                if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery_label));
                break;
            case R.id.rdbPickUp:
                if (checked)
                    displayToast(getString(R.string.pick_up_label));
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();
        displayToast(label);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
