package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myList;

    public void table(int timesTableNumber){
        ArrayList<String> numbers = new ArrayList<String>();
        for(int j =1; j<=50;j++){
            numbers.add(Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,numbers);
        myList.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final SeekBar seekBar =  findViewById(R.id.seekBar);
        myList =  findViewById(R.id.myList);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        table(5);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber =1;
                if(i<min){
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                }else{
                    timesTableNumber = i;
                }
               // Log.i("Value",Integer.toString(timesTableNumber));
                table(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}