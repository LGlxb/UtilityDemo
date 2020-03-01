package com.sycode.photoview;

/**
 * ImageView:照片遇到拖动事件时调用
 */
public interface OnViewDragListener {

    /**
     * 照片正在经历一个拖动事件。方法时不能调用此方法
     * *用户正在缩放。
     *
     * @param dx x方向坐标的变化
     * @param dy y方向坐标的变化
     */
    void onDrag(float dx, float dy);
}
