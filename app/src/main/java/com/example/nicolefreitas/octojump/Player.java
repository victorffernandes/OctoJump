package com.example.nicolefreitas.octojump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Nicole.Freitas on 15/03/2016.
 */
public class Player {
    public int x;
    public int y;
    public int w = 50;
    public int h = 50;
    public static int g = 10;
    public Context ctx;
    public Paint p;

    public Player(int x1, int y1,Context c){
        x = x1;
        y = y1;
        ctx = c;
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
    {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }

    public void Draw(Canvas canvas)
    {
        p=new Paint();
        Bitmap b = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.poloovo);
        b = getResizedBitmap(b,h,w);
        //b.setHeight(h);
        p.setColor(Color.RED);
        canvas.drawBitmap(b, x, y, p);
    }

    boolean Col(int x1,int y1,int w1, int h1)
    {
        return ((x + w >= x1) && (y + h >= y1) && x <= x1 + w1 && y <= y1 + h1);
    }

    public void Update(int cW,int cH, ArrayList<Platform> pList)
    {
        if(Col(0,cH - h,cW,0))
        {
            g = -20;
        }

        for(Platform p : pList)
        {
            if((Col(p.x,p.y,p.w,p.h)) && (g >= 0))
            {
                g = -20;
            }
        }

        if(!GameView.movControl)
        {
            y += g;
        }
        g += 1;
        x += MainActivity.y * 10;
    }

}
