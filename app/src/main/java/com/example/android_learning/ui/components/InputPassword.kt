package com.example.android_learning.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_learning.R
import com.example.android_learning.ui.theme.Android_learningTheme

@Composable
fun InputPassword(
    @StringRes label: Int,
    value: String,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(label)) },
        singleLine = true,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        visualTransformation = when (isPasswordVisible) {
            true -> VisualTransformation.None
            false -> PasswordVisualTransformation()
        },
        trailingIcon = {
            val image = painterResource(
                when (isPasswordVisible) {
                    true -> R.drawable.visibility
                    false -> R.drawable.visibility_off
                }
            )

            val contentDescription = when (isPasswordVisible) {
                true -> "Hide password"
                false -> "Show password"
            }

            IconButton(
                onClick = { isPasswordVisible = !isPasswordVisible },
                modifier = Modifier.size(32.dp)
            ) {
                Icon(
                    painter = image, contentDescription
                )
            }
        },
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultInputPassword() {
    Android_learningTheme {

    }
}