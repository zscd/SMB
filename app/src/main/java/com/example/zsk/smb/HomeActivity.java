package com.example.zsk.smb;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zsk.smb.custom.LineChartManager;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import java.util.ArrayList;
import java.util.List;
import com.example.zsk.smb.custom.BarChartManager;

public class HomeActivity extends AppCompatActivity {

    private BarChart mBarChart;                                    //第一个图
    private LineChart mLineChart;   //心率图
    private LineChart mLineChart2;  //呼吸图
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mBarChart = (BarChart) findViewById(R.id.smb_homeactivity_barchart_conditions);
        mLineChart = (LineChart) findViewById(R.id.smb_homeactivity_LineChart_heartrate);
        mLineChart2 = (LineChart) findViewById(R.id.smb_homeactivity_LineChart_breath);

        BarChartManager barChartManager1 = new BarChartManager(mBarChart);
        LineChartManager lineChartManager = new LineChartManager(mLineChart);
        LineChartManager lineChartManager2 = new LineChartManager(mLineChart2);

        //设置x轴的数据
        List<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            xValues.add((float) i);
        }

        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Float> yValue = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                yValue.add((float) (Math.random() * 80));
            }
            yValues.add(yValue);
        }
        List<Integer> colours = new ArrayList<>();
        colours.add(Color.GREEN);
        colours.add(Color.BLUE);
        colours.add(Color.RED);
        colours.add(Color.CYAN);

        //线的名字集合
        List<String> names = new ArrayList<>();
        names.add("折线一");
        names.add("折线二");
        names.add("折线三");
        names.add("折线四");

        barChartManager1.showBarChart(xValues, yValues, names, colours);
        barChartManager1.setXAxis(11f, 0f, 11);
        barChartManager1.setDescription("总情况");
        lineChartManager.showLineChart(xValues,yValues.get(0),names.get(1),colours.get(3));
        lineChartManager.setDescription("心率");
        lineChartManager.setYAxis(100,0,11);
        lineChartManager.setHightLimitLine(90,"高心率报警",Color.RED);
        lineChartManager.setLowLimitLine(50,"低心率报警");
        lineChartManager2.showLineChart(xValues,yValues.get(1),names.get(2),colours.get(2));
        lineChartManager2.setYAxis(100,0,11);
        lineChartManager2.setDescription("呼吸");
        lineChartManager2.setHightLimitLine(50,"高呼吸次数",Color.RED);
        lineChartManager2.setLowLimitLine(20,"低呼吸次数");

    }

}
