package com.example.customdrawing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.customdrawing.ycharts.BarChartSample1
import com.example.customdrawing.ycharts.BarchartWithGradientBars
import com.example.customdrawing.ycharts.BarchartWithSolidBars
import com.example.customdrawing.ycharts.GroupedBarChartSample1
import com.example.customdrawing.ycharts.GroupedBarChartSample2
import com.example.customdrawing.ycharts.LineChartSample1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GroupedBarChartSample2()
        }
    }
}

