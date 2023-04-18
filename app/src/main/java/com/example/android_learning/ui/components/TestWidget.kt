import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_learning.R
import com.example.android_learning.ui.components.RatingBar
import com.example.android_learning.ui.theme.Android_learningTheme

@Composable
fun TestWidget(
    title: String,
    rating: Int,
    modifier: Modifier = Modifier
) {
    val maxRating = 5

    Column(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Text(text = title, fontSize = 24.sp)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.schedule_outlined),
                        contentDescription = "time icon",
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        stringResource(R.string.test_type),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = when (rating > 2) {
                            true -> painterResource(R.drawable.thumb_up_filled)
                            false -> painterResource(R.drawable.thumb_down_filled)
                        },
                        contentDescription = "test result",
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        stringResource(R.string.test_failed),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
            Button(onClick = { /*TODO*/ }) {
                Text(stringResource(R.string.start_test_button_text), fontSize = 20.sp)
            }
        }
        RatingBar(rating = rating, maxRating = maxRating)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultTestWidget() {
    Android_learningTheme {
        TestWidget("Тест на сообразительность", 4)
    }
}