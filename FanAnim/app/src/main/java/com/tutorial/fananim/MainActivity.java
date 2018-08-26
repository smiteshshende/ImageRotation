package com.tutorial.fananim;

import android.support.v4.view.animation.PathInterpolatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mFanImageView;

    private Button mStartBtn;

    private Button mStopBtn;

    private Button mSpeedOne;

    private Button mSpeedTwo;

    private Button mSpeedThree;

    private Button mSpeedFour;

    private RotateAnimation mRotateAnimation;

    private SpeedMode mSpeedMode = SpeedMode.SPEED_ONE;

    private static final float ROTATE_FROM = 0.0f;
    private static final float ROTATE_TO = 10.0f * 360.0f;
    private static final float PIVOT_X = 0.5f;
    private static final float PIVOT_Y = 0.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        mRotateAnimation = new RotateAnimation(ROTATE_FROM, ROTATE_TO,
                Animation.RELATIVE_TO_SELF, PIVOT_X, Animation.RELATIVE_TO_SELF, PIVOT_Y);
    }

    private void initUI() {
        mFanImageView = (ImageView) findViewById(R.id.fan_img);
        mStartBtn = (Button) findViewById(R.id.start_btn);
        mStartBtn.setOnClickListener(this);
        mStopBtn = (Button) findViewById(R.id.stop_btn);
        mStopBtn.setOnClickListener(this);
        mSpeedOne = (Button) findViewById(R.id.speed_btn1);
        mSpeedOne.setOnClickListener(this);
        mSpeedTwo = (Button) findViewById(R.id.speed_btn2);
        mSpeedTwo.setOnClickListener(this);
        mSpeedThree = (Button) findViewById(R.id.speed_btn3);
        mSpeedThree.setOnClickListener(this);
        mSpeedFour = (Button) findViewById(R.id.speed_btn4);
        mSpeedFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_btn:
                startFan();
                break;
            case R.id.stop_btn:
                stopFan();
                break;
            case R.id.speed_btn1:
                setFanSpeed(SpeedMode.SPEED_ONE);
                break;
            case R.id.speed_btn2:
                setFanSpeed(SpeedMode.SPEED_TWO);
                break;
            case R.id.speed_btn3:
                setFanSpeed(SpeedMode.SPEED_THREE);
                break;
            case R.id.speed_btn4:
                setFanSpeed(SpeedMode.SPEED_FOUR);
                break;
        }
    }

    private void stopFan() {
        mFanImageView.clearAnimation();
    }

    private void startFan() {
        mRotateAnimation.setDuration(mSpeedMode.getSpeed());
        mRotateAnimation.setRepeatCount(Animation.INFINITE);
        mRotateAnimation.setRepeatMode(Animation.RESTART);
        mRotateAnimation.setInterpolator(this, android.R.anim.linear_interpolator);
        mFanImageView.startAnimation(mRotateAnimation);
    }

    private void setFanSpeed(SpeedMode speedMode) {
        mSpeedMode = speedMode;
        mRotateAnimation.setDuration(speedMode.getSpeed());
    }
}
