package com.example.customdrawing.ycharts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.model.Point
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.barchart.models.BarStyle

@Composable
@Preview(showBackground = true)
fun BarChartSample3(){
    val barData=listOf(
        BarData(
            point = Point(0f, 100f),
            color = Color.Green,
            label = "item 1",
            gradientColorList = listOf(Color.Magenta,Color.Cyan),
            dataCategoryOptions = DataCategoryOptions()
        ),
        BarData(
            point = Point(1f, 70f),
            color = Color.Green,
            label = "item 1",
            gradientColorList = listOf(Color.Magenta,Color.Cyan),
            dataCategoryOptions = DataCategoryOptions()
        ),
        BarData(
            point = Point(2f, 80f),
            color = Color.Green,
            label = "item 1",
            gradientColorList = listOf(Color.Magenta,Color.Cyan),
            dataCategoryOptions = DataCategoryOptions()
        ),
        BarData(
            point = Point(3f, 50f),
            color = Color.Green,
            label = "item 1",
            gradientColorList = listOf(Color.Magenta,Color.Cyan),
            dataCategoryOptions = DataCategoryOptions()
        ),
        BarData(
            point = Point(4f, 75f),
            color = Color.Green,
            label = "item 1",
            gradientColorList = listOf(Color.Magenta,Color.Cyan),
            dataCategoryOptions = DataCategoryOptions()
        ),
        BarData(
            point = Point(5f, 50f),
            color = Color.Green,
            label = "item 1",
            gradientColorList = listOf(Color.Magenta,Color.Cyan),
            dataCategoryOptions = DataCategoryOptions()
        ),
        BarData(
            point = Point(6f, 60f),
            color = Color.Green,
            label = "item 1",
            gradientColorList = listOf(Color.Magenta,Color.Cyan),
            dataCategoryOptions = DataCategoryOptions()
        ),

    )
    val xAxisData= AxisData.Builder()
        .axisStepSize(10.dp)
        .steps(barData.size)
        .bottomPadding(0.dp)
        .axisLabelAngle(0f)
        .axisOffset(30.dp)
        .labelData {i-> barData[i].label }
        .startPadding(50.dp)
        .startDrawPadding(30.dp)
        .build()



    val barChartData= BarChartData(
        chartData = barData,
        xAxisData=xAxisData,
        backgroundColor = Color.White,
        showYAxis = false,
        barStyle = BarStyle(
            barWidth = 40.dp,
            cornerRadius = 12.dp,
            isGradientEnabled = true,

        ),
        
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        BarChart(
            modifier = Modifier.height(350.dp),
            barChartData = barChartData
        )
    }
}
