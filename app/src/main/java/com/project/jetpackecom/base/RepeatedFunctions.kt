package com.project.jetpackecom.base

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.jetpackecom.ui.theme.Black
import com.project.jetpackecom.ui.theme.Gray
import com.project.jetpackecom.ui.theme.Purple
import com.project.jetpackecom.ui.theme.Transparent

object RepeatedFunctions {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextFieldContainer(
        placeholder: String,
        text: String,
        onTextChange: (String) -> Unit,
        singleLine: Boolean,
        keyboardOptions: KeyboardOptions = KeyboardOptions(
            KeyboardCapitalization.None,
            true,
            KeyboardType.Text,
            ImeAction.Default
        ),
    ) {
        TextField(
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = { Text(placeholder) },
            modifier = Modifier
                .padding(20.dp, 10.dp, 20.dp, 0.dp)
                .fillMaxWidth()
                .height(56.dp),
            singleLine = singleLine,
            keyboardOptions = keyboardOptions, /*KeyboardOptions(KeyboardCapitalization.None, true, KeyboardType.Text, ImeAction.Next),*/

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Gray,
                focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                disabledIndicatorColor = Transparent
            ),
//            textStyle = TextStyle.Default.copy(fontSize = 15.sp)
        )
    }

    @Composable
    fun ButtonContainer(text: String, onClick: () -> Unit, modifier: Modifier) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple
            ), modifier = modifier
//                .padding(20.dp, 10.dp, 20.dp, 0.dp)
//                .fillMaxWidth()
        ) {
            Text(text = text, fontSize = 15.sp)
        }
    }

    @Composable
    fun ButtonWrapContainer(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        bgColor: Color,
        textColor: Color,
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = bgColor,
                contentColor = textColor
            ), modifier = modifier
        ) {
            Text(text = text, fontSize = 15.sp)
        }
    }

    @Composable
    fun TextSpannableContainer(
        firstString: String,
        secondString: String,
        modifier: Modifier,
        onClick: () -> Unit,
    ) {
        val annotatedString = buildAnnotatedString {
            append(firstString)
            withStyle(style = SpanStyle(color = Black, fontWeight = FontWeight.Bold)) {
                pushStringAnnotation(tag = secondString, annotation = secondString)
                append(secondString)
            }
        }
        ClickableText(text = annotatedString, modifier = modifier) {
            annotatedString.getStringAnnotations(it, it).firstOrNull()?.tag.let {
                onClick()
            }
        }
    }

    @Composable
    fun BackImage(image: Int, modifier: Modifier) {
        Image(painter = painterResource(id = image), contentDescription = null, modifier = modifier)
    }

    @Composable
    fun ImageContainer(image: Int, modifier: Modifier, contentScale: ContentScale) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = modifier,
            contentScale = contentScale
        )
    }

    @Composable
    fun TextHeading(text: String, modifier: Modifier) {
        Text(
            text = text,
            modifier = modifier,
            fontSize = 25.sp,
        )
    }

    @Composable
    fun TextSubHeading(text: String, modifier: Modifier) {
        Text(
            text = text,
            modifier = modifier,
            fontSize = 20.sp,
        )
    }

    @Composable
    fun TextMain(text: String, modifier: Modifier) {
        Text(
            text = text,
            modifier = modifier,
            fontSize = 16.sp,
        )
    }

    @Composable
    fun CircularImageContainer(image: Int, contentScale: ContentScale, modifier: Modifier) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = contentScale,
            modifier = modifier
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SpinnerContainer(
        list: List<String>,
        context: Context,
        selectedItem: String,
        label: String,
        onSelectedItemChange: (String) -> Unit,
        widthType: DropdownWidthType = DropdownWidthType.WrapContent
    ) {
        var expanded by remember { mutableStateOf(false) } // for drop down and up by default false

        ExposedDropdownMenuBox(
            expanded = expanded, onExpandedChange = { expanded = !expanded }, modifier = when (widthType) {
                DropdownWidthType.WrapContent -> Modifier.width(IntrinsicSize.Min)
                DropdownWidthType.MatchParent -> Modifier.width(IntrinsicSize.Max)
            }
        ) {
            TextField(
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                shape = RoundedCornerShape(40.dp),
                label = { Text(text = label) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    containerColor = Gray, focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    disabledIndicatorColor = Transparent
                ),
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                list.forEach { selectedOption ->
                    Log.i("TAG", "SpinnerContainer: $selectedOption")
                    DropdownMenuItem(
                        onClick = {
                            onSelectedItemChange(selectedOption)
                            expanded = false
                            Toast.makeText(context, "selected item is $selectedItem", Toast.LENGTH_SHORT).show()
                        }, text = { Text(text = selectedOption) }
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SearchBarContainer(label: String) {
        var text by remember { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { text = it },
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            label = { Text(text = label) },
            leadingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription ="Search Bar" )},
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                containerColor = Gray, focusedIndicatorColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                disabledIndicatorColor = Transparent
            )
        )

    }
}