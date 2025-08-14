package com.example.customdrawing.customLayouts

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
@Preview(showBackground = true)
fun RightAngledTriangleProgressBar(){
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        var progress by remember { mutableFloatStateOf(0f) }
        val measurer =rememberTextMeasurer()
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Canvas(
                modifier = Modifier
                    .padding(16.dp)
                    .size(300.dp, 150.dp)
            ) {
                val width = size.width
                val height = size.height
                val path = Path().apply {
                    moveTo(0f, height)
                    lineTo(width, height)
                    lineTo(width, 0f)
                    close()
                }
                drawPath(
                    path = path,
                    color = Color.LightGray,
                )

                clipRect(right = progress * width) {
                    drawPath(
                        path = path,
                        color = Color.Green.copy(0.8f)
                    )
                }
            }
            Canvas(
                modifier = Modifier.size(200.dp)
            ) {
                val width=size.width
                val height=size.height
                drawArc(
                    color = Color.LightGray,
                    startAngle = 270f,
                    sweepAngle = 360f,
                    useCenter = true,
                    topLeft = Offset(0f,0f),
                    style = Stroke(
                        width = 20f,
                        cap = StrokeCap.Round
                    )
                )
                drawArc(
                    color = Color.Black,
                    startAngle = 270f,
                    sweepAngle = 360f*progress,
                    useCenter = false,
                    topLeft = Offset(0f,0f),
                    style = Stroke(
                        width = 20f,
                        cap = StrokeCap.Round
                    )
                )

            }
            Canvas(
                modifier = Modifier.padding(16.dp).size(200.dp)
            ) {

                val width=size.width
                val height=size.height
                drawArc(
                    color = Color.LightGray,
                    startAngle = 120f,
                    sweepAngle = 300f,
                    useCenter = false,
                    topLeft = Offset(0f,0f),
                    style = Stroke(
                        width = 20f,
                        cap = StrokeCap.Round
                    )
                )
                drawArc(
                    color = Color.Black,
                    startAngle = 120f,
                    sweepAngle = 300f*progress,
                    useCenter = false,
                    topLeft = Offset(0f,0f),
                    style = Stroke(
                        width = 20f,
                        cap = StrokeCap.Round
                    )
                )
                drawText(
                    textMeasurer = measurer,
                    text = "${(progress*100).toInt()}%",
                    topLeft = center
                )

            }

            Slider(
                value = progress,
                onValueChange = {
                    progress = it
                },
                modifier = Modifier.padding(top = 16.dp).width(300.dp)
            )
        }
    }
}