package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Accelerometers extends AppCompatActivity implements SensorEventListener {


     Sensor accelerometer;
     SensorManager sensorManager;
     TextView xText, yText, zText;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            xText = (TextView) findViewById(R.id.xText);
            yText = (TextView) findViewById(R.id.yText);
            zText = (TextView) findViewById(R.id.zText);



        }

    protected void onResume() {
        super.onResume();

    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
            xText.setText("X:" + event.values[0]);
            yText.setText("Y:" + event.values[1]);
            zText.setText("Z:" + event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
