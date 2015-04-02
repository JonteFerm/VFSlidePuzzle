package com.example.vf.vfslidepuzzle;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * Created by Jonathan on 2015-03-24.
 */
public class BrickView extends View {
    private Paint paint;
    private int id;

    public BrickView(Context context) {
        super(context);
    }

    public void setId(int id){
        this.id = id;
        this.paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setTextSize(50);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(Integer.toString(id),getWidth()/2,getHeight()/2,paint);

        super.onDraw(canvas);
    }
}
