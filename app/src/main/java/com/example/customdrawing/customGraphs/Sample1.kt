package com.example.customdrawing.customGraphs

import android.widget.Space
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun Sample1(){
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.9f)),
        contentAlignment = Alignment.Center
    ){
        val animationProgress= remember { Animatable(0f) }
        LaunchedEffect(Unit) {
            while (true) {
                animationProgress.animateTo(1f, tween(12000))
                animationProgress.snapTo(0f)
            }
        }
        Canvas(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .aspectRatio(3/2f)
                .fillMaxSize()
                .border(
                    width = 3.dp,
                    color = Color.DarkGray
                )
        ) {

            val widthDistance=size.width/5f
            val verticalLines=4
            var x=widthDistance
            val heightDistance=size.height/4f
            val horizontalLines=3
            var y=heightDistance
            repeat(verticalLines){
                drawLine(
                    color = Color.DarkGray,
                    start = Offset(x,0f),
                    end = Offset(x,size.height),
                    strokeWidth = 3.dp.toPx()
                )
                x+=widthDistance
            }
            repeat(horizontalLines){
                drawLine(
                    color = Color.DarkGray,
                    start = Offset(0f,y),
                    end = Offset(size.width,y),
                    strokeWidth = 3.dp.toPx()
                )
                y+=heightDistance
            }
        }
        Spacer(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .aspectRatio(3/2f)
                .fillMaxSize()
                .drawWithCache{
                    val path=generatePath(data,size)
                    val filledPath=Path()
                    filledPath.addPath(path)
                    filledPath.lineTo(size.width,size.height)
                    filledPath.lineTo(0f,size.height)
                    filledPath.close()
                    val brush= Brush.verticalGradient(
                        listOf(
                            Color.Green.copy(0.4f),
                            Color.Transparent
                        )
                    )
                    onDrawBehind {
                        clipRect(right = size.width*animationProgress.value) {
                            drawPath(
                                path = path,
                                color = Color.Green,
                                style = Stroke(
                                    width = 5.dp.toPx()
                                )
                            )
                            drawPath(
                                path = filledPath,
                                brush = brush
                            )
                        }
                    }
                }
        )
    }
}
fun generatePath(data: List<Offset>,size: Size): Path{
    val path=Path()
    data.firstOrNull()?.let { path.moveTo(it.x,it.y) }
    data.drop(1).forEach { offset ->
        path.lineTo(offset.x,offset.y)
    }
    return path
}
val data = listOf(
    Offset(0f, 600f),
    Offset(100f, 595f),
    Offset(200f, 587.5f),
    Offset(300f, 475f),
    Offset(400f, 550f),
    Offset(500f, 525f),
    Offset(600f, 300f),
    Offset(700f, 150f),
    Offset(800f, 150f),
    Offset(900f, 112.5f),
    Offset(1000f, 50f)
)

