package edu.umd.cs.androiddoodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * Created by Matt on 11/2/2016.
 */

public class DrawView extends View {

    private Canvas drawCanvas;
    private Path drawPath;
    private Paint drawPaint, canvasPaint;
    private Bitmap canvasBitmap;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);


        // Set up a path and paint class
        drawPath = new Path();

        drawPaint = new Paint();
        drawPaint.setColor(Color.BLACK);
        drawPaint.setStyle(Paint.Style.STROKE);

        canvasPaint = new Paint(Paint.DITHER_FLAG);
    }

   

}
