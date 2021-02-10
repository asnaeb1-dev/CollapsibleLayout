package com.example.expandandcollapse;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import com.example.expandandcollapse.Custom.ExpandableLinearLayout;


import java.util.List;

public class Accordian  {

    private Context context;
    private List<ExpandableLinearLayout> children;
    private int titleHeight;
    private int duration;

    //for local use
    private ViewGroup activeView;
    private String ERROR_MESSAGE = "ERROR";

    public Accordian(Context context, List<ExpandableLinearLayout> children, int titleHeight, int duration) {
        this.context = context;
        this.children = children;
        this.titleHeight = titleHeight;
        this.duration = duration;
    }

    //handles the target height or the height after expansion
    private int handleTargetHeight(int lh, int pos){
        switch (pos){
            case 0:
            case 1:
            case 2:
                return lh - (titleHeight * (pos + 1));
            case 3:
                return lh - (titleHeight * (pos ));
            default:
                return lh - (titleHeight * (pos + 1));
        }
    }

    //configures each and every layout and attaches them to a parent linear layout and send the reference back to the caller class
    public ViewGroup designLayout(){
        if(children.size() < 2 || children.size() > 4){
            Log.e(ERROR_MESSAGE, "MINIMUM TWO CHILD VIEWS ARE EXPECTED. MAXIMUM 4 CHILD VIEWS ARE SUPPORTED.");
            return new LinearLayout(context);
        }
        Log.i("SIZE", String.valueOf(children.size()));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        for (int i = 0; i < children.size(); i++) {
            ExpandableLinearLayout layout = children.get(i);
            int finalI = i;
            layout.setOnClickListener(v -> {
                children.forEach(thisLayout -> {
                    if (layout != thisLayout) {
                        if (thisLayout.isExpanded()) {
                            thisLayout.collapse(thisLayout, 1000, 300, (view) -> {
                                thisLayout.removeAllViews();
                                thisLayout.addView(thisLayout.getCollapsedLayout());
                                thisLayout.setExpanded(false);
                            });
                        }
                    }
                });
                if (!layout.isExpanded()) {
                    layout.expand(v, 1000, handleTargetHeight(linearLayout.getHeight(), finalI), (view) -> {
                        Log.i("STATE", "EXPANDED");
                        layout.removeAllViews();
                        layout.addView(layout.getExpandedLayout());
                        layout.setExpanded(true);
                    });
                } else {
                    layout.collapse(v, 1000, 300, (view) -> {
                        Log.i("STATE", "COLLAPSED");
                        layout.removeAllViews();
                        layout.addView(layout.getCollapsedLayout());
                        layout.setExpanded(false);
                    });
                }
            });
            linearLayout.addView(layout);
        }
        return linearLayout;
    }

}
