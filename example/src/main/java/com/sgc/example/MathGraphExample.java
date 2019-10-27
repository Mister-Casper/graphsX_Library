package com.sgc.example;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sgc.graphslibrary.data.MathData;
import com.sgc.graphslibrary.graph.MathGraph;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MathGraphExample extends Fragment {


    @BindView(R.id.math)
    MathGraph math;

    Unbinder unbinder;

    public MathGraphExample() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math_graph_example, container, false);
        unbinder = ButterKnife.bind(this, view);
        ArrayList<MathData> graphs = new ArrayList<>();
        MathData mathData3 = new MathData(50, new MathData.MathFunctionInterface() {
            @Override
            public float function(float x) {
                return (float) Math.sin(x);
            }
        });
        mathData3.setColorGraph(Color.BLUE);
        graphs.add(mathData3);
        math.setFunctions(graphs);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
