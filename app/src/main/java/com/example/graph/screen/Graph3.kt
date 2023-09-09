package com.example.graph.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.graph.ui.theme.GraphTheme

@Composable
fun Graph3() {
    Graph3Bar()
}

@Composable
fun Graph3Bar() {
    val barDataList = listOf(10,5,8,4,7,6,1,7,3)
    BarChart(barDataList)
}

@Composable
fun BarChart(barDataList: List<Int>) {
    val maxValue = barDataList.max()

    Box(
        modifier = Modifier.fillMaxWidth().padding(top = 150.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            barDataList.forEach { barData ->
                Bar(barData, maxValue)
            }
        }
    }
}

@Composable
fun Bar(barData: Int, maxValue: Int) {
    val height = (barData.toFloat() / maxValue.toFloat()) * 300

    Box(
        modifier = Modifier
            .height(height.dp)
            .width(30.dp)
            .background(Color.Black),
        contentAlignment = Alignment.BottomCenter
    ) {
        Text(
            text = barData.toString(),
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Graph3Preview() {
    GraphTheme {
        Graph3()
    }
}