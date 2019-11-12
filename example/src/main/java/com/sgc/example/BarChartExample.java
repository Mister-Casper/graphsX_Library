package com.sgc.example;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sgc.graphslibrary.data.BarChartData;
import com.sgc.graphslibrary.data.GroupBarChartData;
import com.sgc.graphslibrary.diagram.VerticalBarChart;
import com.sgc.graphslibrary.legend.LegendView;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BarChartExample extends Fragment {


    @BindView(R.id.legend)
    LegendView legend;
    private Unbinder unbinder;

    @BindView(R.id.barChart)
    VerticalBarChart barChart;

    public BarChartExample() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bar_chart_example, container, false);
        unbinder = ButterKnife.bind(this, view);

        barChart.setData(getGroupBarChartData());
        legend.connectToView(barChart);

        return view;
    }

    int blue = Color.rgb(1, 87, 155);
    int violet = Color.rgb(74, 20, 140);
    int green = Color.rgb(27, 94, 32);
    int orange = Color.rgb(230, 81, 0);
    String blueDescription = "A";
    String violetDescription = "B";
    String greenDescription = "C";
    String orangeDescription = "D";


    private ArrayList<GroupBarChartData> getGroupBarChartData() {
        ArrayList<BarChartData> data = new ArrayList<>();
        data.add(new BarChartData(blue, 10,blueDescription));
        data.add(new BarChartData(violet, 50,violetDescription));
        data.add(new BarChartData(green, 15,greenDescription));
        data.add(new BarChartData(orange, 10,orangeDescription));

        ArrayList<BarChartData> data1 = new ArrayList<>();
        data1.add(new BarChartData(orange, 10,orangeDescription));
        data1.add(new BarChartData(green, 15,greenDescription));
        data1.add(new BarChartData(blue, 15,blueDescription));
        data1.add(new BarChartData(violet, 40,violetDescription));

        ArrayList<BarChartData> data2 = new ArrayList<>();
        data2.add(new BarChartData(orange, 10,orangeDescription));

        ArrayList<GroupBarChartData> groups = new ArrayList<>();
        groups.add(new GroupBarChartData(data, GroupBarChartData.locationHorizontal, "Автомобили"));
        groups.add(new GroupBarChartData(data1, GroupBarChartData.locationVertical, "Корабли"));
        groups.add(new GroupBarChartData(data2, GroupBarChartData.locationHorizontal, "Самолеты"));
        groups.add(new GroupBarChartData(data1, GroupBarChartData.locationVertical, "Велосипеды"));

        return groups;
    }

}
