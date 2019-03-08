package com.smq.smq0308yk.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

/**
 * Time:2019/3/8
 * <p>
 * Author:Lenovo
 * <p>
 * Description:
 */
public class Custom_Main extends View {
    private int screenWidth;

    private float xoffset = 0;

    private Paint paint;

    private Path path;


    public Custom_Main(Context context) {
        super(context);
    }

    public Custom_Main(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();

        ValueAnimator animator = new ValueAnimator();
        animator.setFloatValues(0, screenWidth);
        animator.setDuration(3000);
        animator.setRepeatCount(-1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                xoffset = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();


    }

    public Custom_Main(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        Path path = new Path();

        path.moveTo(0, 500);
        path.quadTo(screenWidth / 4, 300, screenWidth / 2, 500);
        path.moveTo(screenWidth / 2, 500);
        path.quadTo(screenWidth / 4 * 3, 700, screenWidth, 500);

        canvas.drawPath(path, paint);

    }

}
