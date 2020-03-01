package com.sycode.photoview;

import android.widget.ImageView;

/**
 * 手势监听:单个手机点击ImageView
 */
public interface OnPhotoTapListener {

    /**
     * 接收用户点击照片的位置
     * 用户点击实际照片，点击ImageView外将被忽略
     *
     * @param view 用户点击ImageView
     * @param x    用户从可绘制项中点击，表示百分比可拉的宽度。
     * @param y    用户从可绘制的顶部点击，表示百分比可拉的高度。
     */
    void onPhotoTap(ImageView view, float x, float y);
}
