package com.example.work;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;

import androidx.interpolator.view.animation.FastOutLinearInInterpolator;

public class TextViewer extends View {

    public enum FormatType {
        BOLD, ITALIC
    }

    private TextModel textModel;
    private TextPaint mTextPaint;
    private StaticLayout mStaticLayout;

    private OverScroller mScroller;
    CustomGestureDetector customGestureDetector = new CustomGestureDetector(this);
    private final GestureDetector mGestureDetector =
            new GestureDetector(getContext(), customGestureDetector);

    public TextViewer(Context context) {
        super(context);
    }

    public TextViewer(Context context, AttributeSet attrs) {
        super(context, attrs);
        textModel = new TextModel();
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.TextViewer);
        textModel.setContent(attributes.getString(R.styleable.TextViewer_tv_content));
        attributes.recycle();
        initLabelView();
    }

    private void initLabelView() {
        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);
        int textSize = textModel.getTextSize();

        mTextPaint.setTextSize(textSize * getResources().getDisplayMetrics().density);
        mTextPaint.setColor(0xFF000000);

        String text = textModel.getContent();
        int width = (int) mTextPaint.measureText(text);
        mStaticLayout = new StaticLayout(text, mTextPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);

        mScroller = new OverScroller(getContext(), new FastOutLinearInInterpolator());
        // for a New API (>23)
        //
        // StaticLayout.Builder builder = StaticLayout.Builder.obtain(content, 0, content.length(), mTextPaint, width)
        //        .setAlignment(Layout.Alignment.ALIGN_NORMAL)
        //        .setLineSpacing(1, 0) // multiplier, add
        //        .setIncludePad(false);
        // mStaticLayout = builder.build();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthRequirement = MeasureSpec.getSize(widthMeasureSpec);
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthRequirement;
        } else {
            width = mStaticLayout.getWidth() + getPaddingLeft() + getPaddingRight();
            if (widthMode == MeasureSpec.AT_MOST) {
                if (width > widthRequirement) {
                    width = widthRequirement;
                    String text = textModel.getContent();
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
                //height = Math.min(height, heightRequirement);
                height = heightRequirement;
            }
        }

        setMeasuredDimension(width, height);
    }

    public void setText(String text) {
        textModel.setContent(text);
        int width = (int) mTextPaint.measureText(text);
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

    public void setFormating(FormatType input) {
        switch (input) {
            case BOLD:
                textModel.setBold();
                break;
            case ITALIC:
                textModel.setItalic();
        }

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
        invalidate();
    }

    public void setTextSize(int size) {
        int width = getWidth();
        String text = textModel.getContent();
        mTextPaint.setTextSize(size * getResources().getDisplayMetrics().density);
        mStaticLayout = new StaticLayout(text, mTextPaint, width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0, false);
        textModel.setTextSize(size);
        invalidate();
    }

    public boolean isBold() {
        return textModel.isBold();
    }

    public boolean isItalic() {
        return textModel.isItalic();
    }

    public int getTextSize() {
        return textModel.getTextSize();
    }

    public StaticLayout getStaticLayout() {
        return mStaticLayout;
    }

    public OverScroller getScroller() {
        return mScroller;
    }

}
