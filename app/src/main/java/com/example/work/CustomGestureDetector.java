package com.example.work;

import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.work.TextViewer;

public class CustomGestureDetector extends GestureDetector.SimpleOnGestureListener {

    private TextViewer parent;

    public CustomGestureDetector (TextViewer parent){
        this.parent = parent;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        parent.scrollBy(0, (int) distanceY);
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2,
                           float velocityX, float velocityY) {
        final int maxScrollX = 0;

        int wholeViewHeight = parent.getStaticLayout().getHeight();
        int visibleHeight = parent.getHeight();
        final int maxScrollY = (wholeViewHeight - visibleHeight) < 0 ? 0 : (wholeViewHeight - visibleHeight);
        parent.getScroller().forceFinished(true);
        parent.getScroller().fling(0, parent.getScrollY(), 0, -(int) velocityY,
                0, maxScrollX, 0, maxScrollY);
        parent.invalidate();
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        if (!parent.getScroller().isFinished()) {
            parent.getScroller().forceFinished(true);
        }
        return true;
    }

    public boolean onSingleTapUp(MotionEvent e) {
        parent.scrollTo(0, 0);
        return super.onSingleTapUp(e);
    }

}
