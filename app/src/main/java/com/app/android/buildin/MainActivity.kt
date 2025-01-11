package com.app.android.buildin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.android.buildin.ui.theme.BuildInTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildInTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val selectedTabIndex = remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavigationBar(
                selectedTabIndex = selectedTabIndex.value,
                onTabSelected = { index -> selectedTabIndex.value = index }
            )
        }
    ) { innerPadding ->
        when (selectedTabIndex.value) {
            0 -> HomeScreen(Modifier.padding(innerPadding))
            1 -> SearchScreen(Modifier.padding(innerPadding))
            2 -> FavoritesScreen(Modifier.padding(innerPadding))
            3 -> ProfileScreen(Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Welcome to Home!",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Explore the latest updates and stay informed.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Search Your Favorite Items",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.padding(8.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Search...") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Your Favorite Items",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "No favorites added yet! Start exploring and mark items as favorites.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Your Profile",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = "Name: John Doe",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Email: john.doe@example.com",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Button(onClick = { /* Action: Edit Profile */ }) {
                Text("Edit Profile")
            }
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = "About Me:",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "I am a tech enthusiast who loves exploring new technologies and building amazing applications.",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTabIndex: Int, onTabSelected: (Int) -> Unit) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedTabIndex == 0,
            onClick = { onTabSelected(0) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            label = { Text("Search") },
            selected = selectedTabIndex == 1,
            onClick = { onTabSelected(1) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
            label = { Text("Favorites") },
            selected = selectedTabIndex == 2,
            onClick = { onTabSelected(2) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = selectedTabIndex == 3,
            onClick = { onTabSelected(3) }
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    BuildInTheme {
        MainScreen()
    }
}