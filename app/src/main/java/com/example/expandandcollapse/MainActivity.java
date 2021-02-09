package com.example.expandandcollapse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.expandandcollapse.Custom.ExpandableLinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private LinearLayout  main;
    List<ExpandableLinearLayout> layouts = new ArrayList<>();

    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.mainLayout);

        createNewLayouts();

        Accordian accordian = new Accordian(this, layouts, 300, 1000);
        main.addView(accordian.designLayout());
    }

    public void createNewLayouts(){
        ExpandableLinearLayout expandableLinearLayout1 = new ExpandableLinearLayout(this);
        expandableLinearLayout1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout1.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
        expandableLinearLayout1.setOrientation(LinearLayout.VERTICAL);

        ExpandableLinearLayout expandableLinearLayout2 = new ExpandableLinearLayout(this);
        expandableLinearLayout2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout2.setBackgroundColor(getResources().getColor(android.R.color.background_dark));
        expandableLinearLayout2.setOrientation(LinearLayout.VERTICAL);

        ExpandableLinearLayout expandableLinearLayout3 = new ExpandableLinearLayout(this);
        expandableLinearLayout3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout3.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        expandableLinearLayout3.setOrientation(LinearLayout.VERTICAL);

        ExpandableLinearLayout expandableLinearLayout4 = new ExpandableLinearLayout(this);
        expandableLinearLayout4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        expandableLinearLayout4.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        expandableLinearLayout4.setOrientation(LinearLayout.VERTICAL);

        layouts.add(expandableLinearLayout1);
        layouts.add(expandableLinearLayout2);
        layouts.add(expandableLinearLayout3);
        layouts.add(expandableLinearLayout4);

//        layouts.add(expandableLinearLayout1);
//        layouts.add(expandableLinearLayout2);
//        layouts.add(expandableLinearLayout3);
//        layouts.add(expandableLinearLayout4);
    }

//    private void populateTitles(){
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        ft.add(R.id.layout1, new FragTitle1(currentHeight));
//        ft.add(R.id.layout2, new FragTitle1(currentHeight));
//        ft.add(R.id.layout3, new FragTitle1(currentHeight));
//        ft.add(R.id.layout4, new FragTitle1(currentHeight));
//
//        ft.commit();
//    }
//    private void handleMainLayouts(int layoutHeight, int parent){
//
//        TextView tv = new TextView(this);
//        tv.setText(getResources().getString(R.string.lorem));
//
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.add(parent, new Frag1(layoutHeight, tv));
//        ft.commit();
//
//    }

//    private void handleClicks(){
//
//        l1.setOnClickListener(v -> {
//            if(activeView != null){
//                for(int i = 0;i<layouts.size();i++){
//                    if(layouts.get(i) == activeView){
//                        Log.i("INDEX___",String.valueOf(i));
//                        collapse(layouts.get(i), 1000, currentHeight);
//                        break;
//                    }
//                }
//            }
//            handleMainLayouts(main.getHeight() - currentHeight, R.id.layout1);
//            expand(l1, 1000, main.getHeight() - currentHeight);
//            activeView = l1;
//        });
//
//        l2.setOnClickListener(v -> {
//            if(activeView != null){
//                for(int i = 0;i<layouts.size();i++){
//                    if(layouts.get(i) == activeView){
//                        Log.i("INDEX___",String.valueOf(i));
//                        collapse(layouts.get(i), 1000, currentHeight);
//                        break;
//                    }
//                }
//            }
//            handleMainLayouts(main.getHeight() - currentHeight * 2, R.id.layout2);
//            expand(l2, 1000, main.getHeight() - currentHeight * 2);
//            activeView = l2;
//        });
//        l3.setOnClickListener(v -> {
//            if(activeView != null){
//                for(int i = 0;i<layouts.size();i++){
//                    if(layouts.get(i) == activeView){
//                        Log.i("INDEX___",String.valueOf(i));
//                        collapse(layouts.get(i), 1000, currentHeight);
//                        break;
//                    }
//                }
//            }
//            handleMainLayouts(main.getHeight() - currentHeight * 3, R.id.layout3);
//            expand(l3, 1000, main.getHeight() - currentHeight * 3);
//            activeView = l3;
//        });
//
//        l4.setOnClickListener(v -> {
//            if(activeView != null){
//                for(int i = 0;i<layouts.size();i++){
//                    if(layouts.get(i) == activeView){
//                        Log.i("INDEX___",String.valueOf(i));
//                        collapse(layouts.get(i), 1000, currentHeight);
//                        break;
//                    }
//                }
//            }
//            handleMainLayouts(main.getHeight() - currentHeight * 3, R.id.layout4);
//            expand(l4, 1000, main.getHeight() - currentHeight * 3);
//            activeView = l4;
//        });
//    }
//
//    public static void expand(final View v, int duration, int targetHeight) {
//        int prevHeight  = v.getHeight();
//        v.setVisibility(View.VISIBLE);
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                v.getLayoutParams().height = (int) animation.getAnimatedValue();
//                v.requestLayout();
//            }
//        });
//        valueAnimator.setInterpolator(new DecelerateInterpolator());
//        valueAnimator.setDuration(duration);
//        valueAnimator.start();
//    }
//
//    public static void collapse(final View v, int duration, int targetHeight) {
//        int prevHeight  = v.getHeight();
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                v.getLayoutParams().height = (int) animation.getAnimatedValue();
//                v.requestLayout();
//            }
//        });
//        valueAnimator.setInterpolator(new DecelerateInterpolator());
//        valueAnimator.setDuration(duration);
//        valueAnimator.start();
//    }
//
//    private ArrayList<String> getList(){
//        String[] s = {"1", "2", "4"};
//        return new ArrayList<>(Arrays.asList(s));
//    }
//
//}
}