package com.tutorial.fananim;

/**
 * Created by smitesh.shende on 8/26/2018.
 */

public enum SpeedMode {

    SPEED_ONE(5000),

    SPEED_TWO(4000),

    SPEED_THREE(3000),

    SPEED_FOUR(2000),

    DEFAULT(1000);

    private int mSpeed;

    SpeedMode(int speed) {
        mSpeed = speed;
    }

    public int getSpeed() {
        return mSpeed;
    }
}
