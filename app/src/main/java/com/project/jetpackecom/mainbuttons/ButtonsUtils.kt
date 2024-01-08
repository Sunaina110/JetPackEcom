package com.project.jetpackecom.mainbuttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.jetpackecom.R
import com.project.jetpackecom.ui.theme.Black
import com.project.jetpackecom.ui.theme.Gray
import com.project.jetpackecom.ui.theme.Purple

object ButtonsUtils {
    @Composable
    fun ButtonWithIconText(text: String, image: Painter, onClick: () -> Unit) {
        Button(
            onClick = onClick, colors = ButtonDefaults.buttonColors(containerColor = Gray),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                Image(
                    modifier = Modifier.padding(end = 3.dp).size(20.dp),
                    painter = image,
                    contentDescription = null,
                )
                Text(
                    text = text,
                    fontSize = 14.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = Black,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }

    @Composable
    fun MultipleButtonIconText() {
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image1: Painter = painterResource(id = R.drawable.ic_apple)
            val image2: Painter = painterResource(id = R.drawable.ic_google)
            val image3: Painter = painterResource(id = R.drawable.ic_facebook)
            ButtonWithIconText(text = "Continue With Apple", image = image1, onClick = { })
            ButtonWithIconText(text = "Continue With Google", image = image2, onClick = { })
            ButtonWithIconText(text = "Continue With Facebook", image = image3, onClick = { })
        }
    }
}