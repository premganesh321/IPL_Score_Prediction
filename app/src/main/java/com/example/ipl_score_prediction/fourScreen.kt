
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ipl_score_prediction.DataManger
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

@Composable
fun ModelOutputTextView(outputData: FloatArray) {
    Text(
        text = "Output: ${outputData.joinToString()}",
    )
}

@Composable
fun MainScreenthird(model: Interpreter) {
    var outputData by remember { mutableStateOf(FloatArray(0)) }

    DisposableEffect(Unit) {
        onDispose {
            model.close()
        }
    }

    val inputData by remember(model) {
        mutableStateOf(
            prepareInputData(
                model = model,
                currentRuns = DataManger.currentRuns.value,
                currentWickets = DataManger.currentWickets.value,
                currentOver = DataManger.currentOver.value,
                lastFiveOverRuns = DataManger.lastFiveOverRuns.value,
                lastFiveOversWickets = DataManger.lastFiveOversWickets.value,
                firstInningsIndex = DataManger.fii.value,
                secondInningsIndex = DataManger.sii.value
            )
        )
    }

    LaunchedEffect(inputData) {
        outputData = getOutputData(model, inputData)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ModelOutputTextView(outputData = outputData)
    }
}

fun prepareInputData(
    model: Interpreter,
    currentRuns: Int,
    currentWickets: Int,
    currentOver: Int,
    lastFiveOverRuns: Int,
    lastFiveOversWickets: Int,
    firstInningsIndex: Int,
    secondInningsIndex: Int

): TensorBuffer {
    val inputShape = model.getInputTensor(0).shape()
    val inputBuffer = TensorBuffer.createFixedSize(inputShape, model.getInputTensor(0).dataType())

    inputBuffer.loadArray(
        intArrayOf(
            currentRuns,
            currentWickets,
            currentOver,
            lastFiveOverRuns,
            lastFiveOversWickets,
            firstInningsIndex,
            secondInningsIndex
        )
    )

    return inputBuffer
}

fun getOutputData(model: Interpreter, inputData: TensorBuffer): FloatArray {
    val outputShape = model.getOutputTensor(0).shape()
    val outputBuffer = TensorBuffer.createFixedSize(outputShape, model.getOutputTensor(0).dataType())

    model.run(inputData.buffer, outputBuffer.buffer)

    return outputBuffer.floatArray
}

