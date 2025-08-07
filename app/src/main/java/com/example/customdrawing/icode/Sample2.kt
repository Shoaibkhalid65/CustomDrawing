package com.example.customdrawing.icode

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun Sample2(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier.height(620.dp).width(240.dp).clip(
                CustomCurveShape(20f)).background(Color.LightGray)
        ){
            Text(
                fontSize = 20.sp,
                text = "Hello from the curved box",
                modifier = Modifier.align(alignment = Alignment.Center)
            )
        }
    }
}
class CustomCurveShape(val curveSize: Float=10f): Shape{
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val straightHeight=size.height/2-10f
        val cHeight=0f
        val c1Width=size.width/5
        val c2Width=size.width/5*4
        val path= Path().apply {
            moveTo(curveSize,size.height)
            lineTo(size.width-curveSize,size.height)
            lineTo(size.width,straightHeight)
            cubicTo(c2Width,cHeight,c1Width,cHeight,0f,straightHeight)
            close()
        }
        return Outline.Generic(path)
    }

}