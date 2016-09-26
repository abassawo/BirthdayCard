package com.example.abass.birthdaycard;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;

/**
 * Created by Abass on 9/25/16.
 */

public class MySpinnerAdapter extends BaseAdapter {
    private String[] arr;


    public MySpinnerAdapter(String[] arr){
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int position) {
        return arr[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        return view;
    }
}
