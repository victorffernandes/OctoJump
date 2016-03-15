package com.example.nicolefreitas.octojump;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.os.Handler;



public class GameView extends View implements Runnable{
    public Paint p;
    public Handler handler = new Handler();
    float x = 0;
    float y = 0;
    public Player player;
    public GameView (Context c){
        super(c);
        init(c);
    }

    private void init(Context c)
    {
        p = new Paint();
        p.setColor(Color.RED);
        player = new Player(50,50,c);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        x+=15;
        y+=15;
        invalidate();
        canvas.drawCircle(x, y, 30, p);
        player.Draw(canvas);
    }
    @Override
    public void run(){
        handler.postDelayed(this,30);
        invalidate();

    }
}
