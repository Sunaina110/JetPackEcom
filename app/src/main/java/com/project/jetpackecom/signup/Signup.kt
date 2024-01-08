package com.project.jetpackecom.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.jetpackecom.R
import com.project.jetpackecom.base.RepeatedFunctions
import com.project.jetpackecom.base.Routes


@Composable
fun Signup(navigation: NavController) {
//    Contents()
    Column(modifier = Modifier.fillMaxSize()) {
        RepeatedFunctions.BackImage(
            image = R.drawable.ic_back,
            modifier = Modifier
                .padding(start = 20.dp, top = 50.dp, bottom = 5.dp)
                .clickable { navigation.popBackStack() })
        RepeatedFunctions.TextHeading(
            text = "Create Account",
            modifier = Modifier.padding(start = 20.dp, bottom = 30.dp)
        )

        var firstName by remember { mutableStateOf("") }
        var lastName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        RepeatedFunctions.TextFieldContainer(
            placeholder = "Firstname",
            text = firstName,
            onTextChange = { fName -> firstName = fName },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        RepeatedFunctions.TextFieldContainer(
            placeholder = "Lastname",
            text = lastName,
            onTextChange = { lName -> lastName = lName },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        RepeatedFunctions.TextFieldContainer(
            placeholder = "Email Address",
            text = email,
            onTextChange = { eMail -> email = eMail },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        RepeatedFunctions.TextFieldContainer(
            placeholder = "Password",
            text = password,
            onTextChange = { passWord -> password = passWord },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        RepeatedFunctions.ButtonContainer(
            text = "Continue",
            onClick = { navigation.navigate(Routes.SIGN_IN) },
            modifier = Modifier
                .padding(20.dp, 10.dp, 20.dp, 0.dp)
                .fillMaxWidth()
        )
        RepeatedFunctions.TextSpannableContainer(
            firstString = "Forgot Password?",
            secondString = " Reset",
            modifier = Modifier.padding(start = 20.dp, top = 10.dp),
            onClick = {
                navigation.navigate(Routes.FORGOT_PASSWORD)
            }
        )
    }
}
