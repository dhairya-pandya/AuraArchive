package com.example.auraarchive.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.auraarchive.ui.components.AuraCard
import com.example.auraarchive.ui.components.TopBar

@Composable
fun HomeScreen() {
    HomeScreenLayout(
        title = "Home"
    )
}

@Composable
fun HomeScreenLayout(
    title: String,
    onAddClick: () -> Unit = {},
    onMenuClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopBar(title = title)
        },
        floatingActionButton = {
            LargeFloatingActionButton(
                onClick = onAddClick,
                shape = RoundedCornerShape(50.dp),
                containerColor = Color.Gray
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Entry",
                    modifier = Modifier.size(36.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Start
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color.LightGray)
                    )
                }

                items(listOf("Last Friday", "Last Friday")) { sectionTitle ->
                    SectionHeader(sectionTitle)
                    AuraCard(
                        Description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Facilis quis deleniti voluptatem."
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }

            FloatingActionButton(
                onClick = onMenuClick,
                containerColor = Color.Gray,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        }
    }
}

@Composable
fun SectionHeader(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.width(8.dp))
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            thickness = 1.dp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreenLayout(title = "Home")
    }
}