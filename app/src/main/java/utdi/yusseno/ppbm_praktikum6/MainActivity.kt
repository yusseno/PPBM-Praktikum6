package utdi.yusseno.ppbm_praktikum6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import utdi.yusseno.ppbm_praktikum6.ui.theme.PPBMPraktikum6Theme

// Kelas utama aktivitas
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set tata letak kompos
        setContent {
            PPBMPraktikum6Theme {
                // Wadah permukaan menggunakan warna 'background' dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Daftar pemain
                    val players = listOf(
                        Player("Player 1", "Goalkeeper", R.drawable.alison),
                        Player("Player 2", "Defender", R.drawable.alison)
                    )
                    // Tampilkan halaman dengan daftar pemain
                    Page(players)
                }
            }
        }
    }
}

// Data kelas untuk merepresentasikan pemain
data class Player(val name: String, val position: String, val imageResource: Int)

// Komponen untuk menampilkan item pemain
@Composable
fun PlayerItem(player: Player) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tampilkan gambar pemain dari resource
        Image(
            painter = painterResource(id = player.imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(240.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .aspectRatio(1f), // Menggunakan aspek rasio 1:1 untuk menjaga proporsi gambar
            contentScale = ContentScale.Crop
        )

        // Tampilkan detail pemain
        Text(text = player.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = player.position, fontSize = 16.sp)
    }
}

// Komponen untuk menampilkan daftar pemain dalam satu baris
@Composable
fun PlayerList(players: List<Player>) {
    LazyRow {
        items(players) { player ->
            PlayerItem(player = player)
        }
    }
}

// Komponen untuk menampilkan judul halaman
@Composable
fun Header(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Liverpool players'",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 26.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Session in 2023-2024",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 26.sp)
        )
    }
}

// Komponen untuk menampilkan posisi goalkeeper
@Composable
fun PositionGK(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Goalkeeper")
    }
}

// Komponen untuk menampilkan posisi defender
@Composable
fun PositionCB(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Defender")
    }
}

// Komponen untuk menampilkan posisi striker
@Composable
fun PositionST(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Striker")
    }
}

// Komponen utama untuk menampilkan halaman dengan daftar pemain
@Composable
fun Page(players: List<Player>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp), // Padding for the entire content
        verticalArrangement = Arrangement.Top, // Align children at the top of the LazyColumn
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Tampilkan judul halaman
            Header("", modifier = Modifier.padding(bottom = 16.dp))
        }

        item {
            // Tampilkan posisi goalkeeper
            PositionGK("")
        }

        item {
            // Tampilkan daftar pemain untuk posisi goalkeeper
            PlayerList(players = players)
        }

        item {
            // Tampilkan posisi defender
            PositionCB("")
        }

        item {
            // Tampilkan daftar pemain untuk posisi defender
            PlayerList(players = players)
        }

        item {
            // Tampilkan posisi striker
            PositionST("")
        }

        item {
            // Tampilkan daftar pemain untuk posisi striker
            PlayerList(players = players)
        }
    }
}

// Pratinjau tampilan halaman
@Preview(showBackground = true)
@Composable
fun PagePreview() {
    PPBMPraktikum6Theme {
        val players = listOf(
            Player("Player 1", "Goalkeeper", R.drawable.alison),
            Player("Player 2", "Defender", R.drawable.alison)
            // Tambahkan pemain lainnya sesuai kebutuhan
        )
        // Tampilkan pratinjau halaman dengan daftar pemain
        Page(players)
    }
}
