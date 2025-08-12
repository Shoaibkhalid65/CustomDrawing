package com.example.customdrawing.customLayouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.customdrawing.couponDesign.CouponShape
import com.example.customdrawing.couponDesign.rippleClickable

@Composable
@Preview(showBackground = true)
fun Sample9(){
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(120.dp)
                .clip(CouponShape(7.20.dp))
                .drawWithCache{
                    val height=size.height
                    val width=size.width
                    onDrawWithContent {
                        drawRect(
                            color = Color.White,
                            topLeft = Offset(0f,0f),
                            size= Size(width/3f,height)
                        )
                        drawRect(
                            color = Color.Blue,
                            topLeft = Offset(width/3f,0f),
                            size=Size(width*2/3,height)
                        )
                        drawLine(
                            color = Color.White,
                            start = Offset(width/2,0f),
                            end = Offset(width/2,height),
                            strokeWidth = 10f,
                            cap = StrokeCap.Round,
                            pathEffect = PathEffect.dashPathEffect(
                                intervals = floatArrayOf(10f,20f),
                                phase =5f
                            )

                        )
                        drawContent()
                    }
                }

        ){
            Row(
                modifier = Modifier.fillMaxSize()
            ){
                Column (
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .rotate(-90f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ){
                   Text(
                       text = "Shopping Coupon",
                       style = TextStyle(
                           fontSize = 6.sp,
                           letterSpacing = TextUnit(3f, type = TextUnitType.Sp)
                       ),
                       textAlign = TextAlign.Center
                   )
                   Text(
                       text = "30%",
                       style = MaterialTheme.typography.displaySmall,
                       fontWeight = FontWeight.Bold,
                       textAlign = TextAlign.Center
                   )
                }
                Column(
                    modifier = Modifier.fillMaxHeight().weight(1.3f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                   Text(
                       text = "Pakistan Zindabad",
                       style = TextStyle(
                           fontSize = 6.sp,
                           letterSpacing = TextUnit(3f, TextUnitType.Sp),
                           textAlign = TextAlign.Center,
                           color = Color.White
                       ),
                   )
                   Text(
                       text = "Coupon",
                       modifier = Modifier.padding(5.dp),
                       style = MaterialTheme.typography.titleLarge,
                       fontWeight = FontWeight.Bold,
                       textAlign = TextAlign.Center,
                       color = Color.White
                   )
                   Text(
                       text = "VALID TILL OCTUBOR 2025",
                       style = TextStyle(
                           color = Color.White,
                           fontSize = 5.sp,
                           letterSpacing = TextUnit(1f, TextUnitType.Sp)
                       )
                   )
                }
            }
        }
    }
}
