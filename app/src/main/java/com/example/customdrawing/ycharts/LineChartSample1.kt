package com.example.customdrawing.ycharts

import android.graphics.Typeface
import android.text.TextUtils
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.FilledIconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisConfig
import co.yml.charts.axis.AxisData
import co.yml.charts.axis.DataCategoryOptions
import co.yml.charts.axis.Gravity
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine

@Composable
@Preview(showBackground = true)
fun LineChartSample1(){
    val pointsData=listOf(
        Point(0f,40f),
        Point(1f, 10f),
        Point(2f, 0f),
        Point(3f, 60f),
        Point(4f, 10f),
        Point(5f, 90f),
        Point(6f, 10f),
    )
    val xAxisData= AxisData.Builder()
        .steps(6)
        .labelData { i->
            "${i * 10} h"
        }
        .axisPosition(Gravity.BOTTOM)
        .labelAndAxisLinePadding(15.dp)
        .axisOffset(10.dp)
        .topPadding(0.dp)
        .bottomPadding(2.dp)
        .startPadding(50.dp)
        .endPadding(50.dp)
        .axisStepSize(46.dp)
        .axisLabelAngle(360f)
        .axisLineColor(Color.Blue)
        .axisLabelColor(Color.Red)
        .axisLabelFontSize(TextUnit(15f, TextUnitType.Sp))
        .axisLineThickness(3.dp)
        .indicatorLineWidth(5.dp)
        .backgroundColor(Color.Transparent)
        .typeFace(Typeface.create(Typeface.SANS_SERIF,Typeface.ITALIC))
        .axisConfig(
            AxisConfig(
                  isAxisLineRequired = true,
                shouldEllipsizeAxisLabel = false,
                minTextWidthToEllipsize = 40.dp,
                ellipsizeAt = TextUtils.TruncateAt.START
             )
        )
        .startDrawPadding(0.dp)
        .shouldDrawAxisLineTillEnd(true)
        .axisLabelDescription { it }
        .setDataCategoryOptions(
            DataCategoryOptions(
                isDataCategoryInYAxis = false,
                isDataCategoryStartFromBottom = false
            )
        )
        .build()

    val steps=4
    val yAxisData = AxisData.Builder()
        .steps(steps)
        .axisPosition(Gravity.TOP)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(20.dp)
        .axisLabelAngle(110f)
        .labelData { i ->
            val yPoints=pointsData.map {
                it.y
            }
            val maxYPoint=yPoints.max()
            val yScale = ((100 / steps)*(maxYPoint/100))
            "${(i * yScale).toInt()} kg"
        }
        .axisLineColor(Color.Green)
        .backgroundColor(Color.Transparent)
        .build()

    val lineChartData= LineChartData(
        linePlotData = LinePlotData(
            lines=listOf(
                Line(
                    dataPoints = pointsData,
                    lineStyle = LineStyle(
                        lineType = LineType.SmoothCurve(isDotted = false, intervals = floatArrayOf(34f,5f)),
                        color = Color.Blue,
                        width = 1f,
                        alpha = 1f,
                        style = Stroke(width = 8f),
                        colorFilter = ColorFilter.tint(color = Color.Blue)
                    ),
                    intersectionPoint = IntersectionPoint(
                        color = Color.Red.copy(0.9f),
                        radius = 5.dp,
                        alpha = 1f,
                        style = Stroke(width = 5f),
                        draw = {center->
                            drawCircle(
                                color=Color.Black,
                                radius = 8f,
                                center=center
                            )
//                            drawRect(
//                                Color.Red,
//                                topLeft = Offset(center.x-10f,center.y-10f),
//                                size=Size(20f,20f)
//                            )
//                            drawArc(
//                                Color.Black,
//                                startAngle = 270f,
//                                sweepAngle = 330f,
//                                useCenter = true,
//                                topLeft = Offset(center.x-10f,center.y-10f),
//                                size=Size(20f,20f)
//                            ),

                        }
                    ),
                    selectionHighlightPoint = SelectionHighlightPoint(
                        color = Color.Magenta,
                        radius = 6.dp,
                        style = Fill,
                        isHighlightLineRequired = true,
                        drawHighlightLine = {start,end->
                            drawLine(
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Color.Red,
                                        Color.Cyan
                                    )
                                ),
                                start=start,
                                end=end,
                                strokeWidth = 6f
                            )
                        },
                    ),
                    shadowUnderLine = ShadowUnderLine(
                        color = Color.Blue,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Cyan,
                                Color.Magenta
                            )
                        ),
                        alpha = 0.1f,
//                        draw = {path->
//                            drawPath(
//                                color = Color.Red,
//                                path=path
//                            )
//                        },
                        drawMultiColor = {path,multiColor,brush->
                            drawPath(
                                path=path,
                                color = multiColor
                            )

                        }

                    ),
                    selectionHighlightPopUp = SelectionHighlightPopUp(
                        backgroundColor = Color.Magenta,
                        backgroundAlpha = 0.5f,
                        backgroundCornerRadius = CornerRadius(12f),
                        paddingBetweenPopUpAndPoint = 20.dp,
                        labelSize = 14.sp,
                        labelColor = Color.White,
                        popUpLabel = {x,y->
                            "x :$x y :$y"
                        }
                    )
                )
            )
        ),
        xAxisData = xAxisData,
        yAxisData=yAxisData,
        gridLines = GridLines(
            color = Color.Gray,
            lineWidth = 2.dp,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f),
            alpha = 1f,
            colorFilter = ColorFilter.tint(Color.Magenta, BlendMode.Saturation),
            blendMode = BlendMode.Src,
            enableHorizontalLines = true,
            enableVerticalLines = true,
            drawHorizontalLines = {xStart,y,xEnd->
                drawLine(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Magenta,
                            Color.Cyan
                        )
                    ),
                    start = Offset(xStart,y),
                    end = Offset(xEnd,y)
                )
            },
            drawVerticalLines = {x,yStart,yEnd->
                drawLine(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color.Magenta,
                            Color.Cyan
                        )
                    ),
                    start = Offset(x,yStart),
                    end = Offset(x,yEnd)
                )
            }
        ),
        backgroundColor = Color.Transparent
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LineChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            lineChartData = lineChartData
        )
    }
}