package jetpack.compose.recap.data.model

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import jetpack.compose.recap.R

data class Component(
    val title : String,
    val icon : Painter,
    val onClick : () -> Unit
)

@Composable
fun getComponentList() : List<Component>{
    return listOf(
        Component(
            "Button",
            if (isSystemInDarkTheme()) painterResource(id = R.drawable.ic_button_dark) else painterResource(
                id = R.drawable.ic_button_light
            )
        ) {}
    )
}
