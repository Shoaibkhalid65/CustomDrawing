package com.example.customdrawing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.customdrawing.customProgressIndicator.Sample1
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

        }
    }
}
