package com.ablingbling.library.followbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by xukui on 2018/5/31.
 */
public class FollowButton extends FrameLayout {

    private ContentLoadingProgressBar progressBar;
    private TextView tv_name;

    private int mTextSize;
    private int mNorBackground;
    private int mCheckBackground;
    private boolean mChecked;
    private int mNorTextColor;
    private int mCheckTextColor;
    private String mNorText;
    private String mCheckText;

    public FollowButton(@NonNull Context context) {
        super(context);
        initData(context, null, 0);
        initView(context);
        setView();
    }

    public FollowButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context, attrs, 0);
        initView(context);
        setView();
    }

    public FollowButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context, attrs, defStyleAttr);
        initView(context);
        setView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FollowButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initData(context, attrs, defStyleAttr);
        initView(context);
        setView();
    }

    private void initData(Context context, AttributeSet attrs, int defStyleAttr) {
        mTextSize = DensityUtil.dp2px(12);
        mNorBackground = R.drawable.bg_follow_button_nor;
        mCheckBackground = R.drawable.bg_follow_button_check;
        mChecked = false;
        mNorTextColor = Color.parseColor("#000000");
        mCheckTextColor = Color.parseColor("#cccccc");
        mNorText = "+ 关注";
        mCheckText = "已关注";

        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FollowButton, defStyleAttr, 0);

            mTextSize = ta.getDimensionPixelSize(R.styleable.FollowButton_android_textSize, mTextSize);
            mNorBackground = ta.getResourceId(R.styleable.FollowButton_follow_background_nor, mNorBackground);
            mCheckBackground = ta.getResourceId(R.styleable.FollowButton_follow_background_check, mCheckBackground);
            mChecked = ta.getBoolean(R.styleable.FollowButton_follow_check, mChecked);
            mNorTextColor = ta.getColor(R.styleable.FollowButton_follow_textColor_nor, mNorTextColor);
            mCheckTextColor = ta.getColor(R.styleable.FollowButton_follow_textColor_check, mCheckTextColor);
            mNorText = ta.getString(R.styleable.FollowButton_follow_text_nor);
            mCheckText = ta.getString(R.styleable.FollowButton_follow_text_check);

            ta.recycle();
        }
    }

    private void initView(Context context) {
        inflate(context, R.layout.view_follow_button, this);

        progressBar = findViewById(R.id.progressBar);
        tv_name = findViewById(R.id.tv_name);
    }

    private void setView() {
        tv_name.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);

        if (mChecked) {
            tv_name.setTextColor(mCheckTextColor);
            tv_name.setText(mCheckText);
            setBackgroundResource(mCheckBackground);

        } else {
            tv_name.setTextColor(mNorTextColor);
            tv_name.setText(mNorText);
            setBackgroundResource(mNorBackground);
        }
    }

    public void check(boolean check) {
        mChecked = check;

        setView();
    }

}
