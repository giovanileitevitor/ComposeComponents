package br.applabbs.composecomponents.ui.theme.bottomMenu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.ui.theme.AquaBlue
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.Green90

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomMenuScreen(navHostController : NavHostController){

    val itensMenu = itens

    Scaffold(
        bottomBar = {
            BottomMenu(
                itensMenu = itensMenu,
                modifier = Modifier
            )
        }
    ) { paddingValues ->

    }
}

@Composable
fun BottomMenu(
    itensMenu: List<ItemBottomMenu>,
    modifier: Modifier,
    activeHighlightColor: Color = Green90,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItem: Int = 0
){

    var selectedItemIndex by remember { mutableIntStateOf(initialSelectedItem) }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Green30)
            .padding(top = 6.dp, bottom = 6.dp)
    ){

        itensMenu.forEachIndexed { index, itemBottomMenu ->
            BottomMenuItem(
                item = itemBottomMenu,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ){
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: ItemBottomMenu,
    isSelected: Boolean = false,
    activeHighlightColor: Color = Green90,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.itemIcon),
                contentDescription = item.itemTitle,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.itemTitle,
            fontSize = 10.sp,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Preview
@Composable
fun PreviewBottomMenu(){
    BottomMenuScreen(navHostController = rememberNavController())
}