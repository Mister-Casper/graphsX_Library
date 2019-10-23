package com.sgc.example;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sgc.graphslibrary.data.PieChartData;
import com.sgc.graphslibrary.diagram.PieChart;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PieChartExampleFragment extends Fragment {

    private Unbinder unbinder;

    @BindView(R.id.testDiagram)
    PieChart testDiagram;

    public PieChartExampleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pie_chart_example, container, false);
        unbinder = ButterKnife.bind(this, view);
        ArrayList<PieChartData> data = new ArrayList<>();

        PieChartData blue = new PieChartData(50, Color.rgb(1, 87, 155), "синий");
        blue.setClickListener(new PieChartData.clickSectorListener() {
            @Override
            public void click() {
                Toast.makeText(getContext(),"Синий", Toast.LENGTH_SHORT).show();
            }
        });
        data.add(blue);
        PieChartData violet = new PieChartData(50, Color.rgb(74, 20, 140), "фиолетовый");
        violet.setClickListener(new PieChartData.clickSectorListener() {
            @Override
            public void click() {
                Toast.makeText(getContext(),"Фиолетовый", Toast.LENGTH_SHORT).show();
            }
        });
        data.add(violet);
        PieChartData orange = new PieChartData(50, Color.rgb(230, 81, 0), "оранжевый");
        orange.setClickListener(new PieChartData.clickSectorListener() {
            @Override
            public void click() {
                Toast.makeText(getContext(),"Оранжевый", Toast.LENGTH_SHORT).show();
            }
        });
        data.add(orange);
        PieChartData green = new PieChartData(50, Color.rgb(27, 94, 32), "зелёный");
        green.setClickListener(new PieChartData.clickSectorListener() {
            @Override
            public void click() {
                Toast.makeText(getContext(),"Зелёный", Toast.LENGTH_SHORT).show();
            }
        });
        data.add(green);

        testDiagram.setData(data);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
