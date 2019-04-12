package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

public class Accelerometers extends AppCompatActivity implements SensorEventListener {


     private Sensor accelerometer;
     private SensorManager sensorManager;
     private TextView xText, yText, zText;

        Vibrator vibrator;
        View view;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_accelerometers);

            sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            xText = (TextView)findViewById(R.id.xText);
            yText = (TextView)findViewById(R.id.yText);
            zText = (TextView)findViewById(R.id.zText);

            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            view = this.getWindow().getDecorView();
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


        if(event.values[0] < 0) {
            view.setBackgroundResource(R.color.green);
            vibrator.vibrate(150);
        }else{
            view.setBackgroundResource(R.color.pink);

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
