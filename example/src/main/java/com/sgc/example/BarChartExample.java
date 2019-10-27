package com.sgc.example;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sgc.graphslibrary.data.BarChartData;
import com.sgc.graphslibrary.data.GroupBarChartData;
import com.sgc.graphslibrary.diagram.VerticalBarChart;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class BarChartExample extends Fragment {

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
        ArrayList<BarChartData> data = new ArrayList<>();
        data.add(new BarChartData(Color.rgb(1, 87, 155), 10));
        data.add(new BarChartData(Color.rgb(74, 20, 140), 50));
        data.add(new BarChartData(Color.rgb(27, 94, 32), 15));
        data.add(new BarChartData(Color.rgb(230, 81, 0), 10));

        ArrayList<BarChartData> data1 = new ArrayList<>();
        data1.add(new BarChartData(Color.rgb(230, 81, 0), 10));
        data1.add(new BarChartData(Color.rgb(27, 94, 32), 15));
        data1.add(new BarChartData(Color.rgb(1, 87, 155), 15));
        data1.add(new BarChartData(Color.rgb(74, 20, 140), 40));

        ArrayList<BarChartData> data2 = new ArrayList<>();
        data2.add(new BarChartData(Color.rgb(230, 81, 0), 10));

        ArrayList<GroupBarChartData> groups = new ArrayList<>();
        groups.add(new GroupBarChartData(data, GroupBarChartData.locationHorizontal, "Автомобили"));
        groups.add(new GroupBarChartData(data1, GroupBarChartData.locationVertical, "Корабли"));
        groups.add(new GroupBarChartData(data2, GroupBarChartData.locationHorizontal, "Корабли"));
        groups.add(new GroupBarChartData(data1, GroupBarChartData.locationVertical, "Корабли"));
        barChart.setData(groups);
        return view;
    }

}
