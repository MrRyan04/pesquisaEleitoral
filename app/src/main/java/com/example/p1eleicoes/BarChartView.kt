package com.example.p1eleicoes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class BarChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var dataMap: Map<String, Float> = emptyMap()

    private val barPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#3F51B5")
        style = Paint.Style.FILL
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        textSize = 36f
        textAlign = Paint.Align.CENTER
    }

    private val rect = RectF()

    fun setData(data: Map<String, Float>) {
        this.dataMap = data
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (dataMap.isEmpty()) return

        val maxValue = dataMap.values.maxOrNull() ?: 1f
        val count = dataMap.size
        val barWidth = width / (count * 2f)
        val maxBarHeight = height * 0.7f

        var index = 0
        for ((label, value) in dataMap) {
            val left = (index * 2 + 0.5f) * barWidth
            val right = left + barWidth

            val barHeight =
                if (maxValue > 0) (value / maxValue) * maxBarHeight else 0f

            val top = (height - 80f) - barHeight
            val bottom = height - 80f

            rect.set(left, top, right, bottom)
            canvas.drawRoundRect(rect, 12f, 12f, barPaint)

            canvas.drawText(
                value.toInt().toString(),
                left + barWidth / 2,
                top - 15f,
                textPaint
            )

            canvas.drawText(
                label,
                left + barWidth / 2,
                height - 20f,
                textPaint
            )

            index++
        }
    }
}
