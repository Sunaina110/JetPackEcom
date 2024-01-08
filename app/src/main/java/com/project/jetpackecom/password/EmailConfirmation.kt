package com.project.jetpackecom.password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.jetpackecom.R
import com.project.jetpackecom.base.RepeatedFunctions
import com.project.jetpackecom.base.Routes
import com.project.jetpackecom.ui.theme.Purple
import com.project.jetpackecom.ui.theme.White


@Composable
fun EmailConfirmation(navigation: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RepeatedFunctions.ImageContainer(
            image = R.drawable.ic_email_confirm,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "We Sent you an Email to reset your password.",
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
            fontSize = 20.sp, textAlign = TextAlign.Center,
        )
        RepeatedFunctions.ButtonWrapContainer(
            text = "Return to Login",
            onClick = { navigation.navigate(Routes.SIGN_IN) },
            modifier = Modifier,
            bgColor = Purple,
            textColor = White)
    }
}