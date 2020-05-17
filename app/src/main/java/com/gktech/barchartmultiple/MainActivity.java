package com.gktech.barchartmultiple;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;

    ArrayList<BarEntry> barEntries1;
    ArrayList<BarEntry> barEntries2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart=findViewById(R.id.bar_chart);
        barEntries1=new ArrayList<>();
        barEntries2=new ArrayList<>();
        fillBarEntries1();
        fillBarEntries2();

      fillChart();

    }

    @Override
    public void onBackPressed() {

        finishAffinity();
        super.onBackPressed();
    }

    private void fillChart() {
        BarDataSet barDataSet1=new BarDataSet(barEntries1,"DataSet 1");
        barDataSet1.setColor(Color.BLACK);
        BarDataSet barDataSet2=new BarDataSet(barEntries2,"DataSet 2");
        barDataSet2.setColor(Color.parseColor("#D32F2F"));
        BarData barData=new BarData(barDataSet1,barDataSet2);
        barChart.setData(barData);

        String days[]=new String[]{"saturday","sunday","monday","tuesday"};

        XAxis xAxis=barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(days));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);

        barChart.setDragEnabled(true);
        barChart.setVisibleXRangeMaximum(3);

        float barspace=0.08f;
        float groupspace=0.44f;
        barData.setBarWidth(0.02f);
        barChart.getXAxis().setAxisMinimum(0);

        barChart.getXAxis().setAxisMaximum(0+barChart.getBarData().getGroupWidth(groupspace,barspace)*4);
        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.groupBars(0,groupspace,barspace);
        barChart.invalidate();
    }

    private void fillBarEntries1() {
        barEntries1.add(new BarEntry(1,2000));
        barEntries1.add(new BarEntry(2,791));
        barEntries1.add(new BarEntry(3,630));
        barEntries1.add(new BarEntry(4,782));
    }

    private void fillBarEntries2() {
        barEntries2.add(new BarEntry(1,991));
        barEntries2.add(new BarEntry(2,791));
        barEntries2.add(new BarEntry(3,1030));
        barEntries2.add(new BarEntry(4,382));
    }

}
