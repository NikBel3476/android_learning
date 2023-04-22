package com.example.android_learning.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IconWithText(
    painter: Painter,
    iconDescription: String?,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            painter = painter,
            contentDescription = iconDescription,
            modifier = Modifier.size(32.dp)
        )
        Text(
            text,
            fontSize = 18.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}