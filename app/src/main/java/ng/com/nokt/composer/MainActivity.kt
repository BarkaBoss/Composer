package ng.com.nokt.composer

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.outlined.RepeatOne
import androidx.compose.material.icons.outlined.Shuffle
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import ng.com.nokt.composer.ui.theme.ComposerTheme

class MainActivity : ComponentActivity() {



        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContent {
            ComposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeHeader()
                }
            }
        }
    }
}

@Composable
fun HomeHeader(){

    val systemUI = rememberSystemUiController()
    systemUI.isStatusBarVisible = false
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Rounded.QueueMusic,
                contentDescription = "Company Logo",
                tint = Color.Gray
            )
            Icon(
                imageVector = Icons.Rounded.Favorite,
                contentDescription = "Favourite",
                tint = Color.Gray
            )
        }

        MusicArt()

        Spacer(Modifier.height(10.dp))

        SongArtistTitle()

        Spacer(Modifier.height(10.dp))

        Controls()
    }



}

@Composable
fun MusicArt(){
    Column(
        modifier = Modifier
            .height(350.dp)
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(modifier = Modifier
            .height(350.dp)
            .width(350.dp)
            .clip(RoundedCornerShape(corner = CornerSize(30.dp)))) {
            Image(painter = painterResource(id = R.drawable.nas),
                contentDescription = "Album Art",
                contentScale = ContentScale.Crop,
                //modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun SongArtistTitle(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count Your Blessings",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                color = Color.DarkGray,
                fontSize = 24.sp
            )
        )
        Spacer(Modifier.height(5.dp))
        Text(text = "Artist's Name",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp
            )
        )
    }
}

@Preview
@Composable
fun Controls(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
        Icon(imageVector = Icons.Outlined.RepeatOne,
            contentDescription = "",
            tint = Color.DarkGray)
        Icon(imageVector = Icons.Filled.SkipPrevious,
            contentDescription = "",
            tint = Color.DarkGray)
        Icon(imageVector = Icons.Filled.PlayCircle,
            contentDescription = "",
            tint = Color.DarkGray,
            modifier = Modifier.size(50.dp)
            )
        Icon(imageVector = Icons.Filled.SkipNext,
            contentDescription = "",
            tint = Color.DarkGray)
        Icon(imageVector = Icons.Outlined.Shuffle,
            contentDescription = "",
            tint = Color.DarkGray)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposerTheme {
        HomeHeader()
    }
}