package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import kotlin.jvm.JvmOverloads
import androidx.appcompat.widget.AppCompatTextView
import android.util.TypedValue
import android.view.Gravity
import com.example.app.R
import com.example.core.utils.Utils
import java.util.*

class CodeView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {

    private val codeList = arrayOf(
            "kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip"
    )

    fun updateCode() {
        val random = Random().nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }
    private val paint = Paint().apply {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = getContext().getColor(R.color.colorAccent)
        strokeWidth = Utils.dp2px(6f)
        updateCode()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
    }

}