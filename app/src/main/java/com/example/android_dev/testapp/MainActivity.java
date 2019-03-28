package com.example.android_dev.testapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "rasel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // LineChart lineChart = findViewById(R.id.chart);
    }

    public void barChartClicked(View view) {
        startActivity(new Intent(this, BarChartActivity.class));
    }

    public void pieChartClicked(View view) {
        startActivity(new Intent(this, PieChartActivity.class));
    }

    public void stackedBarChartClicked(View view) {
    }

    public void lineClicked(View view) {
        startActivity(new Intent(this, LineChartActivity.class));
    }
}
