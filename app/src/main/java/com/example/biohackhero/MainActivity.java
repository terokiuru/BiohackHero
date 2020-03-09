package com.example.biohackhero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
//public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addMeasurement(View view) {
        Intent i1 = new Intent(this, addMeasurement.class);
        startActivity(i1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    public void openInfo(MenuItem item) {
        Intent i1 = new Intent(this, MyInfo.class);
        startActivity(i1);
    }


}
