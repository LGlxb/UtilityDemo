package com.sycode.photoview;

interface OnGestureListener {
    /**
     * 拖拽监听
     *
     * @param dx
     * @param dy
     */
    void onDrag(float dx, float dy);

    /**
     * 移动速度监听
     *
     * @param startX
     * @param startY
     * @param velocityX
     * @param velocityY
     */
    void onFling(float startX, float startY, float velocityX,
                 float velocityY);

    /**
     * 缩放手势监听
     *
     * @param scaleFactor
     * @param focusX
     * @param focusY
     */
    void onScale(float scaleFactor, float focusX, float focusY);

}