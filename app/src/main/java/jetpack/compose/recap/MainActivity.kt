package jetpack.compose.recap

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import jetpack.compose.recap.data.Component
import jetpack.compose.recap.data.getComponentList
import jetpack.compose.recap.navigation.DefaultScreen
import jetpack.compose.recap.ui.theme.Black121212
import jetpack.compose.recap.ui.theme.GrayC4C4C4
import jetpack.compose.recap.ui.theme.JetpackcomposerecapTheme

class MainActivity : ComponentActivity() {

    lateinit var navHostController: NavHostController

    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        window.statusBarColor = if (isSystemInDarkTheme()) Black121212.hashCode() else GrayC4C4C4.hashCode()
        window.navigationBarColor = if (isSystemInDarkTheme()) Black121212.hashCode() else Color.White.hashCode()
            JetpackcomposerecapTheme {
                // A surface container using the 'background' color from the theme
                navHostController = rememberNavController()
                DefaultScreen(navHostController)
            }
        }
    }
}