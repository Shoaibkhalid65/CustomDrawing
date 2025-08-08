package com.example.customdrawing.customLayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun Sample6(){
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Red,customHeartShape)

    )
}
val customHeartShape= GenericShape{size,_->
    val width=size.width
    val height=size.height
    moveTo(width/2,height/5)
    cubicTo(
        x1 = 5 * width / 14, y1 = 0f,
        x2 = 0f, y2 = height / 15,
        x3 = width / 28,y3 = 2 * height / 5
    )
    cubicTo(
        x1 = width / 14, y1 = 2 * height / 3,
        x2 = 3 * width / 7, y2 = 5 * height / 6,
        x3 = width / 2, y3 = height
    )
    cubicTo(
        x1 = 4 * width / 7, y1 = 5 * height / 6,
        x2 = 13 * width / 14, y2 = 2 * height / 3,
        x3 = 27 * width / 28, y3 = 2 * height / 5
    )
    cubicTo(
        x1 = width, y1 = height / 15,
        x2 = 9 * width / 14, y2 = 0f,
        x3 = width / 2, y3 = height / 5
    )

    close()
}
