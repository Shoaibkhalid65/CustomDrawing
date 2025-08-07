package com.example.customdrawing.customLayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun Sample1(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .drawBehind{
                val path= Path().apply {
                    lineTo(0f,size.height/2)
                    cubicTo(size.width/10*6,size.height/2+150,size.width/10*4,size.height/2-150,size.width,size.height/2+50f)
                    lineTo(size.width,0f)
                    close()
                }
                drawPath(path,Color.Blue)
            }
    ){
        Text(
            text = "Hello from the custom layout that uses the bezier curve",
            modifier = Modifier.padding(30.dp),
            fontSize = 32.sp
        )
        Button(
            onClick = {},
            modifier = Modifier.align(Alignment.Center).padding(top = 200.dp)
        ) {
            Text(
                text = "Click me"
            )
        }

    }
}