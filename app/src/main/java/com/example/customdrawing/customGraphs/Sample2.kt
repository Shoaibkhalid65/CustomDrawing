package com.example.customdrawing.customGraphs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun Sample2(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val height=with(LocalDensity.current){1000f.toDp()}
        val measurer= rememberTextMeasurer()
        Box(
            modifier = Modifier.size(300.dp,height).drawWithContent{
                drawRect(
                    color = Color.LightGray,
                    style = Stroke(
                        width = 10f
                    )
                )
                repeat(10) {
                    drawLine(
                        color = Color.LightGray,
                        start = Offset(0f, it * 100f),
                        end = Offset(size.width, it * 100f),
                        strokeWidth = 10f
                    )
                    drawText(
                        textMeasurer = measurer,
                        text = "${100 - it * 10}",
                        topLeft = Offset(-75f, it * 100f - 20f),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                graphItems.forEachIndexed {index, (name,value)->
                    drawRoundRect(
                        color = colors[index],
                        topLeft = Offset((index)*100f+10f*(index+1),size.height-(value*10)),
                        size = Size(100f,(value*10)),
                        cornerRadius = CornerRadius(24f,24f)
                    )
                    drawText(
                        textMeasurer = measurer,
                        text = name,
                        topLeft = Offset(index*100f+10f*(index+1),-50f),
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }
            }
        )
    }
}
val graphItems=listOf(
    "Item 1" to 78f,
    "Item 2" to 24f,
    "Item 3" to 92f,
    "Item 4" to 60f,
    "Item 5" to 20f,
    "Item 6" to 99f,
)
val colors=listOf(
    Color.Blue,
    Color.Cyan,
    Color.Green,
    Color.Magenta,
    Color.Red,
    Color.Black
)