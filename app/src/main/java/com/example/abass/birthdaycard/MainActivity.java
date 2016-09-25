package com.example.abass.birthdaycard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter adapter;
    Spinner spinner;
    Spinner spinner2;
    Integer[] days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.month_spinner);
        spinner2 = (Spinner) findViewById(R.id.day_spinner);
        String[] months = getResources().getStringArray(R.array.string_array_months);
        adapter = new ArrayAdapter(this, R.layout.text_layout, months);
        spinner.setAdapter(adapter);
        days = makeArrayOfDays();
        ArrayAdapter dayAdapter = new ArrayAdapter(this, R.layout.text_layout, days);
        spinner2.setAdapter(dayAdapter);
    }

    public Integer[] makeArrayOfDays(){
        Integer[] numArr = new Integer[31];
        for (int i = 0; i < numArr.length; i++){
            numArr[i] = i+1;
        }
        return numArr;
    }

}
