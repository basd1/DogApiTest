package com.bastian.marveltest.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.bastian.marveltest.domain.model.DogBreedModel
import org.koin.compose.koinInject

@Composable
fun DogListScreen(navcontroller: NavHostController,
                  viewModel: DogListScreenViewModel = koinInject()) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchDogBreeds()
    }

    when (uiState) {
        is DogListUiState.Loading -> LoadingScreen()
        is DogListUiState.Success -> DogList((uiState as DogListUiState.Success).dogs)
        is DogListUiState.Error -> ErrorScreen((uiState as DogListUiState.Error).message) {
            viewModel.fetchDogBreeds()
        }
    }
}

@Composable
fun DogList(dogs: List<DogBreedModel>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(dogs) { dog ->
            DogItem(dog)
        }
    }
}

@Composable
fun DogItem(dog: DogBreedModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            // Imagen del perro
            AsyncImage(
                model = dog.imageUrl,
                contentDescription = dog.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 8.dp),
                contentScale = ContentScale.Crop
            )

            // Información del perro
            Column(modifier = Modifier.weight(1f)) {
                Text(text = dog.name)
                dog.temperament?.let {
                    Text(text = it)
                }
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(message: String, onRetry: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = message, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onRetry) {
                Text(text = "Retry")
            }
        }
    }
}
