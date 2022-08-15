package com.example.bottomsheetjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomsheetjc.ui.theme.BottomSheetJCTheme
import com.example.bottomsheetjc.ui.theme.Shapes
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomSheetJCTheme {

                val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
                val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)
                val scope = rememberCoroutineScope()

                BottomSheetScaffold(
                    scaffoldState = scaffoldState,
                    sheetContent = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "Bottom Sheet",
                                fontSize = 40.sp
                            )
                        }
                },
                    sheetBackgroundColor = Color.Blue,
                    sheetPeekHeight = 0.dp,
                    sheetShape = Shapes.large
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Button(onClick = {
                            scope.launch {
                                if (sheetState.isCollapsed){
                                    sheetState.expand()
                                }else{
                                    sheetState.collapse()
                                }
                            }
                        }) {
                            Text(text = "Click to see Bottom Sheet")
                        }
                    }
                }
            }
        }
    }
}