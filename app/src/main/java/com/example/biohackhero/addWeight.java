package com.example.biohackhero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class addWeight extends AppCompatActivity {

    RadioButton radio_current, radio_select;
    Long time_stamp_ms;
    TextView tv_time;
    EditText tv_weight;
    String dateText = "tmp";
    Button save_button;

    myWeightDatabase myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_weight);

        radio_current = findViewById(R.id.radio_current);
        radio_select = findViewById(R.id.radio_select);
        tv_time = findViewById(R.id.tv_time);
        save_button = findViewById(R.id.saveButton);
        tv_weight = findViewById(R.id.editWeight);

        radio_current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useCurrent();
            }
        });
        radio_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectDate();

            }
        });

        myData = new myWeightDatabase(this);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void useCurrent() {
        time_stamp_ms = System.currentTimeMillis();
        String date = DateFormat.format("dd-MM-yyyy", time_stamp_ms).toString();
        tv_time.setText(date);
    }

    private void selectDate() {
        Calendar calendar = Calendar.getInstance();
        int YEAR = calendar.get(Calendar.YEAR);
        int MONTH = calendar.get(Calendar.MONTH);
        int DATE = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);
                dateText = DateFormat.format("dd-MM-yyyy", calendar1).toString();
                updateText();
            }
        }, YEAR, MONTH, DATE);
        datePickerDialog.show();

    }

    private void updateText() {
        tv_time.setText(dateText);
    }

    private void saveData() {
        String date_tmp = tv_time.getText().toString();

        String weight_tmp = null;
        try {
            weight_tmp = tv_weight.getText().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Toast.makeText(this, date_tmp+" "+weight_tmp, Toast.LENGTH_SHORT).show();
        myData.insertData(date_tmp, weight_tmp);
    }

}
