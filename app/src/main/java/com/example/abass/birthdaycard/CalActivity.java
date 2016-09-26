package com.example.abass.birthdaycard;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CalActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter adapter;
    private static String TAG = CalActivity.class.getSimpleName();
    private TextView helloTV;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal);
        listView = (ListView) findViewById(R.id.list_view);
        helloTV = (TextView) findViewById(R.id.hello_tv);
       TypedArray images = getResources().obtainTypedArray(R.array.Drawablezzz);
        int img1 = images.getInt(2, 0);
        imageView.setImageResource(img1);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String language = (String) adapter.getItem(position);
                Log.d(TAG, "Selected " + language);
                Toast.makeText(CalActivity.this, language, Toast.LENGTH_SHORT).show();
                switch(position){
                    case 0: helloTV.setText(R.string.hello_en);
                        break;
                    case 1: helloTV.setText(R.string.hello_fr);
                        break;
                    case 2: helloTV.setText(R.string.hello_sp);
                        break;
                    case 3: helloTV.setText(R.string.catalan);
                        break;
                }
            }

        });
    }
}
