package code.sandeep.shimmereffectcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import code.sandeep.shimmereffectcompose.ui.theme.ShimmerLoadingEffectTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShimmerLoadingEffectTheme {
                var isLoading by remember {
                    mutableStateOf(true)
                }
                LaunchedEffect(key1 = true) {
                    delay(7000)
                    isLoading = false
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(20) {
                        ShimmerListItem(
                            isLoading = isLoading, contentAfterLoading = {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = null,
                                        modifier = Modifier.size(100.dp)
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        text = "This is long text to show that our shimmer display is  looking perfectly fine"
                                    )
                                }
                            }, modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}