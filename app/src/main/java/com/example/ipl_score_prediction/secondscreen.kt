package com.example.ipl_score_prediction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SecondScreen(onclick : ()->Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        DataManger.currentOver.intValue = UserInput(m = Modifier, inputName = "Current Over :")
        Spacer(modifier = Modifier.height(35.dp))
        DataManger.currentRuns.intValue = UserInput(m = Modifier, inputName = "Runs :")
        Spacer(modifier = Modifier.height(35.dp))
        DataManger.currentWickets.intValue = UserInput(m = Modifier, inputName = "Wickets : ")
        Spacer(modifier = Modifier.height(80.dp))
        Button(onClick = {onclick()} ,
            modifier = Modifier.height(45.dp).width(110.dp)
        ) {
            Text(text = "Next" ,
                fontSize = 17.sp
            )
        }
    }

}

@Composable
fun UserInput(m: Modifier, inputName: String) : Int {
    var cR = remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = inputName,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 15.dp, bottom = 13.dp),
            fontSize = 16.sp
        )
        TextField(
            value = cR.value,
            onValueChange = { newValue ->
                cR.value = newValue
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            shape = RoundedCornerShape(22.dp),
            colors = TextFieldDefaults.colors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            )

    }
    return cR.value.toIntOrNull() ?: 0
}


