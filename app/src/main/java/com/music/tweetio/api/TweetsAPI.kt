package com.music.tweetio.api

import com.music.tweetio.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsAPI {

    @GET("/v3/b/654fb51a54105e766fceacb3?meta=false")
    suspend fun getTweets( @Header("X-JSON-Path") category: String) : Response<List<TweetListItem>>

    @GET("/v3/b/654fb51a54105e766fceacb3?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories():Response<List<String>>

}