package com.v0lky1.smoketrainer.views;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.v0lky1.smoketrainer.models.Smoke;

public class ClickCounterView extends android.support.v7.widget.AppCompatTextView {
    private Smoke smoke;

    public ClickCounterView(Context context) {
        super(context);
    }

    public ClickCounterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClickCounterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void currentSmoke(Smoke smoke){
        this.smoke = smoke;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.setText(String.valueOf(smoke.getSeenCounter()));
    }
}
