package com.example.customdrawing.ycharts

import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.GroupBarChart
import co.yml.charts.ui.barchart.models.BarPlotData
import co.yml.charts.ui.barchart.models.GroupBarChartData

@Composable
@Preview(showBackground = true)
fun GroupedBarChartSample1(){
    val groupBarPlotData= BarPlotData(
        groupBarList = DataUtils.getGroupBarChartData(
            3,
            100,
            2
        ),
        barColorPaletteList = listOf(
            Color.Magenta,
            Color.Cyan,
            Color.Green,
            Color.Cyan,
            Color.Green
        )
    )
    val xAxisData= AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(5)
        .bottomPadding(20.dp)
        .labelData { index->
            "x label $index"
        }
        .startDrawPadding(0.dp)
        .build()
    val yAxisData= AxisData.Builder()
        .steps(5)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData {index->
            "y label $index"
        }
        .build()
    val groupBarChartData= GroupBarChartData(
        barPlotData = groupBarPlotData,
        xAxisData=xAxisData,
        yAxisData=yAxisData,

    )
    GroupBarChart(
        modifier = Modifier.height(300.dp),
        groupBarChartData = groupBarChartData
    )
}