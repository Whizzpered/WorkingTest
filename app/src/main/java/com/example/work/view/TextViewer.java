package com.example.work.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;

import androidx.annotation.RequiresApi;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

import com.example.work.CommandController;
import com.example.work.CustomGestureDetector;
import com.example.work.Observer;
import com.example.work.R;
import com.example.work.TextModel;

public class TextViewer extends View implements Observer {

    private TextPaint mTextPaint;
    private StaticLayout mStaticLayout;
    int width;

    private OverScroller mScroller;
    CustomGestureDetector customGestureDetector = new CustomGestureDetector(this);
    private final GestureDetector mGestureDetector =
            new GestureDetector(getContext(), customGestureDetector);


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TextViewer(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TextViewer);
        attributes.recycle();
        initLabelView();
        CommandController.getInstance().addObserverToModel(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public TextViewer(Context context) {
        super(context);
        newInit();
    }

    private void initLabelView() {
        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);

        mTextPaint.setTextSize(20f * getResources().getDisplayMetrics().density);
        mTextPaint.setColor(getResources().getColor(R.color.black));

        String text = getResources().getString(R.string.rus_text);
        width = (int) mTextPaint.measureText(text);
        mStaticLayout = new StaticLayout(text, mTextPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);

        mScroller = new OverScroller(getContext(), new FastOutLinearInInterpolator());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void newInit() {
        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);

        mTextPaint.setTextSize(20f * getResources().getDisplayMetrics().density);
        mTextPaint.setColor(getResources().getColor(R.color.black));

        String text = getResources().getString(R.string.rus_text);
        width = (int) mTextPaint.measureText(text);
        StaticLayout.Builder builder = StaticLayout.Builder.obtain(text, 0, text.length(), mTextPaint, width)
                .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                .setLineSpacing(1, 0)
                .setIncludePad(false);
        mStaticLayout = builder.build();
        mScroller = new OverScroller(getContext(), new FastOutLinearInInterpolator());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthRequirement = MeasureSpec.getSize(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthRequirement;
        } else {
            width = mStaticLayout.getWidth() + getPaddingLeft() + getPaddingRight();
            if (widthMode == MeasureSpec.AT_MOST) {
                if (width > widthRequirement) {
                    width = widthRequirement;
                    String text = getResources().getString(R.string.rus_text);
                    mStaticLayout = new StaticLayout(text, mTextPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
                }
            }
        }

        int height;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightRequirement = MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightRequirement;
        } else {
            height = mStaticLayout.getHeight() + getPaddingTop() + getPaddingBottom();
            if (heightMode == MeasureSpec.AT_MOST) {
                height = heightRequirement;
            }
        }
        setMeasuredDimension(width, height);
    }

    public void setText(TextModel textModel) {
        String text = textModel.getContent();
        mStaticLayout = new StaticLayout(text, mTextPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        mStaticLayout.draw(canvas);
        for (int i = 0; i < 15; i++) {
            canvas.translate(0, mStaticLayout.getHeight() + 10);
            mStaticLayout.draw(canvas);
        }
        canvas.restore();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
        }
    }

    public void setFormating(TextModel textModel) {
        boolean isBold = textModel.isBold();
        boolean isItalic = textModel.isItalic();

        if (isBold && isItalic) {
            setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD_ITALIC));
        } else if (isBold) {
            setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        } else if (isItalic) {
            setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.ITALIC));
        } else {
            setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        }

    }

    public void setTypeface(Typeface typeface) {
        mStaticLayout.getPaint().setTypeface(typeface);
        mTextPaint.setTypeface(typeface);
    }

    public void setTextSize(TextModel textModel) {
        int size = textModel.getTextSize();
        mTextPaint.setTextSize(size * getResources().getDisplayMetrics().density);
        mStaticLayout.getPaint().setTextSize(size * getResources().getDisplayMetrics().density);
    }

    public StaticLayout getStaticLayout() {
        return mStaticLayout;
    }

    public OverScroller getScroller() {
        return mScroller;
    }

    @Override
    public void update(TextModel model) {
        setFormating(model);
        setText(model);
        setTextSize(model);
        invalidate();
    }
}
