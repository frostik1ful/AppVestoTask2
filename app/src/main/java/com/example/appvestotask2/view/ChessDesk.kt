package com.example.appvestotask2.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.appvestotask2.controller.WayPoint

class ChessDesk @kotlin.jvm.JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    val rowList = ArrayList<ChessRow>()
    fun fill(segmentSize: Int) {
        for (i in 0..7) {
            val chessRow = ChessRow(context, i, segmentSize)
            addView(chessRow)
            rowList.add(chessRow)
        }
    }

    fun getNodeByRowColumnIndex(point: WayPoint): ChessSegment {
        return rowList[point.y].segmentList[point.x]
    }
}