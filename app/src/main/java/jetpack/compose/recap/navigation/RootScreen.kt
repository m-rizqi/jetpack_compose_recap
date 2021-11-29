package jetpack.compose.recap.navigation

import android.content.res.Configuration
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import jetpack.compose.recap.data.Component
import jetpack.compose.recap.data.getComponentList
import jetpack.compose.recap.ui.theme.GrayC4C4C4
import jetpack.compose.recap.ui.theme.JetpackcomposerecapTheme

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun DefaultScreen(
    navController: NavController
) {
    val listOfComponent = getComponentList();
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(12.dp)
            ){
                items(listOfComponent){component ->
                    ComponentItem(component = component)
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ComponentItem(component: Component) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(8.dp)
            .background(MaterialTheme.colors.surface)
            .border(
                width = 1.dp,
                color = if (isSystemInDarkTheme()) Color.White else GrayC4C4C4,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp)),
        onClick = component.onClick

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(100.dp)
                    .weight(5f),
                painter = component.icon,
                contentDescription = component.title,
            )
            Text(
                modifier = Modifier
                    .weight(1f),
                text = component.title,
                style = TextStyle(
                    color = MaterialTheme.colors.onSurface,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    fontWeight = FontWeight.Bold,
                ),
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(
    name = "Light Mode",
    showBackground = true,
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultScreenPreview() {
    JetpackcomposerecapTheme {
        DefaultScreen(rememberNavController())
    }
}