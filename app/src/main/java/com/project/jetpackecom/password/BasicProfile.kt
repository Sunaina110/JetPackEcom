package com.project.jetpackecom.password

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.jetpackecom.base.DropdownWidthType
import com.project.jetpackecom.base.RepeatedFunctions
import com.project.jetpackecom.base.Routes
import com.project.jetpackecom.ui.theme.Black
import com.project.jetpackecom.ui.theme.Gray
import com.project.jetpackecom.ui.theme.Purple
import com.project.jetpackecom.ui.theme.Transparent
import com.project.jetpackecom.ui.theme.White

@Composable
fun BasicProfile(navigation: NavController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f, false)
        ) {
            RepeatedFunctions.TextSubHeading(
                text = "Tell us About yourself",
                modifier = Modifier.padding(start = 20.dp, top = 80.dp, bottom = 30.dp),
            )
            RepeatedFunctions.TextMain(
                text = "Who do you shop for ?",
                modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RepeatedFunctions.ButtonWrapContainer(
                    text = "Men",
                    onClick = {},
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(end = 10.dp),
                    bgColor = Purple,
                    textColor = White
                )
                RepeatedFunctions.ButtonWrapContainer(
                    text = "Women",
                    onClick = {},
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 10.dp),
                    bgColor = Gray,
                    textColor = Black
                )
            }
            RepeatedFunctions.TextMain(
                text = "How Old are you ?",
                modifier = Modifier.padding(start = 20.dp, top = 40.dp, bottom = 20.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
//                SpinnerContainer()
                val newList = listOf("Between 1-20", "Between 21-30", "Between 31-40", "Above 40")
                var selectedItem by remember { mutableStateOf(newList[0]) }
                val context = LocalContext.current


                RepeatedFunctions.SpinnerContainer(
                    list = newList,
                    context = context,
                    selectedItem = selectedItem,
                    label = "Age Range",
                    onSelectedItemChange = { selectedItem = it },
                    widthType = DropdownWidthType.MatchParent
                )

            }
        }
        RepeatedFunctions.ButtonContainer(
            text = "Finish", onClick = { navigation.navigate(Routes.HOME_SCREEN) }, modifier = Modifier
                .padding(start = 20.dp, bottom = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpinnerContainer() {
    var expanded by remember { mutableStateOf(false) } // for drop down and up by default false
    val list = listOf("Between 1-20", "Between 21-30", "Between 31-40", "Above 40")
    var selectedItem by remember { mutableStateOf(list[0]) }
    val context = LocalContext.current

    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
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
                containerColor = Gray, focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                disabledIndicatorColor = Transparent
            )
        )
        /*   DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Log.i("TAG", "SpinnerContainer: $expanded")
            list.forEach { selectedOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedItem = selectedOption
                        expanded = false
                        Toast.makeText(context, "selected item is $selectedItem", Toast.LENGTH_SHORT).show()
                    }, text = { Text(text = selectedOption) }
                )
            }
        }*/
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            list.forEach { selectedOption ->
                Log.i("TAG", "SpinnerContainer: $selectedOption")
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




