package com.example.customdrawing.ycharts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.common.model.Point
import co.yml.charts.common.utils.DataUtils
import co.yml.charts.ui.barchart.BarChart
import co.yml.charts.ui.barchart.models.BarChartData
import co.yml.charts.ui.barchart.models.BarChartType
import co.yml.charts.ui.barchart.models.BarData
import co.yml.charts.ui.barchart.models.BarStyle
import co.yml.charts.ui.barchart.models.SelectionHighlightData

@Composable
@Preview(showBackground = true)
fun HorizontalBarChartSample1(){
    val barData=listOf(
        BarData(
            point = Point(10f,0f),
            color = Color.Green,
            label = "bar 1",
            gradientColorList = listOf(
                Color.Yellow,
                Color.Cyan
            ),
            dataCategoryOptions = DataCategoryOptions(isDataCategoryInYAxis = true)
        ),
        BarData(
            point = Point(30f,1f),
            color = Color.Red,
            label = "bar 2",
            gradientColorList = listOf(
                Color.Yellow,
                Color.Cyan
            ),
            dataCategoryOptions = DataCategoryOptions(isDataCategoryInYAxis = true),

        ),
        BarData(
            point = Point(30f,2f),
            color = Color.Blue,
            label = "bar 3",
            gradientColorList = listOf(
                Color.Yellow,
                Color.Cyan
            ),
            dataCategoryOptions = DataCategoryOptions(isDataCategoryInYAxis = true)
        ),

    )
    val xAxisData= AxisData.Builder()
        .steps(2)
        .bottomPadding(12.dp)
        .endPadding(50.dp)
        .labelData {i-> "label $i"}
        .build()
    val yAxisData= AxisData.Builder()
        .axisStepSize(30.dp)
        .steps(2)
        .labelAndAxisLinePadding(20.dp)
        .labelData { i-> "y label $i" }
        .axisOffset(20.dp)
        .setDataCategoryOptions(
            DataCategoryOptions(
                isDataCategoryInYAxis = true,
                isDataCategoryStartFromBottom = false
            )
        )
        .startDrawPadding(48.dp)

        .build()
    val barChartData= BarChartData(
        chartData = barData,
        xAxisData=xAxisData,
        yAxisData=yAxisData,
        backgroundColor = Color.Transparent,
        barStyle = BarStyle(
            barWidth = 35.dp,
            cornerRadius = 8.dp,
            paddingBetweenBars = 20.dp,
            isGradientEnabled = true,
            barBlendMode = BlendMode.Src,
            barDrawStyle = Stroke(
                width = 5f,
                miter = 8f,
                cap = StrokeCap.Round,
                pathEffect = PathEffect.dashPathEffect(
                    intervals = floatArrayOf(10f,10f,)
                )
            ),
            selectionHighlightData = SelectionHighlightData(
                highlightBarColor = Color.Magenta,
                highlightTextBackgroundColor = Color.Cyan,
                popUpLabel = {x,_-> "x : $x"},
                barChartType = BarChartType.HORIZONTAL

            )
        ),
        barChartType = BarChartType.HORIZONTAL
    )
    BarChart(
        modifier = Modifier.height(200.dp),
        barChartData = barChartData
    )
}

//@Composable
//@Preview(showBackground = true)
//private fun HorizontalBarChart() {
//    val maxRange = 30
//    val barData =
//        DataUtils.getBarChartData(
//            10,
//            maxRange,
//            BarChartType.HORIZONTAL,
//            DataCategoryOptions(isDataCategoryInYAxis = true)
//        )
//    val xStepSize = 10
//
//    val xAxisData = AxisData.Builder()
//        .steps(xStepSize)
//        .bottomPadding(12.dp)
//        .endPadding(50.dp)
//        .labelData { index -> (index * (maxRange / xStepSize)).toString() }
//        .build()
//    val yAxisData = AxisData.Builder()
//        .axisStepSize(30.dp)
//        .steps(barData.size - 1)
//        .labelAndAxisLinePadding(20.dp)
//        .axisOffset(20.dp)
//        .setDataCategoryOptions(
//            DataCategoryOptions(
//                isDataCategoryInYAxis = true,
//                isDataCategoryStartFromBottom = false
//            )
//        )
//        .startDrawPadding(48.dp)
//        .labelData { index -> barData[index].label }
//        .build()
//    val barChartData = BarChartData(
//        chartData = barData,
//        xAxisData = xAxisData,
//        yAxisData = yAxisData,
//        barStyle = BarStyle(
//            isGradientEnabled = false,
//            paddingBetweenBars = 20.dp,
//            barWidth = 35.dp,
//            selectionHighlightData = SelectionHighlightData(
//                highlightBarColor = Color.Red,
//                highlightTextBackgroundColor = Color.Green,
//                popUpLabel = { x, _ -> " Value : $x " },
//                barChartType = BarChartType.HORIZONTAL
//            ),
//        ),
//        showYAxis = true,
//        showXAxis = true,
//        horizontalExtraSpace = 20.dp,
//        barChartType = BarChartType.HORIZONTAL
//    ).also {
//        BarChart(
//            modifier = Modifier.height(350.dp),
//            barChartData = it
//        )
//    }
//}