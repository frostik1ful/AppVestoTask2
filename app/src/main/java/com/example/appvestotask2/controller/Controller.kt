package com.example.appvestotask2.controller

import com.example.appvestotask2.view.ChessDesk
import com.example.appvestotask2.view.ChessSegment

class Controller(private val chessDesk: ChessDesk) {

    fun makeMove(segment: ChessSegment): ChessSegment? {
        segment.makeVisited()
        val x = segment.x
        val y = segment.y
        val ways = calculateWays(x, y)
        var minimal = 9
        var minimalIndex = -1
        ways.forEachIndexed { index, wayPoint ->
            val size = calculateWays(wayPoint.x, wayPoint.y).size
            if (size < minimal) {
                minimal = size
                minimalIndex = index
            }
        }
        if (minimalIndex < 0) {
            return null
        }
        val minimalWay = ways[minimalIndex]
        val lastSegment = chessDesk.getNodeByRowColumnIndex(minimalWay)
        lastSegment.makeVisited()

        return lastSegment

    }

    private fun calculateWays(x: Int, y: Int): List<WayPoint> {
        val ways: ArrayList<WayPoint> = ArrayList()
        val size = 8
        if (x + 1 < size) {
            if (y - 2 >= 0) {
                addWay(ways, WayPoint(x + 1, y - 2))
            }
            if (y + 2 < size) {
                addWay(ways, WayPoint(x + 1, y + 2))
            }
        }
        if (x - 1 >= 0) {
            if (y - 2 >= 0) {
                addWay(ways, WayPoint(x - 1, y - 2))
            }
            if (y + 2 < size) {
                addWay(ways, WayPoint(x - 1, y + 2))
            }
        }
        if (x + 2 < size) {
            if (y - 1 >= 0) {
                addWay(ways, WayPoint(x + 2, y - 1))
            }
            if (y + 1 < size) {
                addWay(ways, WayPoint(x + 2, y + 1))
            }
        }
        if (x - 2 >= 0) {
            if (y - 1 >= 0) {
                addWay(ways, WayPoint(x - 2, y - 1))
            }
            if (y + 1 < size) {
                addWay(ways, WayPoint(x - 2, y + 1))
            }
        }
        return ways
    }

    private fun addWay(ways: ArrayList<WayPoint>, point: WayPoint) {
        if (!chessDesk.getNodeByRowColumnIndex(point).isVisited) {
            ways.add(point)
        }
    }

}