package com.example.ipl_score_prediction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipl_score_prediction.ui.theme.ButtonC

@Composable
fun ThirdScreen(onclick : ()->Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        DataManger.lastFiveOverRuns.intValue = UserInput(m = Modifier, inputName = "Runs in last 5 overs : ")
        Spacer(modifier = Modifier.height(35.dp))
        DataManger.lastFiveOversWickets.intValue = UserInput(m = Modifier, inputName = "Wickets in last 5 overs : ")
        Spacer(modifier = Modifier.height(80.dp))
        Button(onClick = {onclick()} ,
            modifier = Modifier
                .height(45.dp)
                .width(110.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonC
            )
        ) {
            Text(text = "Predict" ,
                fontSize = 17.sp,
                )
        }
    }

}