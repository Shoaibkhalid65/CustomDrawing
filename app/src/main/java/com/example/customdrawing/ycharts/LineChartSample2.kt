package com.example.customdrawing.ycharts


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisConfig
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine

@Composable
@Preview(showBackground = true)
fun LineChartSample2(){
    val dataPoints=listOf(
        Point(0f, 74f),
        Point(1f, 15.29f),
        Point(2f, 75.64f),
        Point(3f, 7.29f),
        Point(4f, 48.85f),
        Point(5f, 39.07f),
    )
    val months=listOf(
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun"
    )
    val xAxisData= AxisData.Builder()
        .steps(dataPoints.size-1)
        .axisStepSize(60.dp)
        .labelData { i->
            months[i]
        }
        .axisConfig(
            AxisConfig(
                isAxisLineRequired = false,
            )
        )
        .backgroundColor(Color.Transparent)
        .axisLabelColor(Color.LightGray)
        .labelAndAxisLinePadding(16.dp)
        .axisLabelFontSize(16.sp)
        .startPadding(20.dp)
        .startDrawPadding(10.dp)
        .build()

    val yAxisData= AxisData.Builder()
        .steps(3)
        .axisStepSize(50.dp)
        .labelData { i->
            val increment=22.78f
            val start=7.29f
            "%.2f".format(start+increment*i)
        }
        .axisConfig(
            AxisConfig(
                isAxisLineRequired = false,
            )
        )
        .labelAndAxisLinePadding(20.dp)
        .backgroundColor(Color.Transparent)
        .axisLabelColor(Color.LightGray)
        .axisLabelFontSize(16.sp)
        .build()

    val lineChartData= LineChartData(
        linePlotData = LinePlotData(
            plotType = PlotType.Line,
            lines = listOf(
                Line(
                    dataPoints=dataPoints,
                    lineStyle = LineStyle(
                        color = Color.LightGray
                    ),
                    intersectionPoint = IntersectionPoint(
                        alpha = 0.7f
                    ),
                    selectionHighlightPoint = SelectionHighlightPoint(),
                    shadowUnderLine = ShadowUnderLine(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Black.copy(0.1f),
                                Color.Transparent
                            )
                        )
                    ),
                    selectionHighlightPopUp = SelectionHighlightPopUp()
                )
            )
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        isZoomAllowed = true,
        backgroundColor = Color.Transparent,
        gridLines = GridLines(
            pathEffect = PathEffect.dashPathEffect(
                floatArrayOf(15f,30f)
            ),

        )

    )
    LineChart(
        modifier = Modifier.fillMaxWidth().height(300.dp),
        lineChartData=lineChartData
    )
}