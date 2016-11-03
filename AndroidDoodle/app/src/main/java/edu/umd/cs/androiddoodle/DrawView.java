package edu.umd.cs.androiddoodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by Matt on 11/2/2016.
 * https://developer.android.com/reference/android/graphics/Canvas.html
 * To draw something, you need 4 basic components:
 * A Bitmap to hold the pixels,
 * a Canvas to host the draw calls (writing into the bitmap),
 * a drawing primitive (e.g. Rect, Path, text, Bitmap),
 * and a paint (to describe the colors and styles for the drawing).
 */

public class DrawView extends View {

    private Bitmap drawBitmap;
    private Canvas drawCanvas;
    private Path drawPath;
    private Paint drawPaint;

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // Set up a path and paint class
        drawPath = new Path();

        drawPaint = new Paint();
        drawPaint.setColor(Color.BLACK);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        drawPaint.setStrokeWidth(25);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        drawBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        drawCanvas = new Canvas(drawBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(drawBitmap, 0, 0, drawPaint);
        canvas.drawPath(drawPath, drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                drawPath.moveTo(x, y); break;
            case MotionEvent.ACTION_MOVE:
                drawPath.lineTo(x, y); break;
            case MotionEvent.ACTION_UP:
                drawCanvas.drawPath(drawPath, drawPaint);
                drawPath.reset();
                break;
            default:
                Log.d("TOUCH EVENT", "Unsupported action.");
        }
        invalidate();
        return true;
    }


    public void clearDrawing(){
        drawCanvas.drawColor(Color.WHITE);
    }

}
