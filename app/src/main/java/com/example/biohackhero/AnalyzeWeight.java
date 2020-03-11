package com.example.biohackhero;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalyzeWeight extends AppCompatActivity {

    Button load_button;
    myWeightDatabase myData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze_weight);

        load_button = findViewById(R.id.loadButton);
        myData = new myWeightDatabase(this);

        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_data();
            }
        });

    }

    private void load_data() {
        myData.getAll();
    }


}
