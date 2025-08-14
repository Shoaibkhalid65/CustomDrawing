package com.example.customdrawing.ycharts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.model.AccessibilityConfig
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.barchart.models.BarStyle
import co.yml.charts.ui.barchart.models.SelectionHighlightData

@Composable
@Preview(showBackground = true)
fun BarChartSample1(){
    val barData= DataUtils.getBarChartData(5,100, BarChartType.VERTICAL, DataCategoryOptions())

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

    val yAxisData= AxisData.Builder()
        .steps(5)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData { i->
            (i*(100/5)).toString()
        }
        .startDrawPadding(20.dp)
        .build()

    val barChartData= BarChartData(
        chartData = barData,
        xAxisData=xAxisData,
        yAxisData=yAxisData,
        horizontalExtraSpace = 0.dp,
        backgroundColor = Color.Transparent,
        barStyle = BarStyle(
            barWidth = 30.dp,
            cornerRadius = 10.dp,
            paddingBetweenBars = 15.dp,
            isGradientEnabled = true,
            barBlendMode = BlendMode.SrcAtop,
            barDrawStyle = Stroke(width = 10f),
            selectionHighlightData = SelectionHighlightData(

            ),

        ),
        accessibilityConfig = AccessibilityConfig(),
        tapPadding = 30.dp,


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