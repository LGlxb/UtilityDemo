package com.sycode.photoview;

import android.graphics.RectF;

/**
 * 绘制Rect内部发生改动时调用
 */
public interface OnMatrixChangedListener {

    /**
     * 显示可绘制图形的矩阵发生更改时的回调 :视图的边界已经改变，或者用户已经缩放。
     *
     * @param rect—显示Drawable新边界的矩形。
     */
    void onMatrixChanged(RectF rect);
}
