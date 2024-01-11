package br.applabbs.composecomponents.ui.theme.instagramNews

import android.widget.Toast
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.Green90
import br.applabbs.composecomponents.ui.theme.home.MainViewModel
import br.applabbs.composecomponents.ui.theme.home.Routes
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramNewsScreen(navHostController: NavHostController){

    val cards = cards
    val cardsInternet = cardsInternet
    val context = LocalContext.current
    val viewModel = viewModel<InstagramViewModel>()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.instagram_cards),
                        textAlign = TextAlign.Justify,
                        fontSize = 22.sp,
                        maxLines = 1,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Green30,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navHostController.navigate(Routes.HOME)
                        }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Voltar",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    BadgedBox(
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 14.dp),
                        badge = {
                            Badge(
                                containerColor = Color.Transparent,
                                modifier = Modifier
                                    .offset(y = 12.dp, x = (-5).dp)
                                    .clickable {
                                        Toast
                                            .makeText(
                                                context,
                                                "Total cards: ${cardsInternet.size.toString()}",
                                                Toast.LENGTH_SHORT
                                            )
                                            .show()
                                    },
                            ){
                                Text(
                                    text = cardsInternet.size.toString(),
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    modifier = Modifier.semantics {
                                        contentDescription = "$cardsInternet.size.toString() new itens"
                                    }
                                )
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notifications",
                            tint = Color.White
                        )
                    }
                },
            )
        }
    ){ paddingValues ->

        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ){
            Column {
                ChipSection(
                    cards = cards,
                    cardsInternet = cardsInternet
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationGraphicsApi::class)
@Composable
private fun ChipSection(
    cards: List<InstagramCard>,
    cardsInternet: List<InstagramCardInternet>
){
    var showDialog by remember { mutableStateOf(false)}
    var selectedChipIndex by remember { mutableIntStateOf(0) }
    val context = LocalContext.current.applicationContext

    LazyRow {
        items(cardsInternet.size) {
            Column(
                modifier = Modifier.padding(0.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp, bottom = 5.dp, end = 10.dp)
                        .size(80.dp)
                        .combinedClickable(
                            onClick = {
                                selectedChipIndex = it
                                Toast
                                    .makeText(
                                        context,
                                        "City selected: " + "${cardsInternet[it].cardName}",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            },
                            onLongClick = {
                                selectedChipIndex = it
                                showDialog = true
                            }
                        )
                        .clip(CircleShape)
                        .border(
                            width = if (selectedChipIndex == it) 4.dp else 2.dp,
                            color = if (selectedChipIndex == it) Green90 else Color.Gray,
                            shape = CircleShape
                        )
                        .height(80.dp)
                        .width(80.dp)
                ) {
                    Image(
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier.fillMaxSize(),
                        painter = rememberAsyncImagePainter(
                            model = cardsInternet[it].cardImageUrl,
                            placeholder = painterResource(id = R.drawable.ic_loading)
                            ),
                        contentDescription = "image"
                    )
                }

                Text(
                    text = cardsInternet[it].cardName,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.width(80.dp)
                )
            }

        }
    }
}


@Preview
@Composable
fun PreviewButtons(){
    InstagramNewsScreen(navHostController = rememberNavController())
}