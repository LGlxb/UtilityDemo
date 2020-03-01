package com.sycode.indicatorview.indicators

import android.animation.ValueAnimator
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.view.animation.LinearInterpolator
import com.sycode.indicatorview.Indicator
import java.util.*

/**
 * Created by Jack on 2015/10/17.
 */
class BallPulseRiseIndicator : Indicator() {
      val mCamera: Camera
      val mMatrix: Matrix
      var degress = 0f
    override fun draw(
        canvas: Canvas,
        paint: Paint
    ) {
        mMatrix.reset()
        mCamera.save()
        mCamera.rotateX(degress)
        mCamera.getMatrix(mMatrix)
        mCamera.restore()
        mMatrix.preTranslate(-centerX().toFloat(), -centerY().toFloat())
        mMatrix.postTranslate(centerX().toFloat(), centerY().toFloat())
        canvas.concat(mMatrix)
        val radius = width / 10.toFloat()
        canvas.drawCircle(width / 4.toFloat(), radius * 2, radius, paint)
        canvas.drawCircle(width * 3 / 4.toFloat(), radius * 2, radius, paint)
        canvas.drawCircle(radius, height - 2 * radius, radius, paint)
        canvas.drawCircle(width / 2.toFloat(), height - 2 * radius, radius, paint)
        canvas.drawCircle(width - radius, height - 2 * radius, radius, paint)
    }

    override fun onCreateAnimators(): ArrayList<ValueAnimator> {
        val animators = ArrayList<ValueAnimator>()
        val animator = ValueAnimator.ofFloat(0f, 360f)
        addUpdateListener(animator , ValueAnimator.AnimatorUpdateListener {   animation ->
            degress = animation.animatedValue as Float
            postInvalidate()
        })
        animator.interpolator = LinearInterpolator()
        animator.repeatCount = -1
        animator.duration = 1500
        animators.add(animator)
        return animators
    }

    init {
        mCamera = Camera()
        mMatrix = Matrix()
    }
}