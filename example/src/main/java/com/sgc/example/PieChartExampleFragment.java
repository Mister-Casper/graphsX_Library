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

import com.sgc.graphslibrary.data.PieChartData;
import com.sgc.graphslibrary.diagram.PieChart;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PieChartExampleFragment extends Fragment {

    Unbinder unbinder;

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

        data.add(new PieChartData(50, Color.rgb(1, 87, 155), "синий"));
        data.add(new PieChartData(50, Color.rgb(74, 20, 140), "фиолетовый"));
        data.add(new PieChartData(50, Color.rgb(230, 81, 0), "оранжевый"));
        data.add(new PieChartData(50, Color.rgb(27, 94, 32), "зелёный"));

        testDiagram.setData(data);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
