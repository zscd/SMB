package com.example.zsk.smb.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;;import com.example.zsk.smb.ByStagesData;
import com.example.zsk.smb.ByStagesView;
import com.example.zsk.smb.R;
import com.example.zsk.smb.custom.LineChartManager;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsk on 2018/3/28.
 */

public class DayDetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.smb_detail_day_fragment,null);
        LineChart lineChart_1 = (LineChart)view.findViewById(R.id.smb_homeactivity_LineChart_heartrate);
        LineChart lineChart_2 = (LineChart)view.findViewById(R.id.smb_homeactivity_LineChart_breath);

        LineChartManager lineChartManager1 = new LineChartManager(lineChart_1);
        LineChartManager lineChartManager2 = new LineChartManager(lineChart_2);

        ByStagesView bs = (ByStagesView) view.findViewById(R.id.test_bs);
        ByStagesData bsd = new ByStagesData();
        bsd.setStart("21:30");
        bsd.setEnd("7:30");
        bsd.setStime(new float[]{15, (float)60.5, 56, 78 , 156, 5, 56});
        bsd.setSvalue(new int[]{1,2,1,2,1,0,1});
        bs.setData(bsd);


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

        lineChartManager1.showLineChart(xValues,yValues.get(0),names.get(1),colours.get(3));
        lineChartManager1.setDescription("心率");
        lineChartManager1.setYAxis(150,0,0);
       // lineChartManager1.setHightLimitLine(90,"高心率报警",Color.RED);
        //lineChartManager1.setLowLimitLine(50,"低心率报警");
        lineChartManager2.showLineChart(xValues,yValues.get(1),names.get(2),colours.get(3));
        lineChartManager2.setYAxis(100,0,0);
        lineChartManager2.setDescription("呼吸");
        //lineChartManager2.setHightLimitLine(50,"高呼吸次数",Color.RED);
        //lineChartManager2.setLowLimitLine(20,"低呼吸次数");

        return view;
    }
}
