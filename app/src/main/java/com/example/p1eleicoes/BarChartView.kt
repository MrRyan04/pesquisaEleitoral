
package com.example.p1eleicoes

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class BarChartView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var dataMap: Map<String, Float> = emptyMap()

    private val barPaint = Paint().apply {
        color = Color.parseColor("#3F51B5")
    }

    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 36f
        textAlign = Paint.Align.CENTER
    }

    private val retangulo = RectF()

    fun setData(data: Map<String, Float>) {
        dataMap = data
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (dataMap.isEmpty()) return

        val maiorValor = dataMap.values.maxOrNull() ?: 1f
        val larguraBarra = width / (dataMap.size * 2f)
        val alturaMaxima = height * 0.7f

        var indice = 0

        for ((nome, valor) in dataMap) {

            val esquerda = (indice * 2 + 0.5f) * larguraBarra
            val direita = esquerda + larguraBarra

            val alturaBarra = if (maiorValor > 0) {
                valor / maiorValor * alturaMaxima
            } else {
                0f
            }

            val topo = height - 80f - alturaBarra
            val base = height - 80f

            retangulo.set(esquerda, topo, direita, base)

            canvas.drawRoundRect(retangulo, 12f, 12f, barPaint)

            canvas.drawText(
                valor.toInt().toString(),
                (esquerda + direita) / 2,
                topo - 15f,
                textPaint
            )

            canvas.drawText(
                nome,
                (esquerda + direita) / 2,
                height - 20f,
                textPaint
            )

            indice++
        }
    }
}