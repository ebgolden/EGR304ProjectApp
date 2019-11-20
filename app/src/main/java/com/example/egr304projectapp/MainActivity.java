package com.example.egr304projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Spinner hourDropDown = (Spinner) findViewById(R.id.hourDropDown);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.hourArray, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        hourDropDown.setAdapter(adapter);

        Spinner minuteDropDown = (Spinner) findViewById(R.id.minuteDropDown);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.minuteArray, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        minuteDropDown.setAdapter(adapter);

        Spinner meridiemDropDown = (Spinner) findViewById(R.id.meridiemDropDown);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.meridiemArray, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        meridiemDropDown.setAdapter(adapter);

        Spinner temperatureDropDown = (Spinner) findViewById(R.id.temperatureDropDown);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.temperatureArray, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        temperatureDropDown.setAdapter(adapter);

        TextView temperatureDisplay = (TextView) findViewById(R.id.temperatureDisplay);
        temperatureDisplay.setText("73.4 °F");

    }

    private String [] getStringArray (int range, int interval, String firstValue) {
        String [] value = {firstValue};
        for (int initialValue = interval - 1; initialValue < range; initialValue += interval) {
            String [] tempValue = value;
            value = new String [value.length + 1];
            for (int index = 0; index < value.length; ++index) {
                if (index < tempValue.length)
                    value [index] = tempValue [index];
                else value [index] = String.valueOf(initialValue + 1);
            }
        }

        return value;
    }


}
