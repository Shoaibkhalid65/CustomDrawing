package com.example.customdrawing.customLayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun CustomSample4(){
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ){
        Box(
            modifier = Modifier
                .size(300.dp)
                .background(
                    Color.Red,
                    CustomDialogShape()
                )
                .clip(CustomDialogShape())
                .align(Alignment.Center)
        ){
            Text(
                text = "Hello",
                modifier = Modifier.padding(start = 120.dp, top = 30.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
class CustomDialogShape(val circleRadius: Float=200f): Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width=size.width
        val height=size.height
        val path= Path().apply {
            moveTo(0f,circleRadius)
            lineTo(width/2-circleRadius,circleRadius)
            arcTo(
                Rect(
                    center = Offset(width/4+circleRadius,circleRadius),
                    radius = circleRadius
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 180f,
                forceMoveTo = false
            )
            lineTo(width,circleRadius)
            lineTo(width,height)
            lineTo(0f,height)
            lineTo(0f,circleRadius)
            close()
        }
        return Outline.Generic(path)
    }

}