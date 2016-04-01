package com.example.nicolefreitas.octojump;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.View;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Random;


public class GameView extends View implements Runnable{
    public Handler handler = new Handler();
    public Player player;
    public ArrayList<Platform> pList;
    public static boolean movControl;
    private boolean start = false;

    public GameView (Context c){
        super(c);
        init(c);

    }

    private void init(Context c)
    {
        player = new Player(50,50,c);
        pList = new ArrayList<Platform>();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawColor(Color.WHITE);

        Log.d("MainActivity",""+pList.size());

        if(!start)
        {
            start = true;
            int m =300;
            pList.add(new Platform(canvas,m));
            /*for(int i = 0; i < 10; i++)
            {
                pList.add(new Platform(canvas, pList.get(pList.size() - 1).y));
            }*/
        }

        if((player.y <= canvas.getHeight()/2) && (Player.g <= 0))
        {
            movControl = true;
        }
        else
        {
            movControl = false;
        }

        super.onDraw(canvas);
        invalidate();

        synchronized (pList)
        {

            for (Platform p : pList)
            {
                p.Update();
                p.Draw(canvas);
                /*if (p.y >= canvas.getHeight())
                {
                    pList.remove(p);
                    pList.add(new Platform(canvas, pList.get(pList.size() - 1).y));
                }*/
            }
        }
        player.Update(canvas.getWidth(), canvas.getHeight(), pList);
        player.Draw(canvas);
    }
    @Override
    public void run(){
        handler.postDelayed(this,30);
        invalidate();
    }
}
