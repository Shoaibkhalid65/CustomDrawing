package com.example.customdrawing.ycharts

import android.graphics.Typeface
import android.text.TextUtils
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.common.model.AccessibilityConfig
import co.yml.charts.common.model.PlotType
import co.yml.charts.ui.piechart.charts.DonutPieChart
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
            PieChartData.Slice("Drama",18f,Color(0xFF95B8D1)),
            PieChartData.Slice("Romance",40f,Color(0xFFF53844)),
            PieChartData.Slice("Movies",33f,Color.Cyan)
        ),
        plotType = PlotType.Donut
    )
    val pieChartConfig= PieChartConfig(
         startAngle = 10f,
        showSliceLabels = true,
        sliceLabelTextSize = 14.sp,
        sliceLabelTextColor = Color.Green,
        sliceLabelTypeface = Typeface.MONOSPACE,
        isAnimationEnable = false,
        animationDuration = 300,
        strokeWidth = 150f,
        labelFontSize = 40.sp,
        labelTypeface = Typeface.SANS_SERIF,
        labelVisible = true,
        labelType = PieChartConfig.LabelType.VALUE,
        labelColor = Color.Yellow,
        labelColorType = PieChartConfig.LabelColorType.SPECIFIED_COLOR,
        backgroundColor = Color.Magenta,
        activeSliceAlpha = .5f,
        inActiveSliceAlpha = 1f,
        isEllipsizeEnabled = true,
        sliceMinTextWidthToEllipsize = 40.dp,
        sliceLabelEllipsizeAt = TextUtils.TruncateAt.START,
        chartPadding = 20,
        accessibilityConfig = AccessibilityConfig(),
        isSumVisible = true,
    )
    DonutPieChart(
        modifier = Modifier.size(400.dp),
        pieChartData = pieChartData,
        pieChartConfig = pieChartConfig
    )
}