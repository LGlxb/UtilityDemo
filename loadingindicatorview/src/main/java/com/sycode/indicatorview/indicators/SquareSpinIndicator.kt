package com.sycode.indicatorview.indicators

import android.animation.ValueAnimator
import android.graphics.*
import android.view.animation.LinearInterpolator
import com.sycode.indicatorview.Indicator
import java.util.*

/**
 * Created by Jack on 2015/10/16.
 */
class SquareSpinIndicator : Indicator() {
      var rotateX = 0f
      var rotateY = 0f
      val mCamera: Camera
      val mMatrix: Matrix
    override fun draw(
        canvas: Canvas,
        paint: Paint
    ) {
        mMatrix.reset()
        mCamera.save()
        mCamera.rotateX(rotateX)
        mCamera.rotateY(rotateY)
        mCamera.getMatrix(mMatrix)
        mCamera.restore()
        mMatrix.preTranslate(-centerX().toFloat(), -centerY().toFloat())
        mMatrix.postTranslate(centerX().toFloat(), centerY().toFloat())
        canvas.concat(mMatrix)
        canvas.drawRect(
            RectF(
                (width / 5).toFloat(),
                (height / 5).toFloat(),
                (width * 4 / 5).toFloat(),
                (height * 4 / 5).toFloat()
            ), paint
        )
    }

    override fun onCreateAnimators(): ArrayList<ValueAnimator> {
        val animators = ArrayList<ValueAnimator>()
        val animator = ValueAnimator.ofFloat(0f, 180f, 180f, 0f, 0f)
        addUpdateListener(animator , ValueAnimator.AnimatorUpdateListener {   animation ->
            rotateX = animation.animatedValue as Float
            postInvalidate()
        })
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = -1
        animator.duration = 2500
        val animator1 = ValueAnimator.ofFloat(0f, 0f, 180f, 180f, 0f)
        addUpdateListener(animator1 , ValueAnimator.AnimatorUpdateListener {   animation ->
            rotateY = animation.animatedValue as Float
            postInvalidate()
        })
        animator1.interpolator = LinearInterpolator()
        animator1.repeatCount = -1
        animator1.duration = 2500
        animators.add(animator)
        animators.add(animator1)
        return animators
    }

    init {
        mCamera = Camera()
        mMatrix = Matrix()
    }
}