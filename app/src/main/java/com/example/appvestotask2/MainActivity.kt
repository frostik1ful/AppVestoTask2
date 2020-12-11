package com.example.appvestotask2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.example.appvestotask2.controller.Controller
import com.example.appvestotask2.view.ChessDesk

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val chessDesk: ChessDesk = findViewById(R.id.ChessDesk)
        val dmetrics = DisplayMetrics()
        val controller = Controller(chessDesk)
        windowManager.defaultDisplay.getMetrics(dmetrics)
        val dwidth: Int = dmetrics.widthPixels

        chessDesk.fill(dwidth / 8)
        chessDesk.rowList.forEach { row ->
            row.segmentList.forEach { segment ->
                segment.setOnClickListener {
                    removeOnClickListeners(chessDesk)
                    var nextSegment = controller.makeMove(segment)
                    object : CountDownTimer(300, 300) {
                        override fun onTick(millisUntilFinished: Long) {
                            if (nextSegment != null) {
                                nextSegment = controller.makeMove(nextSegment!!)
                            } else {
                                cancel()
                            }

                        }

                        override fun onFinish() {
                            this.start()
                        }

                    }.start()
                }
            }
        }
    }

    private fun removeOnClickListeners(chessDesk: ChessDesk) {
        chessDesk.rowList.forEach { row ->
            row.segmentList.forEach { segment ->
                segment.setOnClickListener(null)

            }
        }
    }
}