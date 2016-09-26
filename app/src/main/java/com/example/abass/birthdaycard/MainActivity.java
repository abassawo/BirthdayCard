package com.example.abass.birthdaycard;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayAdapter adapter;
    Spinner spinner;
    Spinner spinner2;
    Integer[] days;
    private static String TAG = "MainActivity";
    int currentDrawableIdx;

    private ImageView imageView;
    private Button button;


    public void findViews(){
        button = (Button) findViewById(R.id.btn);
        imageView = (ImageView) findViewById(R.id.birthday_card);
        spinner = (Spinner) findViewById(R.id.month_spinner);
        spinner2 = (Spinner) findViewById(R.id.day_spinner);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        currentDrawableIdx = 0;
        String[] months = getResources().getStringArray(R.array.string_array_months);
        adapter = new ArrayAdapter(MainActivity.this, R.layout.text_layout, months);
        spinner.setAdapter(adapter);
        days = makeArrayOfDays();
        ArrayAdapter dayAdapter = new ArrayAdapter(this, R.layout.text_layout, days);
        spinner2.setAdapter(dayAdapter);


        final int[] resDrawables = new int[]{R.drawable.image_jan, R.drawable.image_feb};
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "User clicked the bday card image");
//                //Change background color of my img
//                int drawable;
//                if(currentDrawableIdx == resDrawables.length - 1){
////                    currentDrawableIdx = 0;
////                    drawable = resDrawables[currentDrawableIdx];
//                    imageView.setImageResource(android.R.color.background_dark);
//                }else{
//                    currentDrawableIdx = currentDrawableIdx + 1;
//                    drawable = resDrawables[currentDrawableIdx];
//                    imageView.setImageResource(drawable);
//                }
//
//
//            }
//        });
        initListeners();
    }



    public void initListeners(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String month = (String) adapter.getItem(position);
                Log.d(TAG, "Month selected was " + month);

                switch(month){
                    case "jan": //january
                        imageView.setImageResource(R.drawable.image_jan);
                        break;
                    case "feb": //feb:
                        imageView.setImageResource(R.drawable.image_feb);
                        break;
                    case "March":
                        imageView.setImageResource(R.drawable.march_img);
                        break;
                    case "April":
                        imageView.setImageResource(R.drawable.april_img);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "User selected nothing");
            }
        });

        button.setOnClickListener(this);
        // assigning MainActivity.class as my on-click listener.
        // MainActivity implements OnCLickListener interface

    }

    public Integer[] makeArrayOfDays(){
        Integer[] numArr = new Integer[31];
        for (int i = 0; i < numArr.length; i++){
            numArr[i] = i+1;
        }
        return numArr;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.birthday_card:   Log.d(TAG, "User clicked the bday card image");
                //Change background color of my img
                int drawable;
                if(currentDrawableIdx == 0){
//                    currentDrawableIdx = 0;
//                    drawable = resDrawables[currentDrawableIdx];
                    imageView.setImageResource(android.R.color.background_dark);
                }else{
                    currentDrawableIdx = currentDrawableIdx + 1;
//                    drawable = resDrawables[currentDrawableIdx];
//                    imageView.setImageResource(drawable);
                }
                break;
            case R.id.btn:
                Intent intent = new Intent(this, CalActivity.class);
                startActivity(intent);

        }
    }
}
