package com.example.expandandcollapse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.expandandcollapse.Custom.ExpandableLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout main;
    List<ExpandableLinearLayout> layouts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.mainLayout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //call the fucntion
        createNewLayouts();

        //make an object
        Accordian accordian = new Accordian(this, layouts, 300, 1000);
        main.addView(accordian.designLayout());

    }

    //create each and every layout min- 2 ; max - 4
    public void createNewLayouts() {
        ExpandableLinearLayout expandableLinearLayout1 = new ExpandableLinearLayout(this);
        expandableLinearLayout1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout1.setOrientation(LinearLayout.VERTICAL);
        expandableLinearLayout1.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
        expandableLinearLayout1.setCollapsedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.title, null));
        expandableLinearLayout1.setExpandedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.description, null));

        ExpandableLinearLayout expandableLinearLayout2 = new ExpandableLinearLayout(this);
        expandableLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        expandableLinearLayout2.setOrientation(LinearLayout.VERTICAL);
        expandableLinearLayout2.setCollapsedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.title, null));
        expandableLinearLayout2.setExpandedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.description, null));


        ExpandableLinearLayout expandableLinearLayout3 = new ExpandableLinearLayout(this);
        expandableLinearLayout3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout3.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        expandableLinearLayout3.setCollapsedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.title, null));
        expandableLinearLayout3.setExpandedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.description, null));
        expandableLinearLayout3.setOrientation(LinearLayout.VERTICAL);

        ExpandableLinearLayout expandableLinearLayout4 = new ExpandableLinearLayout(this);
        expandableLinearLayout4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout4.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        expandableLinearLayout4.setCollapsedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.title, null));
        expandableLinearLayout4.setExpandedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.description, null));
        expandableLinearLayout4.setOrientation(LinearLayout.VERTICAL);

        ExpandableLinearLayout expandableLinearLayout5 = new ExpandableLinearLayout(this);
        expandableLinearLayout5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout5.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        expandableLinearLayout5.setCollapsedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.title, null));
        expandableLinearLayout5.setExpandedLayout((ViewGroup) LayoutInflater.from(this).inflate(R.layout.description, null));
        expandableLinearLayout5.setOrientation(LinearLayout.VERTICAL);

        layouts.add(expandableLinearLayout1);
        layouts.add(expandableLinearLayout2);
        layouts.add(expandableLinearLayout3);
        layouts.add(expandableLinearLayout4);
        layouts.add(expandableLinearLayout5);
    }
}