package com.sycode.photoview;


/**
 * 当附加的ImageView比例变化时调用
 */
public interface OnScaleChangedListener {

    /**
     * 缩放比例发生变化
     *
     * @param scaleFactor 缩放比例(缩小小于1，放大大于1)
     * @param focusX      焦点X位置
     * @param focusY      焦点y位置
     */
    void onScaleChange(float scaleFactor, float focusX, float focusY);
}
