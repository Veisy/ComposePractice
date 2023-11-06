package com.example.composepractice.ui

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun LazyLayoutPractice(profile: Profile) {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 5.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = profile.profileImage,
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(shape = CircleShape)
                    .border(width = 2.dp, color = Color.DarkGray, shape = CircleShape),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
            ) {
                ProfileInfo(title = profile.posts.toString(), body = "Posts")
                ProfileInfo(title = profile.followers.toString(), body = "Followers")
                ProfileInfo(title = profile.following.toString(), body = "Following")
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = profile.name, fontWeight = FontWeight.Bold, fontSize = 13.sp)
        LazyColumn {
            items(profile.hobbies) { items ->
                Text(text = items, fontSize = 13.sp)

            }
        }
        Spacer(modifier = Modifier.size(12.dp))
        Button(
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Edit Profile", fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = profile.city, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier
            .size(4.dp)
            .fillMaxWidth())
        LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            items(cityImages) { images ->
                AsyncImage(
                    model = images,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(shape = RectangleShape)
                )
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(profile.cityImages) { item ->
                AsyncImage(
                    model = item,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }
    }
}

@Composable
fun ProfileInfo(title: String, body: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = body, fontSize = 13.sp)
    }
}

data class Profile(
    val name: String,
    val profileImage: String,
    val posts: Int,
    val followers: Int,
    val following: Int,
    val city: String,
    val cityImages: List<String>,
    val hobbies: List<String>
)

val cityImages: List<String> = listOf(
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9PMSkHBhJ2-KaGFOp_grvzDsUKQ6y6wDzbg&usqp=CAU",
    "https://media.istockphoto.com/id/1384422450/tr/foto%C4%9Fraf/freedom-tower-and-lower-manhattan-from-new-jersey.jpg?s=612x612&w=0&k=20&c=KVybj5jR8uN72eZ4OseKtZDvsKRdTlbfLyAHZfc4tvA=",
    "https://images.pexels.com/photos/2168974/pexels-photo-2168974.jpeg?cs=srgb&dl=pexels-mohamed-almari-2168974.jpg&fm=jpg",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/View_of_Empire_State_Building_from_Rockefeller_Center_New_York_City_dllu_%28cropped%29.jpg/1200px-View_of_Empire_State_Building_from_Rockefeller_Center_New_York_City_dllu_%28cropped%29.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdjGcKdVBQ47E09tk2aG3tOx9vdRw4rd-0uw&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6I5KtZZd6XMNKC7xrZ8W6OOE3Qz0akijaAQ&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRE9xvCEyg3oLmTLDLl1oq3B1fQhRIiysrcRw&usqp=CAU",
    "https://www.ekoiq.com/wp-content/uploads/2023/06/new-york-1280x700.jpeg",
    "https://media.architecturaldigest.com/photos/5da74823d599ec0008227ea8/master/pass/GettyImages-946087016.jpg",
    "https://res.klook.com/image/upload/Mobile/City/szhx3ytpgfnhpbmsngk0.jpg",
    "https://res.cloudinary.com/hello-tickets/image/upload/ar_1:1,c_fill,f_auto,q_auto,w_800/v1639448826/ignuqnj093e3v7tjot29.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4uRdNd7VrspBChOQr9zjk-Q428FraAeCqOw&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRhdIvFyz0t6gZlc6ZHoDsJic_r4muN2XjzxQ&usqp=CAU",
    "https://i.pinimg.com/736x/7f/fb/eb/7ffbeb2fb1a617441c6fbbd47916d5e0.jpg",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQY1FueDIV46_HX2B1ElRrxW0ptfO0qEPafSA&usqp=CAU",
    "https://media.istockphoto.com/id/178735930/photo/dramatic-sunset-view-highlighting-the-empire-state-building.jpg?s=612x612&w=0&k=20&c=vvpfw74yLA1H3ieZh3ENSkeukxjpeXJ-Q6AJovigIEo=",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbr3dC9z6rIRld0_7MMh8cEWeR1xApa1-wBhNdaABUoLIEjpqOLbmh-C3j8zPj5fy3rCM&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROPwHdl5EC1vMqnNV3MhFRkerkIbFGpZ0UJCe_gv_jc2VWTYpbK4BANsHetNFgAT-xSSo&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoQFoNUSgfLQu8tux-Y0PCv5uClx96dgf4wA&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQe-J9nb9m9Lbb6fJqvD8cihHpet8RCl_TWvw&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQuGbw3XNvXfkMlw_EcT-aGIA1xFKhweiglvw&usqp=CAU"
)