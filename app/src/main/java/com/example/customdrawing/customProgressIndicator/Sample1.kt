package com.example.customdrawing.customProgressIndicator

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Sample1(progressValue: Int,size: Int){
    val value by animateFloatAsState(
        targetValue = progressValue.toFloat(),
        animationSpec = tween(1000, easing = LinearEasing)
    )
    Box(
        modifier = Modifier
            .size(size.dp)
            .padding(24.dp)
            .drawBehind{
                drawArc(
                    color = Color.LightGray,
                    startAngle = 150f,
                    sweepAngle = 240f,
                    useCenter = false,
                    style = Stroke(
                        width = 100f,
                        cap = StrokeCap.Round
                    )
                )
                drawArc(
                    color = Color.Blue,
                    startAngle = 150f,
                    sweepAngle = value*2.4f,
                    useCenter = false,
                    style = Stroke(
                        width = 100f,
                        cap = StrokeCap.Round
                    )
                )
            }
    ){
        Column (
            modifier = Modifier.align(Alignment.Center)
        ){
            Text(
                text = "Remaining",
                color = Color.LightGray,
                fontSize = 25.sp,
                modifier = Modifier.width(170.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "${value.toInt()} GB",
                color = Color.Black,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp).width(170.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomProgressIndicator1(){
    var value by remember { mutableIntStateOf(0) }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Sample1(
            progressValue = if(value<100){
                value
            }else{
                100
            },
            size = 350
        )
        TextField(
            value=value.toString(),
            onValueChange = {
                value=it.toInt()
            },
            modifier = Modifier.padding(top = 60.dp)
        )
    }
}

