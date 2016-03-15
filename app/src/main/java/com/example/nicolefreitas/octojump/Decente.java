package com.example.nicolefreitas.octojump;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.os.Handler;



public class Decente extends View implements Runnable{
    public Context ctx;
    public Paint p;
    public Handler handler = new Handler();
    float x = 0;
    float y = 0;
    public Decente (Context c){
        super(c);
        init();
    }

    private void init()
    {
        p = new Paint();
        p.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        x+=15;
        y+=15;
        invalidate();
        canvas.drawCircle(x, y, 30, p);
    }
    @Override
    public void run(){
        handler.postDelayed(this,30);
        invalidate();

    }
}
