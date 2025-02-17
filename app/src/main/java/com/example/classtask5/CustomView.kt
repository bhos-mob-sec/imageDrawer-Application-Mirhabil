package com.example.classtask5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CustomView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {


    companion object {
        var brushColor = Color.BLACK
        var brushRadius=8f
    }

    val paint = Paint().apply {
        style = Paint.Style.STROKE

    }

    private var currentPath = Path()
    private var pathList = ArrayList<PathData>()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.color = brushColor
        for (i in pathList) {
            paint.color = i.color
            paint.strokeWidth = i.brushRadius
            canvas.drawPath(i.path, paint)
        }
        paint.color = brushColor
        paint.strokeWidth = brushRadius
        canvas.drawPath(currentPath, paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                currentPath = Path()
                currentPath.moveTo(x, y)
                invalidate()
                return true
            }

            MotionEvent.ACTION_MOVE -> {
                currentPath.lineTo(x, y)
                invalidate()

            }

            MotionEvent.ACTION_UP -> {
                pathList.add(PathData(currentPath, brushColor, brushRadius))
                invalidate()
            }

            else -> return false

        }
        return true

    }
}

data class PathData(val path: Path, val color: Int,val brushRadius:Float)