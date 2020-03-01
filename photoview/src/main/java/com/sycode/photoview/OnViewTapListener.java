package com.sycode.photoview;

import android.view.View;

public interface OnViewTapListener {

    /**
     * 用户点击ImageView的地方
     * *用户点击视图上的任何地方，点击ImageView外将不会被忽略。
     *
     * @param view - 查看用户点击
     * @param x    - 用户从视图左侧点击
     * @param y    - 用户从视图顶部点击
     */
    void onViewTap(View view, float x, float y);
}
