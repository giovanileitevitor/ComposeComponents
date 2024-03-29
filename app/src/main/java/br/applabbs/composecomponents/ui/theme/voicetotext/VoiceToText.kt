package br.applabbs.composecomponents.ui.theme.voicetotext

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.applabbs.composecomponents.R
import br.applabbs.composecomponents.ui.theme.ComposeComponentsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun VoiceToTextScreen(
    navHostController: NavHostController
) {

    //val viewModel = koinViewModel<VoiceViewModel>()
    //val randomName by viewModel.randomName.observeAsState()
    val buttonName by remember { mutableStateOf("START")}
    val context = LocalContext.current
    var permission by remember {
        mutableStateOf(ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
    ) { granted ->
        permission = granted
    }

    val viewModel = viewModel {
        val app = get(APPLICATION_KEY)!!
        val stt = RealSpeechToText(app.applicationContext)
        VoiceViewModel(stt)
    }

    var pressed by remember { mutableStateOf(false) }
    val buttonScale by animateFloatAsState(
        targetValue = if (pressed) 0.8f else 1f,
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
            dampingRatio = Spring.DampingRatioMediumBouncy,
            visibilityThreshold = 0.001f
        ),
        label = "Button Scale"
    )

    ComposeComponentsTheme {
        if (permission) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .windowInsetsPadding(insets = WindowInsets.navigationBars)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = viewModel.state.display,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        fontSize = 24.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .scale(buttonScale)
                            .size(80.dp)
                            .background(
                                color = Color.Gray,
                                shape = CircleShape
                            )
                            .clip(CircleShape)
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = {
                                        pressed = true
                                        viewModel.send(AppAction.StartRecord)
                                        awaitRelease()
                                        pressed = false
                                        viewModel.send(AppAction.EndRecord)
                                    }
                                )
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(30.dp),
                            painter = painterResource(id = R.drawable.ic_microfone),
                            tint = MaterialTheme.colorScheme.onBackground,
                            contentDescription = "Record"
                        )
                    }
                }
            }
        } else {
            launcher.launch(Manifest.permission.RECORD_AUDIO)
        }
    }
}

@Preview
@Composable
private fun PreviewVoiceToText(){
    VoiceToTextScreen(navHostController = rememberNavController())
}