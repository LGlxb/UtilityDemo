package com.sycode.photoview;

import android.widget.ImageView;

/**
 * 用户在照片外点击:ImageView
 */
public interface OnOutsidePhotoTapListener {

    /**
     * 照片外被人点击一次:ImageView
     */
    void onOutsidePhotoTap(ImageView imageView);
}
