package com.example.nicolefreitas.octojump;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

public class Platform {
    public int x;
    public int y;
    public int w = 150;
    public int h = 50;

    public Platform(Canvas canvas, int lY){
        x = (new Random()).nextInt(canvas.getWidth() - w);
        y = lY + (new Random()).nextInt(210);
        Log.d("MainActivity",x+":"+y);
    }

    public void Draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        Paint  p=new Paint();
        p.setColor(Color.RED);
        canvas.drawRect(x, y, w + x, h + y, p);
        Paint  b =new Paint();
        p.setColor(Color.BLACK);
        canvas.drawCircle(x, y, 1, b);
        canvas.drawCircle(x + w, y, 1, b);
        canvas.drawCircle(x, y +  h, 1, b);
        canvas.drawCircle(x + w, y + h, 1, b);
    }
    public void Update(){
        if(GameView.movControl){
            y -=  Player.g;
        }
    }
}
