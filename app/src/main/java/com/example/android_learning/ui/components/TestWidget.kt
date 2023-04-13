import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_learning.ui.theme.Android_learningTheme

@Composable
fun TestWidget(
    title: String,
    score: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Text(text = title, fontSize = 24.sp)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Row {
//                    Icon(painter =, contentDescription = "time icon")
                    Text("На время", fontSize = 18.sp)
                }
                Row {
//                    Icon(painter =, contentDescription = "test result")
                    Text("Не пройден", fontSize = 18.sp)
                }
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Начать")
            }
        }
        repeat(score) {
//            Icon(painter =, contentDescription = "score star")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultTestWidget() {
    Android_learningTheme {
        TestWidget("Тест на сообразительность", 4)
    }
}