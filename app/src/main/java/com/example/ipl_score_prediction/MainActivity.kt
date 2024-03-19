package com.example.ipl_score_prediction

import MainScreenthird
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipl_score_prediction.DataManger.fii
import com.example.ipl_score_prediction.DataManger.firstinings
import com.example.ipl_score_prediction.DataManger.list
import com.example.ipl_score_prediction.DataManger.secondinings
import com.example.ipl_score_prediction.ui.theme.IPL_Score_PredictionTheme
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.channels.FileChannel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPL_Score_PredictionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Nav()
                }
            }
        }

    }
}

@Composable
fun App(onclick : ()->Unit ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DropDownMenu()
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "VS",
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(50.dp))
        DropDownMenu2()
        Spacer(modifier = Modifier.height(90.dp))
        Button(onClick = { onclick()} ,
            modifier = Modifier
                .height(45.dp)
                .width(110.dp)
        ) {
            Text(text = "Next" ,
                fontSize = 17.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
//        Text("The value is box 1 : " + fii.value +" , box 2 : "+ DataManger.sii.value)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DropDownMenu() {
    var isexpanded by remember {
        mutableStateOf(false)
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                keyboardController?.hide()
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            ExposedDropdownMenuBox(
                expanded = isexpanded,
                onExpandedChange = { isexpanded = !isexpanded },
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    value = DataManger.firstinings.value,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isexpanded) }
                    ,colors = TextFieldDefaults.colors(
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ) ,
                    shape = RoundedCornerShape(22.dp),

                    )
                ExposedDropdownMenu(
                    expanded = isexpanded,
                    onDismissRequest = { isexpanded = false }) {
                    list.forEachIndexed { index, string ->
                        DropdownMenuItem(
                            text = { Text(text = string) }, onClick = {
                                fii.value = index
                                firstinings.value = list[index]
                                isexpanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DropDownMenu2() {

    var isexpanded by remember {
        mutableStateOf(false)
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                keyboardController?.hide()
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ExposedDropdownMenuBox(
                expanded = isexpanded,
                onExpandedChange = { isexpanded = !isexpanded }
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    value = DataManger.secondinings.value,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isexpanded) },
                    colors = TextFieldDefaults.colors(
                        disabledTextColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(22.dp),
                    )
                ExposedDropdownMenu(
                    expanded = isexpanded,
                    onDismissRequest = { isexpanded = false }) {
                    list.forEachIndexed { index, string ->
                        DropdownMenuItem(
                            text = { Text(text = string) }, onClick = {
                                DataManger.sii.value = index
                                secondinings.value = list[index]
                                isexpanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun IPLScorePredictionScreen(context: Context) {
    val model = loadModel(context, "IPL.tflite")
    MainScreenthird(model = model)
}

fun loadModel(context: Context, modelFileName: String): Interpreter {
    val assetManager = context.assets
    val modelFileDescriptor = assetManager.openFd(modelFileName)
    val inputStream = FileInputStream(modelFileDescriptor.fileDescriptor)
    val fileChannel = inputStream.channel
    val startOffset = modelFileDescriptor.startOffset
    val declaredLength = modelFileDescriptor.declaredLength
    val mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    return Interpreter(mappedByteBuffer)
}
