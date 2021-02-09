package com.example.expandandcollapse.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.expandandcollapse.R;


public class Frag1 extends Fragment {
    private int layoutheight;
    private View v;

    public Frag1(int layoutheight, View v) {
        this.layoutheight = layoutheight;
        this.v = v;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        LinearLayout frag1Layout = view.findViewById(R.id.frag1Layout);
        frag1Layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, layoutheight));
        frag1Layout.addView(v);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}