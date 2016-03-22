package com.grizzly.fontabletextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by FcoPardo on 3/18/16.
 */
public class FontableTextView extends TextView {

    private FontCustomizer inflateBehavior = FontCustomizer.DEFAULT_BEHAVIOR;

    public FontableTextView(Context context) {
        super(context);
        setCustomFont();
    }

    public FontableTextView(Context context, String font) {
        super(context);
        setCustomFont(font);
    }

    public FontableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont();
    }

    public FontableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FontableTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }

    private void setCustomFont(){
        inflateBehavior.setTextView(this);
        inflateBehavior.setCustomFont();
    }

    private void setCustomFont(String font){
        inflateBehavior.setTextView(this);
        inflateBehavior.setCustomFont(font);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontableTextView,
                defStyle, 0);
        String font = a.getString(R.styleable.FontableTextView_customFont);
        setCustomFont(font);
        a.recycle();
    }
}
