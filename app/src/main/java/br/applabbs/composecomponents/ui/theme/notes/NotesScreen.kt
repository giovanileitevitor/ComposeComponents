package br.applabbs.composecomponents.ui.theme.notes

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.home.Routes
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotepadScreen(navHostController: NavHostController){

    val context = LocalContext.current
    var anotacao by remember { mutableStateOf("") }
    val storeNotes = StoreNotes(context = context)
    val scope = rememberCoroutineScope()
    val notesSaved = storeNotes.getNote.collectAsState(initial = "")
    val notesSaved2 = scope.launch {

    }

    anotacao = notesSaved.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.bloco_notas),
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
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        storeNotes.saveNote(note = anotacao)
                        Toast.makeText(context, "Note saved with success !!", Toast.LENGTH_SHORT).show()
                    }
                },
                containerColor = Green30,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_salvar),
                    contentDescription = "icone"
                )
            }
        },
        modifier = Modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            TextField(
                value = anotacao,
                onValueChange = {
                    anotacao = it
                },
                label = {
                    Text(
                        text = "Digite a sua anotação..."
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                textStyle = TextStyle(
                    fontSize = 28.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    cursorColor = Green30,
                    focusedLabelColor = Green30
                )
            )
        }
    }

}

@Preview
@Composable
fun PreviewNotepad(){
    NotepadScreen(navHostController = rememberNavController())
}