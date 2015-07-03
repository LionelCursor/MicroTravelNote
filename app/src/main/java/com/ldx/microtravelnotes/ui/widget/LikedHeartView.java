package com.ldx.microtravelnotes.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;

import com.ldx.microtravelnotes.R;

/**
 * USER: ldx
 * DATE: 2015-06-21
 * EMAIL: danxionglei@foxmail.com
 * PROJECT: MicroTravelNotes
 */
public class LikedHeartView extends ImageView implements Checkable {

    boolean isLiked;

    public LikedHeartView(Context context) {
        super(context);
        init();
    }

    public LikedHeartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LikedHeartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        this.setImageResource(R.mipmap.heart_1);
    }


    @Override
    public void setChecked(boolean checked) {
        if (checked) {
            check();
        } else {
            uncheck();
        }
    }


    public void check() {
        this.setImageResource(R.mipmap.heart_2);
        isLiked = true;
    }

    public void uncheck() {
        this.setImageResource(R.mipmap.heart_1);
        isLiked = false;
    }

    @Override
    public boolean isChecked() {
        return isLiked;
    }

    @Override
    public void toggle() {
        if (isLiked) {
            uncheck();
        } else {
            check();
        }
    }
}
