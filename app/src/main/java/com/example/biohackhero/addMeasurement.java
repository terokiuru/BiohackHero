package com.example.biohackhero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class addMeasurement extends AppCompatActivity {
//public class addMeasurement extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_measurement);
    }

    public void addWeight(View view) {
        Intent i1 = new Intent(this, addWeight.class);
        startActivity(i1);
    }


}
