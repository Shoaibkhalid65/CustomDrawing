package com.example.customdrawing.customGraphs

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


// not a good composable to draw the charts because it draws the canvas composable for each value
@Composable
@Preview(showBackground = true)
fun PerformanceChart() {
    val list: List<Float> = listOf(10f,20f,6f,11f,34f,36f,12f,67f,23f,1f,11f)
    val zipList: List<Pair<Float, Float>> = list.zipWithNext()

    Row(modifier = Modifier) {
        val max = list.max()
        val min = list.min()

        val lineColor =
            if (list.last() > list.first()) Color.Green else Color.Red // <-- Line color is Green if its going up and Red otherwise

        for (pair in zipList) {

            val fromValuePercentage = getValuePercentageForRange(pair.first, max, min)
            val toValuePercentage = getValuePercentageForRange(pair.second, max, min)

            Canvas(
                modifier = Modifier
                    .size(300.dp)
                    .weight(1f),
                onDraw = {
                    val fromPoint = Offset(x = 0f, y = size.height.times(1 - fromValuePercentage)) // <-- Use times so it works for any available space
                    val toPoint =
                        Offset(x = size.width, y = size.height.times(1 - toValuePercentage)) // <-- Also here!

                    drawLine(
                        color = lineColor,
                        start = fromPoint,
                        end = toPoint,
                        strokeWidth = 3f
                    )
                })
        }


    }

}
private fun getValuePercentageForRange(value: Float,max: Float,min: Float): Float {
    return (value-min)/(max-min)
}

// A good composable to draw the charts very awesome

@Composable
@Preview(showBackground = true)
fun PerformanceChartByPath(){
    val list=listOf(10f,20f,6f,11f,34f,36f,12f,67f,23f,1f,11f)
    Canvas(
        modifier = Modifier.fillMaxWidth().heightIn(300.dp)
    ) {
        if(list.size<2) return@Canvas

        val max=list.max()
        val min=list.min()
        val lines=list.size-1

        val widthPerStep=size.width/lines
        val height=size.height

        val lineColor=if(list.last()>list.first()) Color.Green else Color.Red

        val percentages= list.map { (it-min)/(max-min)}

        val path= Path().apply {
            moveTo(0f,height*(1-percentages.first()))
            for(i in 1 until list.size){
                lineTo(widthPerStep*i,height*(1-percentages[i]))
            }
        }
        drawPath(
            color = lineColor,
            path=path,
            style = Stroke(
                width=3f
            )
        )
    }
}

