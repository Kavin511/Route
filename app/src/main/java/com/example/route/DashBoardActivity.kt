package com.example.route

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.route.ui.theme.RouteTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

class DashBoardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingPreview()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
fun GreetingPreview() {
    RouteTheme {
        val singapore = LatLng(1.35, 103.87)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(singapore, 10f)
        }

        Column {
            GoogleMap(
                modifier = Modifier
                    .fillMaxSize(), cameraPositionState = cameraPositionState
            ) {
//                Marker(
//                    state = MarkerState(position = singapore),
//                    title = "Singapore",
//                    snippet = "Marker in Singapore"
//                )
            }
            val modalSheetState = rememberModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden,
                confirmStateChange = { true },
                skipHalfExpanded = false,
            )
            ModalBottomSheetLayout(
                sheetState = modalSheetState,
                modifier = Modifier.fillMaxSize(),
                sheetContent = {
                    Column {
                        RouteItems()
                        RouteItems()
                        RouteItems()
                        RouteItems()
                        RouteItems()
                        RouteItems()
                    }
                },
            ) {}
            LaunchedEffect(modalSheetState.isVisible) {
                modalSheetState.show()
            }
        }
    }
}

@Composable
fun RouteItems() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Text(text = "Txt view")
    }
}
