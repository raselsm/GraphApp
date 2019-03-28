package com.example.android_dev.testapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        PieChart pieChart = findViewById(R.id.pieChart);

        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(28.5f, "Mango"));
        entries.add(new PieEntry(16.7f, "Apple"));
        entries.add(new PieEntry(24.0f, "Banana"));
        entries.add(new PieEntry(7.8f, "Guava"));

        PieDataSet pieDataSet = new PieDataSet(entries, "      Election Results");
        final int[] MY_COLORS = { Color.rgb(71,105,30), Color.rgb(112,15,71),
                                  Color.rgb(255,0,0), Color.rgb(57,73,171)};
        ArrayList<Integer> colors = new ArrayList<>();

        for(int c: MY_COLORS) colors.add(c);

        pieDataSet.setColors(colors);

        PieData data = new PieData(pieDataSet);
        data.setValueTextSize(18f);
        pieChart.setData(data);
        pieChart.getLegend().setTextColor(Color.BLACK);
        pieChart.invalidate(); // refresh
    }
}
