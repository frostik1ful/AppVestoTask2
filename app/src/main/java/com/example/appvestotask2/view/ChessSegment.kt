package com.example.appvestotask2.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class ChessSegment(
        context: Context,
        private var color: Int,
        val x: Int,
        val y: Int,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var isVisited = false
    private lateinit var rect: RectF
    private val paint: Paint = Paint()

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val size = width.toFloat()

        rect = RectF(0f, 0f, size, size)
        paint.color = color
        canvas?.drawRect(rect, paint)

    }

    fun makeVisited() {
        isVisited = true
        color = Color.BLACK
        invalidate()
    }

}