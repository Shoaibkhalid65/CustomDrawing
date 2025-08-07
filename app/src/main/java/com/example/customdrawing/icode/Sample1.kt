package com.example.customdrawing.icode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun Sample1(){
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.9f)),
        contentAlignment = Alignment.Center
    ){
        Card (
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
            ,
            shape = CustomCurvedShape2(100f,50f),

        ){
            Text(
                text = "Hello Curved card",
                modifier = Modifier.padding(35.dp),
                fontSize = 32.sp
            )

        }
//        Canvas(
//            modifier = Modifier
//                .padding(horizontal = 30.dp)
//                .fillMaxWidth()
//                .fillMaxHeight(0.6f)
//                .background(Color.White)
//        ) {
//            val cornerRadius=40f
//            val path1=Path().apply {
//                moveTo(0f+cornerRadius,0f)
//                lineTo(size.width-cornerRadius,0f)
//                arcTo(
//                    rect = Rect(
//                        left = size.width-cornerRadius*2,
//                        right = size.width,
//                        top = 0f,
//                        bottom = cornerRadius*2
//                    ),
//                    startAngleDegrees = 270f,
//                    sweepAngleDegrees = 90f,
//                    forceMoveTo = false
//                )
//                lineTo(size.width,size.height/2)
//                arcTo(
//                    rect = Rect(
//                        offset = Offset(size.width - 50f, size.height / 2),
//                        size = Size(100f, 100f)
//                    ),
//                    startAngleDegrees = 270f,
//                    sweepAngleDegrees = -180f,
//                    forceMoveTo = false
//                )
//                lineTo(size.width,size.height-cornerRadius)
//                arcTo(
//                    rect = Rect(
//                        left = size.width-cornerRadius*2,
//                        right = size.width,
//                        top = size.height-cornerRadius*2,
//                        bottom = size.height
//                    ),
//                    startAngleDegrees = 0f,
//                    sweepAngleDegrees = 90f,
//                    forceMoveTo = false
//                )
//                lineTo(0+cornerRadius,size.height)
//                arcTo(
//                    rect = Rect(
//                        left =0f,
//                        right = 0f+cornerRadius*2,
//                        top = size.height-cornerRadius*2,
//                        bottom = size.height
//                    ),
//                    startAngleDegrees = 90f,
//                    sweepAngleDegrees = 90f,
//                    forceMoveTo = false
//                )
//                lineTo(0f,size.height/2+100f)
//                arcTo(
//                    rect = Rect(
//                        offset = Offset(-50f, size.height / 2),
//                        size = Size(100f, 100f)
//                    ),
//                    startAngleDegrees = 90f,
//                    sweepAngleDegrees = -180f,
//                    forceMoveTo = false
//                )
//                lineTo(0f,0f+cornerRadius)
//                arcTo(
//                    rect = Rect(
//                        left =0f,
//                        right = cornerRadius*2,
//                        top = 0f,
//                        bottom = cornerRadius*2
//                    ),
//                    startAngleDegrees = 180f,
//                    sweepAngleDegrees = 90f,
//                    forceMoveTo = false
//                )
//
//
//
//            }
//            val path= Path().apply {
//                lineTo(0f,size.height/2)
//                arcTo(
//                    rect = Rect(
//                        offset = Offset(-50f,size.height/2),
//                        size= Size(100f,100f)
//                    ),
//                    startAngleDegrees = 270f,
//                    sweepAngleDegrees = 180f,
//                    forceMoveTo = false
//                )
//                lineTo(0f,size.height)
//                lineTo(size.width,size.height)
//                lineTo(size.width,size.height/2+100f)
//                arcTo(
//                    rect = Rect(
//                        offset = Offset(size.width-50f,size.height/2),
//                        size=Size(100f,100f)
//                    ),
//                    startAngleDegrees = 90f,
//                    sweepAngleDegrees = 180f,
//                    forceMoveTo = false
//                )
//                lineTo(size.width,0f)
//                close()
//            }
//            drawPath(path1,Color.Blue, style = Stroke(width = 3.dp.toPx()))
//        }
    }
}


class CustomCurvedShape: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            lineTo(0f, size.height / 2)
            arcTo(
                rect = Rect(
                    offset = Offset(-50f, size.height / 2),
                    size = Size(100f, 100f)
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 180f,
                forceMoveTo = false
            )
            lineTo(0f, size.height)
            lineTo(size.width, size.height)
            lineTo(size.width, size.height / 2 + 100f)
            arcTo(
                rect = Rect(
                    offset = Offset(size.width - 50f, size.height / 2),
                    size = Size(100f, 100f)
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 180f,
                forceMoveTo = false
            )
            lineTo(size.width, 0f)
            close()
        }
        return Outline.Generic(path)
    }
}
class CustomCurvedShape1(val cornerRadius: Float=40f,val arcSize: Float=100f): Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path=Path().apply {
            moveTo(0f+cornerRadius,0f)
            lineTo(size.width-cornerRadius,0f)
            arcTo(
                rect = Rect(
                    left = size.width-cornerRadius*2,
                    right = size.width,
                    top = 0f,
                    bottom = cornerRadius*2
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(size.width,size.height/2)
            arcTo(
                rect = Rect(
                    offset = Offset(size.width - arcSize/2, size.height / 2),
                    size = Size(arcSize, arcSize)
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = -180f,
                forceMoveTo = false
            )
            lineTo(size.width,size.height-cornerRadius)
            arcTo(
                rect = Rect(
                    left = size.width-cornerRadius*2,
                    right = size.width,
                    top = size.height-cornerRadius*2,
                    bottom = size.height
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(0+cornerRadius,size.height)
            arcTo(
                rect = Rect(
                    left =0f,
                    right = 0f+cornerRadius*2,
                    top = size.height-cornerRadius*2,
                    bottom = size.height
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )
            lineTo(0f,size.height/2+100f)
            arcTo(
                rect = Rect(
                    offset = Offset(-arcSize/2, size.height / 2),
                    size = Size(arcSize, arcSize)
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = -180f,
                forceMoveTo = false
            )
            lineTo(0f,0f+cornerRadius)
            arcTo(
                rect = Rect(
                    left =0f,
                    right = cornerRadius*2,
                    top = 0f,
                    bottom = cornerRadius*2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )



        }
        return Outline.Generic(path)
    }

}
class CustomCurvedShape2(val cornerRadius: Float=40f,val arcRadius: Float=100f): Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val width=size.width
        val height=size.height
        val path = Path().apply {
            addRoundRect(
                roundRect = RoundRect(
                    left = 0f,
                    right = width,
                    top = 0f,
                    bottom = height,
                    radiusY = cornerRadius,
                    radiusX = cornerRadius
                )
            )
            moveTo(0f,height/2)
            addArc(
                oval = Rect(
                    center = Offset(0f,height/2f),
                    radius = arcRadius
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 180f
            )
            moveTo(width,height/2)
            addArc(
                oval = Rect(
                    center = Offset(width,height/2f),
                    radius = arcRadius
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 180f
            )
        }
        return Outline.Generic(path)
    }

}


