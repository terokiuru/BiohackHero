package com.example.biohackhero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AnalyzeWeight extends AppCompatActivity {

    Button load_button;
    Button erase_button;
    myWeightDatabase myData;


//    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze_weight);

        load_button = findViewById(R.id.loadButton);
        erase_button = findViewById(R.id.eraseWeight);
        myData = new myWeightDatabase(this);

        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load_data();
            }
        });
        erase_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                erase_data();
            }
        });
    }

    private void load_data() {
        myData.getAll();
    }

    private void erase_data() {
        String get_id = "1";
        myData.deleteItem();
    }

}
