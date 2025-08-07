package com.example.customdrawing.customLayouts


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun Sample5(){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color.Magenta, shape = SpeechBubbleShape(
                    cornerRadius = 50f,
                    arcSize = 60f
                    )
                )
                .clip(SpeechBubbleShape())
                .align(Alignment.Center)
        )
    }
}

class SpeechBubbleShape(val cornerRadius: Float=40f,val arcSize: Float=50f): Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width=size.width
        val height=size.height
        val path= Path().apply {
            moveTo(arcSize+cornerRadius,0f)
            lineTo(width-cornerRadius,0f)
            arcTo(
                rect = Rect(
                    left = width-cornerRadius*2,
                    right = width,
                    top = 0f,
                    bottom = cornerRadius*2
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(width,height-arcSize-cornerRadius)
            arcTo(
                rect = Rect(
                    left = width-cornerRadius*2,
                    right = width,
                    top = height-arcSize-cornerRadius*2,
                    bottom = height-arcSize
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(cornerRadius*1+arcSize,height-arcSize)
            lineTo(0f,height)
            lineTo(arcSize,height-arcSize-cornerRadius*1)
            lineTo(arcSize,cornerRadius)
            arcTo(
                rect = Rect(
                    left = arcSize,
                    right = cornerRadius*2+arcSize,
                    top = 0f,
                    bottom = cornerRadius*2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
        }
        return Outline.Generic(path=path)
    }

}
