package com.example.abc.customerview.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class CustomerView extends View {

    private int lastX;

    private int lastY;

    public CustomerView(Context context) {
        super(context);
    }

    public CustomerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int)event.getX();
        int y=(int)event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX=x;
                lastY=y;
                break;
            /**
             * 两者效果的等同
             */
            case MotionEvent.ACTION_MOVE:
                int offX=x-lastX;
                int offY=y-lastY;
              //  layout(getLeft()+offX,getTop()+offY,getRight()+offX,getBottom()+offY);
                offsetLeftAndRight(offX);
                offsetTopAndBottom(offY);
                break;
        }
        return true;
    }
}
