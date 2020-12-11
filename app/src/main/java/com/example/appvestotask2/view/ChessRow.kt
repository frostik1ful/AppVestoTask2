package com.example.appvestotask2.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.example.appvestotask2.R

class ChessRow (
        context: Context,
        rowId: Int,
        segmentSize: Int,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    val segmentList = ArrayList<ChessSegment>()

    init {
        val blackColor: Int = ResourcesCompat.getColor(resources, R.color.chessBlack, null)
        val whiteColor: Int = ResourcesCompat.getColor(resources, R.color.chessWhite, null)

        for (i in 0..7) {
            val segment: ChessSegment
            val color: Int = if (rowId % 2 == 0) {
                if (i % 2 == 0) {
                    whiteColor
                } else {
                    blackColor
                }
            } else {
                if (i % 2 == 0) {
                    blackColor
                } else {
                    whiteColor
                }
            }
            segment = ChessSegment(context, color, i, rowId)
            addView(segment, segmentSize, segmentSize)
            segmentList.add(segment)
        }
    }
}