package com.example.abass.birthdaycard;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter adapter;
    Spinner spinner;
    Spinner spinner2;
    Integer[] days;
    private static String TAG = "MainActivity";
    int currentDrawableIdx;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        currentDrawableIdx = 0;
        String[] months = getResources().getStringArray(R.array.string_array_months);
        adapter = new ArrayAdapter(this, R.layout.text_layout, months);
        spinner.setAdapter(adapter);
        days = makeArrayOfDays();
        ArrayAdapter dayAdapter = new ArrayAdapter(this, R.layout.text_layout, days);
        spinner2.setAdapter(dayAdapter);


        final int[] resDrawables = new int[]{R.drawable.image_jan, R.drawable.image_feb};
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "User clicked the bday card image");
                //Change background color of my img
                int drawable;
                if(currentDrawableIdx == resDrawables.length - 1){
//                    currentDrawableIdx = 0;
//                    drawable = resDrawables[currentDrawableIdx];
                    imageView.setImageResource(android.R.color.background_dark);
                }else{
                    currentDrawableIdx = currentDrawableIdx + 1;
                    drawable = resDrawables[currentDrawableIdx];
                    imageView.setImageResource(drawable);
                }


            }
        });
    }

    public void findViews(){
        imageView = (ImageView) findViewById(R.id.birthday_card);
        spinner = (Spinner) findViewById(R.id.month_spinner);
        spinner2 = (Spinner) findViewById(R.id.day_spinner);
    }

    public void initListeners(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String month = (String) adapter.getItem(position);
                Log.d(TAG, "Month selected was " + month);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "User selected nothing");
            }
        });
    }

    public Integer[] makeArrayOfDays(){
        Integer[] numArr = new Integer[31];
        for (int i = 0; i < numArr.length; i++){
            numArr[i] = i+1;
        }
        return numArr;
    }

}
