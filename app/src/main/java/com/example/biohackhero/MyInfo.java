package com.example.biohackhero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MyInfo extends AppCompatActivity {

    EditText height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);

        height = (EditText)findViewById(R.id.enter_height);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh1 = getSharedPreferences("MyOwnShared", MODE_APPEND);
        int a1 = sh1.getInt("height",0);

        height.setText(String.valueOf(a1));
    }


    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sh = getSharedPreferences("MyOwnShared", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sh.edit();
        myEdit.putInt("height", Integer.parseInt(height.getText().toString()));
        myEdit.commit();
    }
}
