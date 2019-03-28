package com.example.android_dev.testapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class LineChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        LineChartView lineChartView = findViewById(R.id.lineChart);

        String[] xAxisData = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        int[] yAxisData = {50, 20, 15, 30, 20, 60, 15, 40, 45, 10, 90, 18};

        List yAxisValues = new ArrayList();
        List xAxisValues = new ArrayList();

        //Line line = new Line(yAxisValues);
        Line line = new Line(yAxisValues).setColor(Color.parseColor("#9C27B0")); //set up the line color
        for(int i = 0; i < xAxisData.length; i++){
            xAxisValues.add(i, new AxisValue(i).setLabel(xAxisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++){
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }
        List lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

        lineChartView.setLineChartData(data);

        Axis axis = new Axis();
        axis.setValues(xAxisValues);
        data.setAxisXBottom(axis);
        axis.setName("Month in Year");
        axis.setTextSize(16);
        axis.setTextColor(Color.parseColor("#03A9F4"));

        Axis yAxis = new Axis();
        data.setAxisYLeft(yAxis);
        yAxis.setName("Sales in millions");
        yAxis.setTextSize(16);
        yAxis.setTextColor(Color.parseColor("#03A9F4"));

        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top =110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);

        lineChartView.setInteractive(true);
        lineChartView.setZoomType(ZoomType.HORIZONTAL_AND_VERTICAL);
        lineChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
    }
    private void lineChartFromMpLibrary(){

        LineChart lineChart = findViewById(R.id.lineChart);

        List<Entry> valsComp1 = new ArrayList<>();
        List<Entry> valsComp2 = new ArrayList<>();

        Entry c1e1 = new Entry(0f, 333f); // 0 == quarter 1
        valsComp1.add(c1e1);
        Entry c1e2 = new Entry(1f, 222f); // 1 == quarter 2 ...
        valsComp1.add(c1e2);
        Entry c1e4 = new Entry(0f, 250f); // 1 == quarter 2 ...
        valsComp1.add(c1e4);
        Entry c1e3 = new Entry(1f, 350f); // 1 == quarter 2 ...
        valsComp1.add(c1e3);
        // and so on ...

        Entry c2e1 = new Entry(0f, 444f); // 0 == quarter 1
        valsComp2.add(c2e1);
        Entry c2e2 = new Entry(1f, 111f); // 1 == quarter 2 ...
        valsComp2.add(c2e2);
        Entry c2e3 = new Entry(1f, 350f); // 1 == quarter 2 ...
        valsComp2.add(c2e3);

        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);

        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2");
        setComp2.setColor(Color.BLACK);
        setComp2.setAxisDependency(YAxis.AxisDependency.LEFT);

        // use the interface ILineDataSet
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(setComp1);
        dataSets.add(setComp2);

        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate(); // refresh
    }
}
