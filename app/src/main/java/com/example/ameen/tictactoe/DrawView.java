package com.example.ameen.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Ameen on 17-Apr-2015.
 */
public class DrawView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    float startX = 0;
    float startY = 0;
    float stopX = 0;
    float stopY = 0;


    public DrawView(Context context) {
        super(context);

        paint.setColor(Color.RED);
        paint.setAlpha(255);
        paint.setStrokeWidth(20);
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);

    }

    public void setStartX(float startX) {
        this.startX = startX;
    }

    public void setStartY(float startY) {
        this.startY = startY;
    }

    public void setStopX(float stopX) {
        this.stopX = stopX;
    }

    public void setStopY(float stopY) {
        this.stopY = stopY;
    }

    public void setLine(float startX, float startY, float stopX, float stopY) {
        this.startX = startX;
        this.stopX = stopX;
        this.startY = startY;
        this.stopY = stopY;

    }


}
