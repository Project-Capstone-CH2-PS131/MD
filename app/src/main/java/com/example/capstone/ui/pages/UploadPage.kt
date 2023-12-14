package com.example.capstone.ui.pages

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.rememberScaffoldState
import coil.compose.rememberImagePainter
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.compose.rememberNavController
import com.example.capstone.R
import com.example.capstone.ui.component.BottomBar
import com.example.capstone.ui.component.JetButton
import com.example.capstone.ui.component.JetTextField
import com.example.capstone.ui.component.JetTopBar
import com.example.capstone.ui.theme.BluePrimary
import com.example.capstone.ui.theme.CapstoneTheme
import com.example.capstone.ui.theme.CyanPrimary
import java.io.File
import java.util.Date
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadPage() {
    var description by remember { mutableStateOf("") }
    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider", file
    )

    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success) {
                capturedImageUri = uri
            } else {
                // Handle error or notify user if taking picture failed
                Toast.makeText(context, "Failed to take picture", Toast.LENGTH_SHORT).show()
            }
        }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    androidx.compose.material.Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { JetTopBar() },
        bottomBar = { BottomBar(navController = navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                backgroundColor = BluePrimary
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.fridge),
                    contentDescription = "scan",
                    modifier = Modifier.size(36.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        scaffoldState = scaffoldState
    ) { innerPadding ->
        Box(
            Modifier.fillMaxSize(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.background2profile),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
                    .padding(innerPadding)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.matchParentSize()
            ) {
                val painter: Painter = if (capturedImageUri.path?.isNotEmpty() == true) {
                    rememberImagePainter(capturedImageUri)
                } else {
                    painterResource(id = R.drawable.photoupload)
                }

                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 150.dp)
                        .size(width = 350.dp, height = 200.dp)
                )
                Text(
                    text = "UPLOAD IMAGE FRIDGE",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 15.dp)
                )
                JetTextField(
                    hint = "Description",
                    icon = Icons.Outlined.Add,
                    keyboardType = KeyboardType.Text,
//                    maxline = 10,
                    modifier = Modifier.padding(top = 15.dp),
                    value = { new -> description = new }
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    JetButton(
                        onClick = {
                            val permissionCheckResult =
                                ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)

                            if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                                cameraLauncher.launch(uri)
                            } else {
                                permissionLauncher.launch(Manifest.permission.CAMERA)
                            }
                        },
                        color = BluePrimary,
                        enabled = true,
                        label = "TAKE PICTURE",
                        modifier = Modifier.size(width = 200.dp, height = 50.dp)
                    )
                    JetButton(
                        onClick = { /*TODO*/ },
                        color = BluePrimary,
                        enabled = true,
                        label = "FILE",
                        modifier = Modifier.size(width = 200.dp, height = 50.dp)
                    )
                }
                JetButton(
                    onClick = { /*TODO*/ },
                    color = CyanPrimary,
                    enabled = true,
                    label = "UPLOAD",
                    modifier = Modifier.padding(top = 20.dp).size(width = 300.dp, height = 50.dp)
                )
            }
        }
    }
}

fun Context.createImageFile(): File {
    val timeStamp = java.text.SimpleDateFormat("yyyy_MM_dd_HH:mm:ss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    val image = File.createTempFile(
        imageFileName,
        ".jpg",
        externalCacheDir
    )
    return image
}

@Composable
@Preview(showBackground = true)
fun UploadPagePreview() {
    CapstoneTheme {
        UploadPage()
    }
}
