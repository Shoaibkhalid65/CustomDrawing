package com.example.customdrawing.customLayouts

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun Sample8(){

    val brush= Brush.linearGradient(
        colors = listOf(
            Color(0xFF2739B0),
            Color(0xFF01133F)
        ),
    )
    val color=Color(0xFFDE62F3)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
            .drawWithCache {
                onDrawBehind {
                    val width = size.width
                    val height = size.height
                    drawCircle(
                        color = color,
                        radius = width / 2,
                        center = Offset(0f, height),
                        blendMode = BlendMode.Saturation
                    )
                    val path = Path().apply {
                        moveTo(width / 1.5f, 0f)
                        cubicTo(0f, height / 3, width, height / 2, width, height / 1.5f)
                        lineTo(width, 0f)
                        close()
                    }
                    drawPath(
                        path = path,
                        color = color,
                        blendMode = BlendMode.Saturation
                    )
                }
            }
    )
}