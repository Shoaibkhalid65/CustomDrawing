package com.example.customdrawing.customLayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun Sample2(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .drawWithCache{
                val height=size.height/4
                val width=size.width
                val path1= Path().apply {
                    lineTo(0f,height)
                    cubicTo(width*.316f,height-height*.292f,width*.5f,height*1.13f,width,height*1.06f)
                    lineTo(width,0f)
                    close()
                }
                val path2=Path().apply {
                    moveTo(0f,height)
                    lineTo(0f,height-height*.51f)
                    cubicTo(width*.405f,height-height*.668f,width*.57f,height-height*.113f,width*0.9f,height*1.07f)
                    close()
                }
                val path3=Path().apply {
                    moveTo(0f,height-height*.51f)
                    lineTo(0f,height*.14f)
                    cubicTo(width*.255f,height*.317f,width*.326f,height*.342f,width*.5f,height-height*.3f)
                    close()
                }
                val path4=Path().apply {
                    moveTo(width,height*1.06f)
                    lineTo(width,height-height*.5f)
                    quadraticTo(width-width*.1026f,height-.136f,width*.71f,height)
                    lineTo(width-width*.10f,height*1.06f)
                    close()
                }
                val path5=Path().apply {
                    moveTo(width,height-height*.5f)
                    lineTo(width,0f)
                    quadraticTo(width-width*.08f,height*.5f,width*.1f,height)
                    lineTo(width,height)
                    close()
                }
                onDrawBehind {
                   drawPath(
                       path = path1,
                       brush = Brush.horizontalGradient(
                           listOf(
                               Color(0xFFCB356B),
                               Color(0xFFBD3F32),

                           )
                       )
                   )
                   clipPath(path1) {
                       drawPath(
                           path = path2,
                           brush = Brush.horizontalGradient(
                               listOf(
                                   Color(0xFFb91d73),
                                   Color(0xFFf953c6),

                               )
                           )
                       )
                   }
                   clipPath(path2, clipOp = ClipOp.Difference){
                       drawPath(
                           path=path3,
                           brush = Brush.horizontalGradient(
                               listOf(
                                   Color(0xFFF2994A),
                                   Color(0xFFF2C94C)
                               )
                           ),
                       )
                   }
                    clipPath(path2, clipOp = ClipOp.Difference){
                        drawPath(
                            path=path4,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xFF200122),
                                    Color(0xFF6f0000)
                                )
                            ),

                        )
                    }
                    clipPath(path4, clipOp = ClipOp.Difference){
                        clipPath(path2, clipOp = ClipOp.Difference){
                            drawPath(
                                path = path5,
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color(0xFFF09819),
                                        Color(0xFFEDDE5D)
                                    )
                                ),
                            )
                        }
                    }
                }
            }
    ){
        Column (
            modifier = Modifier.padding(top = 120.dp, start = 15.dp)
        ){
            Text(
                text = "Good Morning",
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp
            )
            Text(
                text = "Satwik Pachino",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 24.sp
            )
        }
        Column (
            modifier = Modifier.align(Alignment.TopEnd).padding(end = 35.dp, top = 95.dp)
        ){
            Icon(
                imageVector = Icons.Default.Cloud,
                contentDescription = "Cloud",
                tint = Color.White,
                modifier = Modifier.size(36.dp)
            )
            Text(
                text = "21 C",
                color = Color.White,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
            Text(
                text = "Cloudy",
                color=Color.White,
                fontSize = 14.sp

            )
        }

    }
}