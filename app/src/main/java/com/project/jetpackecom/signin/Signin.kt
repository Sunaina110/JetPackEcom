package com.project.jetpackecom.signin

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.jetpackecom.base.RepeatedFunctions
import com.project.jetpackecom.base.Routes
import com.project.jetpackecom.mainbuttons.ButtonsUtils
import com.project.jetpackecom.ui.theme.Gray
import com.project.jetpackecom.ui.theme.Transparent
import com.project.jetpackecom.ui.theme.White

@Composable
fun Signin(navigation: NavController) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        RepeatedFunctions.TextHeading(text = "Sign in", modifier = Modifier.padding(start = 20.dp, top = 120.dp))
        var email by remember { mutableStateOf("") }
        RepeatedFunctions.TextFieldContainer(
            placeholder = "Email Address",
            text = email,
            onTextChange = {
                email = it
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = true,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        var password by remember { mutableStateOf("") }
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
        RepeatedFunctions.ButtonContainer(
            "Continue",
            onClick = { navigation.navigate(Routes.BASIC_PROFILE) },
            modifier = Modifier
                .padding(20.dp, 10.dp, 20.dp, 0.dp)
                .fillMaxWidth()
        )
        RepeatedFunctions.TextSpannableContainer(
            "Dont have an Account?",
            " Create One",
            modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 40.dp),
            onClick = {
                navigation.navigate(Routes.SIGN_UP)
            },
        )
        ButtonsUtils.MultipleButtonIconText()
//        Spinner()

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Spinner() {
    var expanded by remember { mutableStateOf(false) }
    val list = listOf("Between 1-20", "Between 21-30", "Between 31-40", "Above 40")
    var selectedItem by remember { mutableStateOf(list[0]) }
    val context = LocalContext.current

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        Column { // Wrap everything in a column
            TextField(
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                shape = RoundedCornerShape(40.dp),
                label = { Text(text = "Age Range") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    containerColor = Gray,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    disabledIndicatorColor = Transparent
                )
            )
            if (expanded) {
                // Show the dropdown menu only when expanded is true
                Box(
                    modifier = Modifier
                        .background(White)
                        .padding(vertical = 4.dp)
                ) {
                    Column {
                        list.forEach { selectedOption ->
                            DropdownMenuItem(
                                onClick = {
                                    selectedItem = selectedOption
                                    expanded = false
                                    Toast.makeText(context, "selected item is $selectedItem", Toast.LENGTH_SHORT).show()
                                }, text = { Text(text = selectedOption) }
                            )
                        }
                    }
                }
            }
        }
    }
}

