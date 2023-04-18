package com.example.android_learning.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android_learning.R

@Composable
fun RatingBar(rating: Int, maxRating: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        repeat(rating) {
            Icon(
                painter = painterResource(R.drawable.grade_filled),
                contentDescription = "score star",
                modifier = Modifier.size(24.dp)
            )
        }
        repeat(maxRating - rating) {
            Icon(
                painter = painterResource(R.drawable.grade_outlined),
                contentDescription = "score star",
                modifier = Modifier.size(24.dp)
            )
        }

    }
}