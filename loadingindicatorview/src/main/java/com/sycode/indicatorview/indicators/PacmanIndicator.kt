package com.sycode.indicatorview.indicators

import android.animation.ValueAnimator
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.view.animation.LinearInterpolator
import com.sycode.indicatorview.Indicator
import java.util.*

/**
 * Created by Jack on 2015/10/16.
 */
class PacmanIndicator : Indicator() {
      var translateX = 0f
      var mAlphaValue = 0
      var degrees1 = 0f
      var degrees2 = 0f
    override fun draw(
        canvas: Canvas,
        paint: Paint
    ) {
        drawPacman(canvas, paint)
        drawCircle(canvas, paint)
    }

      fun drawPacman(
        canvas: Canvas,
        paint: Paint
    ) {
        val x = width / 2.toFloat()
        val y = height / 2.toFloat()
        canvas.save()
        canvas.translate(x, y)
        canvas.rotate(degrees1)
        paint.alpha = 255
        val rectF1 = RectF(-x / 1.7f, -y / 1.7f, x / 1.7f, y / 1.7f)
        canvas.drawArc(rectF1, 0f, 270f, true, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(x, y)
        canvas.rotate(degrees2)
        paint.alpha = 255
        val rectF2 = RectF(-x / 1.7f, -y / 1.7f, x / 1.7f, y / 1.7f)
        canvas.drawArc(rectF2, 90f, 270f, true, paint)
        canvas.restore()
    }

      fun drawCircle(
        canvas: Canvas,
        paint: Paint
    ) {
        val radius = width / 11.toFloat()
        paint.alpha = mAlphaValue
        canvas.drawCircle(translateX, height / 2.toFloat(), radius, paint)
    }

    override fun onCreateAnimators(): ArrayList<ValueAnimator> {
        val animators = ArrayList<ValueAnimator>()
        val startT = width / 11.toFloat()
        val translationAnim =
            ValueAnimator.ofFloat(width - startT, width / 2.toFloat())
        translationAnim.duration = 650
        translationAnim.interpolator = LinearInterpolator()
        translationAnim.repeatCount = -1
        addUpdateListener(translationAnim , ValueAnimator.AnimatorUpdateListener {   animation ->
            translateX = animation.animatedValue as Float
            postInvalidate()
        })
        val alphaAnim = ValueAnimator.ofInt(255, 122)
        alphaAnim.duration = 650
        alphaAnim.repeatCount = -1
        addUpdateListener(alphaAnim , ValueAnimator.AnimatorUpdateListener {   animation ->
            mAlphaValue = animation.animatedValue as Int
            postInvalidate()
        })
        val rotateAnim1 = ValueAnimator.ofFloat(0f, 45f, 0f)
        rotateAnim1.duration = 650
        rotateAnim1.repeatCount = -1
        addUpdateListener(rotateAnim1 , ValueAnimator.AnimatorUpdateListener {   animation ->
            degrees1 = animation.animatedValue as Float
            postInvalidate()
        })
        val rotateAnim2 = ValueAnimator.ofFloat(0f, -45f, 0f)
        rotateAnim2.duration = 650
        rotateAnim2.repeatCount = -1
        addUpdateListener(rotateAnim2 , ValueAnimator.AnimatorUpdateListener {   animation ->
            degrees2 = animation.animatedValue as Float
            postInvalidate()
        })
        animators.add(translationAnim)
        animators.add(alphaAnim)
        animators.add(rotateAnim1)
        animators.add(rotateAnim2)
        return animators
    }
}