package com.example.expandandcollapse.Custom;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

public class ExpandableLinearLayout extends LinearLayout {

    private boolean isExpanded;
    private ViewGroup expandedLayout, collapsedLayout;

    public ExpandableLinearLayout(Context context) {
        super(context);
    }


    public void expand(final View v, int duration, int targetHeight, OnExpandListener expand) {
        int prevHeight  = v.getHeight();
        v.setVisibility(View.VISIBLE);
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.addUpdateListener(animation -> {
            v.getLayoutParams().height = (int) animation.getAnimatedValue();
            v.requestLayout();
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
        expand.OnExpand(this);

    }

    public void collapse(final View v, int duration, int targetHeight, OnCollapseListener collapseListener) {
        int prevHeight  = v.getHeight();
        ValueAnimator valueAnimator = ValueAnimator.ofInt(prevHeight, targetHeight);
        valueAnimator.addUpdateListener(animation -> {
            v.getLayoutParams().height = (int) animation.getAnimatedValue();
            v.requestLayout();
        });
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.setDuration(duration);
        valueAnimator.start();
        collapseListener.OnCollapse(v);
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public ViewGroup getExpandedLayout() {
        return expandedLayout;
    }

    public void setExpandedLayout(ViewGroup expandedLayout) {
        this.expandedLayout = expandedLayout;
    }

    public ViewGroup getCollapsedLayout() {
        return collapsedLayout;
    }

    public void setCollapsedLayout(ViewGroup collapsedLayout) {
        this.collapsedLayout = collapsedLayout;
    }

}
