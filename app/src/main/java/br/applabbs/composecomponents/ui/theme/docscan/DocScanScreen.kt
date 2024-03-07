package br.applabbs.composecomponents.ui.theme.docscan

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.getString
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.Green30
import br.applabbs.composecomponents.ui.theme.home.Routes
import coil.compose.rememberAsyncImagePainter
import com.google.mlkit.vision.documentscanner.GmsDocumentScannerOptions
import com.google.mlkit.vision.documentscanner.GmsDocumentScanning
import com.google.mlkit.vision.documentscanner.GmsDocumentScanningResult
import kotlinx.coroutines.launch
import java.net.URI

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DocScanScreen(navHostController: NavHostController){

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val modes = listOf(
        stringResource(R.string.full),
        stringResource(R.string.base), stringResource(R.string.base_with_filter)
    )
    val snackbarHostState = remember { SnackbarHostState() }
    val enableGalleryImport by remember { mutableStateOf(true) }
    val pageLimit by remember { mutableIntStateOf(1) }
    val scannerMode by remember { mutableIntStateOf(GmsDocumentScannerOptions.SCANNER_MODE_FULL) }
    var imageUriGlobal by remember { mutableStateOf("")}

    val scannerLauncher = rememberLauncherForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val gmsResult = GmsDocumentScanningResult.fromActivityResultIntent(result.data) // get the result
                gmsResult?.pages?.let { pages ->
                    pages.forEach { page ->
                        val imageUri = page.imageUri // do something with the image
                        imageUriGlobal = imageUri.toString()
                    }
                }
                gmsResult?.pdf?.let { pdf ->
                    val pdfUri = pdf.uri // do something with the PDF
                }
            }
        }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Document Scanner with ML Kit",
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
                actions = {

                },
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
            ExtendedFloatingActionButton(
                modifier = Modifier
                    .padding(10.dp),
                onClick = {
                    val scannerOptions = GmsDocumentScannerOptions.Builder()
                        .setGalleryImportAllowed(enableGalleryImport)
                        .setPageLimit(pageLimit)
                        .setResultFormats(
                            GmsDocumentScannerOptions.RESULT_FORMAT_JPEG,
                            GmsDocumentScannerOptions.RESULT_FORMAT_PDF
                        )
                        .setScannerMode(scannerMode)
                        .build()
                    val scanner = GmsDocumentScanning.getClient(scannerOptions)
                    scanner.getStartScanIntent(context as Activity)
                        .addOnSuccessListener { intentSender ->
                            scannerLauncher.launch(
                                IntentSenderRequest.Builder(intentSender).build()
                            )
                        }.addOnFailureListener {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    it.localizedMessage
                                        ?: "error message"
                                )
                            }
                        }
                },
                icon = {
                    Icon(Icons.Filled.Close, "Stop Blink")
                },
                text = { Text(text = "Start Scan") },
                containerColor = Green30,
                contentColor = Color.White
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                painter = rememberAsyncImagePainter(
                    model = imageUriGlobal,
                    placeholder = painterResource(id = R.drawable.ic_loading)

                ),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDocScan(){
    DocScanScreen(navHostController = rememberNavController())
}