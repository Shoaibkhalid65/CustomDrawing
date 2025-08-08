package com.example.customdrawing.customLayouts

import android.R
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun Sample7(){
    Canvas(
        modifier = Modifier.size(200.dp).background(Color.White).padding(20.dp)

    ) {
        val height=size.height
        val width=size.width
        val cornerRadius=100f
        val circleRadius=50f
        val brush= Brush.linearGradient(
            listOf(
                Color(0xFF405DE6),
                Color(0xFF5B51D8),
                Color(0xFF833AB4),
                Color(0xFFC13584),
                Color(0xFFE1306C),
                Color(0xFFFD1D1D),
                Color(0xFFF56040),
                Color(0xFF777737),
                Color(0xFFFCAF45),
                Color(0xFFFFDC80)
            )
        )

        drawRoundRect(
            brush=brush,
            size=size,
            cornerRadius = CornerRadius(cornerRadius,cornerRadius),
            style = Stroke(
                width=10.dp.toPx()
            )
        )
        drawCircle(
            brush=brush,
            radius = circleRadius,
            center=Offset(width/2,height/2),
            style = Stroke(
                width=8.dp.toPx()
            )
        )
        drawCircle(
            brush=brush,
            radius = 20f,
            center= Offset(width/10*8,height/10*2)
        )

    }
}
