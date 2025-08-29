package com.example.customdrawing.ycharts

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.PieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData

@Composable
@Preview(showBackground = true)
fun PieChartSample1(){
    val pieChartData= PieChartData(
        slices = listOf(
            PieChartData.Slice("SciFi",50f,Color(0xFF333333)),
            PieChartData.Slice("Comedy",35f,Color(0xFF666a86)),
            PieChartData.Slice("Drama",1f,Color(0xFF95B8D1)),
            PieChartData.Slice("Romance",40f,Color(0xFFF53844))
        ),
        plotType = PlotType.Pie
    )
    val pieChartConfig= PieChartConfig(
        isAnimationEnable = true,
        showSliceLabels = false,
        animationDuration = 1500
    )
    PieChart(
        modifier = Modifier.size(400.dp),
        pieChartData = pieChartData,
        pieChartConfig = pieChartConfig
    )
}