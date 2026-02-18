package ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonevishing.R
import com.example.gonevishing.ui.theme.Blue
import com.example.gonevishing.ui.theme.DarkCyan
import com.example.gonevishing.ui.theme.LightBlue
import com.example.gonevishing.ui.theme.Turquoise

@Composable
fun HomeScreen(
    onAgentManagementClick: () -> Unit = {},
    onAutomationManagementClick: () -> Unit = {},
    onAccountClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Blue,
                        DarkCyan,
                        Blue
                    )
                )
            ),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fishing_boat_resimplified),
                    contentDescription = "fishing boat",
                    modifier = Modifier.size(width = 220.dp, height = 120.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(Modifier.weight(1f))

                IconButton(
                    onClick = onSettingsClick,
                    modifier = Modifier.size(40.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.settings_icon),
                        contentDescription = "settings",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(Modifier.width(8.dp))

                IconButton(
                    onClick = onAccountClick,
                    modifier = Modifier.size(70.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.account_icon),
                        contentDescription = "account icon",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            Spacer(Modifier.height(48.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomeMenuButton(
                    text = "Agent Management",
                    onClick = onAgentManagementClick
                )

                Spacer(Modifier.height(28.dp))

                HomeMenuButton(
                    text = "Automation Management",
                    onClick = onAutomationManagementClick
                )

            }
            Spacer(Modifier.weight(1f))

            HomeIconPill(
                iconResIds = listOf(
                    R.drawable.agent_icon_1,
                    R.drawable.agent_icon_1,
                    R.drawable.agent_icon_1,
                    R.drawable.agent_icon_1,
                    R.drawable.agent_icon_1,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(bottom = 12.dp)
            )
        }
    }
}

@Composable
private fun HomeMenuButton(
    text: String,
    onClick: () -> Unit,
) {
    Surface(
        onClick = onClick,
        color = Color(0xFFD9D9D9),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(320.dp)
            .height(96.dp)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
    }
}

@Composable
private fun HomeIconPill(
    iconResIds: List<Int>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(82.dp)
                .clip(RoundedCornerShape(999.dp))
                .background(Color(0xFFEFEFEF))
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(iconResIds) { resId ->
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = resId),
                            contentDescription = null,
                            modifier = Modifier.size(34.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
