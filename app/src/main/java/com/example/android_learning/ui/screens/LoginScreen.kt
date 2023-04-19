package com.example.android_learning.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.android_learning.R
import com.example.android_learning.ui.components.Input
import com.example.android_learning.ui.components.InputPassword
import com.example.android_learning.ui.theme.Android_learningTheme
import com.example.android_learning.viewmodels.LoginScreenViewModel

@Composable
fun LoginScreen(
    viewModel: LoginScreenViewModel = hiltViewModel(),
    navigate: (() -> Unit)?
) {
    var loginValue by remember {
        mutableStateOf("")
    }
    var passwordValue by remember {
        mutableStateOf("")
    }

    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    val login = {
        when (loginValue == "" || passwordValue == "") {
            true -> Toast.makeText(context, "Введите логин и пароль", Toast.LENGTH_LONG).show()
            false -> viewModel.login(
                loginValue,
                passwordValue,
                { navigate?.invoke() },
                { Toast.makeText(context, it, Toast.LENGTH_LONG).show() }
            )
        }
    }

    val handleLoginButtonClick = {
        login()
    }

    val handleDoneAction = {
        focusManager.clearFocus()
        login()
    }

    Column(
        modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            "Login",
            fontSize = 48.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(24.dp))
        Input(
            label = R.string.input_login_label,
            value = loginValue,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            onValueChange = { loginValue = it }
        )
        InputPassword(
            label = R.string.input_password_label,
            value = passwordValue,
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) },
                onDone = { handleDoneAction() }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            onValueChange = { passwordValue = it }
        )
        Button(
            onClick = handleLoginButtonClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
        ) {
            Text(
                stringResource(R.string.login_button_text),
                fontSize = 18.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultLoginScreen() {
    Android_learningTheme {
        LoginScreen {}
    }
}