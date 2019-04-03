package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonOnClick(View v){
        // do someating when the button is clicked
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Activity2.class));
    }

    public void buttonOnClick2(View v){
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), Activity3.class));

    }


}
