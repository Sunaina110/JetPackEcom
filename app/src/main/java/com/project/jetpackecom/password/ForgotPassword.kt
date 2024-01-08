package com.project.jetpackecom.password

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.jetpackecom.R
import com.project.jetpackecom.base.RepeatedFunctions
import com.project.jetpackecom.base.Routes

@Composable
fun ForgotPassword(navigation: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        RepeatedFunctions.BackImage(
            image = R.drawable.ic_back,
            modifier = Modifier
                .padding(start = 20.dp, top = 50.dp, bottom = 5.dp)
                .clickable { navigation.popBackStack() }
        )
        RepeatedFunctions.TextHeading(
            text = "Forgot Password",
            modifier = Modifier.padding(start = 20.dp, bottom = 10.dp)
        )
        var email by remember { mutableStateOf("") }
        RepeatedFunctions.TextFieldContainer(
            placeholder = "Enter Email address",
            text = email,
            onTextChange = { eMail -> email = eMail },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        RepeatedFunctions.ButtonContainer(
            text = "Continue",
            onClick = { navigation.navigate(Routes.EMAIL_CONFIRMATION) },
            modifier = Modifier
                .padding(20.dp, 10.dp, 20.dp, 0.dp)
                .fillMaxWidth()
        )
    }
}