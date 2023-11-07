package com.example.composepractice.ui.component_practices

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun LazyLayoutPractice2(dogs: List<DogBreed>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 8.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Most popular dog breeds",
                    style = Typography().titleLarge
                )
            }
            items(dogs) { dog ->
                Row {
                    AsyncImage(
                        model = dog.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .clip(shape = RectangleShape)
                            .border(width = 2.dp, color = Color.DarkGray, shape = RectangleShape)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Column(modifier = Modifier.weight(2f)) {
                        Text(text = dog.name, style = Typography().titleSmall)
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(text = dog.description, style = Typography().bodySmall)
                    }
                }
            }
        }

    }
}

data class DogBreed(
    val imageUrl: String,
    val name: String,
    val description: String
)

val dogBreeds = listOf(
    DogBreed(
        imageUrl = "https://www.greendog.com.tr/wp-content/uploads/2023/01/greendog-labrador-retriever1.jpg",
        name = "Labrador Retriever",
        description = "The Labrador Retriever, often abbreviated to Labrador, is a breed of retriever-gun dog from the United Kingdom that was developed from imported Canadian fishing dogs."
    ),
    DogBreed(
        name = "German Shepherd",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbli3QZ-0PXwFkFSQBtocZhfvA29SVsUQu1A&usqp=CAU",
        description = "The German Shepherd is a breed of medium to large-sized working dog that originated in Germany. In the English language, the breed's officially recognized name is German Shepherd Dog."
    ),
    DogBreed(
        name = "Golden Retriever",
        imageUrl = "https://www.petkuafor.co/wp-content/uploads/2022/04/Golden-Retriever-4.webp",
        description = "The Golden Retriever is a medium-large gun dog that was bred to retrieve shot waterfowl, such as ducks and upland game birds, during hunting and shooting parties."
    ),
    DogBreed(
        name = "French Bulldog",
        imageUrl = "https://www.veterinermalzeme.com/uploads/editoruploads/fransiz-bulldog-fiziksel-gorunus.jpg",
        description = "The French Bulldog is a breed of domestic dog, bred to be companion dogs. The breed is the result of a cross between Toy Bulldogs imported from England and local ratters in Paris, France, in the 1800s."
    ),
    DogBreed(
        name = "Bulldog",
        imageUrl = "https://cdn.britannica.com/07/234207-050-0037B589/English-bulldog-dog.jpg",
        description = "The Bulldog, also known as the English Bulldog or British Bulldog, is a medium-sized dog breed. It is a muscular, hefty dog with a wrinkled face and a distinctive pushed-in nose."
    )
)