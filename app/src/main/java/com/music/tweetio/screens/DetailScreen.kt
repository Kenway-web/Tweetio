package com.music.tweetio.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.music.tweetio.models.TweetListItem
import com.music.tweetio.viewmodels.DetailViewModel


@Composable
fun DetailsScreen(){
    val detailViewModel:DetailViewModel= hiltViewModel()
    val tweets = detailViewModel.tweets.collectAsState()
    
    LazyColumn(content = {
        items(tweets.value){
            TweetListItem(tweet = it.text)
        }
    })
    
}


@Composable
fun TweetListItem(tweet:String){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(
              text=tweet,
              modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium.copy(
                  fontStyle = FontStyle.Italic,
                  fontWeight = FontWeight.Bold
              )
            )
        }
    )
}