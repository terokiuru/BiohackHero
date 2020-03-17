package com.example.biohackhero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class VisualizeWeight extends AppCompatActivity {

    LineChart lineChart;

    myWeightDatabase myData;
    SQLiteDatabase sqLiteDatabase;

    LineDataSet lineDataSet = new LineDataSet(null,null);
    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
    LineData lineData;

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualize_weight);

        lineChart = findViewById(R.id.weightChart);
        lineDataSet.setLineWidth(4);

        myData = new myWeightDatabase(this);


        exqShowBtn();
    }

    private void exqShowBtn() {
        lineDataSet.setValues(getDataValues());
        lineDataSet.setLabel("Set 1");
        dataSets.clear();
        dataSets.add(lineDataSet);
        lineData = new LineData(dataSets);
        lineChart.clear();
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    private ArrayList<Entry> getDataValues() {
        sqLiteDatabase = myData.getReadableDatabase();

        ArrayList<Entry> dataVals = new ArrayList<>();

        Cursor cr = sqLiteDatabase.rawQuery("Select * from weight", null);

        StringBuilder str = new StringBuilder();
        int i = 0;

        while (cr.moveToNext()) {
            String s0 = cr.getString(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            str.append(s0+"    "+s1+"   "+s2+" \n");
            dataVals.add(new Entry(i, Float.parseFloat(s2)));
            i = i+1;
        }

        Log.i("Database", str.toString());
//        String[] columns = {"date", "weight"};
//        Cursor cursor = sqLiteDatabase.query("weight", columns, null,null, null,null,null);
//
//        for(int i=0; i<cursor.getCount();i++) {
//            cursor.moveToNext();
////            dataVals.add(new Entry(i, i));
//
//            dataVals.add(new Entry(i, i));
//        }

//        for(int i=0; i<cursor.getCount();i++) {
//            cursor.moveToNext();
//            dataVals.add(new Entry(cursor.getFloat(0), cursor.getFloat(1)));
//        }
        return dataVals;

    }
}
