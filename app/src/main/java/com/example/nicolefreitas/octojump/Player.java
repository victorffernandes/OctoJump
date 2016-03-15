package com.example.nicolefreitas.octojump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Nicole.Freitas on 15/03/2016.
 */
public class Player {

    public int x;
    public int y;
    public int w;
    public int h = 3;
    public Context ctx;

    public Paint p;

    public Player(int x1, int y1,Context c){
        x = x1;
        y = y1;
        ctx = c;
    }

    public void Draw(Canvas canvas)
    {
        p=new Paint();
        Bitmap b= BitmapFactory.decodeResource(ctx.getResources(), R.drawable.poloovo);
        //b.setHeight(h);
        p.setColor(Color.RED);
        canvas.drawBitmap(b, x, y, p);
    }

    public void Update()
    {
    }

}
