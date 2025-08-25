package com.example.customdrawing.ycharts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisConfig
import co.yml.charts.axis.AxisData
import co.yml.charts.common.components.Legends
import co.yml.charts.common.model.LegendsConfig
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.GroupBarChart
import co.yml.charts.ui.barchart.models.BarPlotData
import co.yml.charts.ui.barchart.models.BarStyle
import co.yml.charts.ui.barchart.models.GroupBarChartData
import co.yml.charts.ui.barchart.models.GroupSeparatorConfig

@Composable
@Preview(showBackground = true)
fun GroupedBarChartSample2(){
    val maxRange = 100
    val barSize = 2
    val groupBarData = DataUtils.getGroupBarChartData(5, maxRange, barSize)
    val yStepSize = 10
    val xAxisData = AxisData.Builder()
        .axisStepSize(20.dp)
        .bottomPadding(5.dp)
        .startDrawPadding(10.dp)
        .labelData { index -> "x label is $index" }
        .axisConfig(AxisConfig(isAxisLineRequired = false))
        .build()
    val yAxisData = AxisData.Builder()
        .steps(yStepSize)
        .labelAndAxisLinePadding(20.dp)
        .axisOffset(20.dp)
        .labelData { index -> (index * (maxRange / yStepSize)).toString() }
        .build()
    val colorPaletteList = DataUtils.getColorPaletteList(barSize)
    val legendsConfig = LegendsConfig(
        legendLabelList = DataUtils.getLegendsLabelData(colorPaletteList),
        gridColumnCount = 3
    )
    val groupBarPlotData = BarPlotData(
        groupBarList = groupBarData,
        barStyle = BarStyle(barWidth = 35.dp),
        barColorPaletteList = colorPaletteList
    )
    val groupBarChartData = GroupBarChartData(
        barPlotData = groupBarPlotData,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        groupSeparatorConfig = GroupSeparatorConfig(0.dp)
    )
    Column(
        Modifier
            .height(450.dp)
    ) {
        GroupBarChart(
            modifier = Modifier
                .height(400.dp),
            groupBarChartData = groupBarChartData
        )
        Legends(
            legendsConfig = legendsConfig
        )
    }
}
