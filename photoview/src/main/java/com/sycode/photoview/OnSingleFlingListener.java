package com.sycode.photoview;

import android.view.MotionEvent;

/**
 * 当ImageView被单例抛出时调用
 */
public interface OnSingleFlingListener {

    /**
     * 用户在ImageView上的位置
     * 用户在视图上的任何地方移动。
     *
     * @param e1        用户第一次触摸。
     * @param e2        用户最后一次触摸。
     * @param velocityX 用户水平移动距离
     * @param velocityY 用户垂直投掷的速度距离。
     */
    boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY);
}
