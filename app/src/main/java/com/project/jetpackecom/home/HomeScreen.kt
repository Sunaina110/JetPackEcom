package com.project.jetpackecom.home

import android.widget.FrameLayout
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.jetpackecom.R
import com.project.jetpackecom.base.DropdownWidthType
import com.project.jetpackecom.base.RepeatedFunctions
import com.project.jetpackecom.ui.theme.Black

@Composable
fun HomeScreen(navigation: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RepeatedFunctions.CircularImageContainer(
                image = R.drawable.ic_user,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(start = 20.dp, top = 40.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.dp, color = Black, shape = CircleShape)
            )
            val newList = listOf("Men", "Women", "Other")
            var selectedItem by remember { mutableStateOf(newList[0]) }
            val context = LocalContext.current
            RepeatedFunctions.SpinnerContainer(
                list = newList,
                context = context,
                selectedItem = selectedItem,
                label = "",
                onSelectedItemChange = { selectedItem = it },
                widthType = DropdownWidthType.WrapContent
            )
            RepeatedFunctions.CircularImageContainer(
                image = R.drawable.ic_gift,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(start = 20.dp, top = 40.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.dp, color = Black, shape = CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        RepeatedFunctions.SearchBarContainer(label = "Search")

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationContainer(){
    val bottomItems:List<String> = listOf("Home","Notification","Order","Profile")
    val selectedItem by remember { mutableStateOf(bottomItems.first()) }
}
