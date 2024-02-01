package com.music.tweetio.di

import com.music.tweetio.api.TweetsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        }


    // giving api object
    @Singleton
    @Provides
    fun providesTweetsAPI(retrofit: Retrofit):TweetsAPI{
        return retrofit.create(TweetsAPI::class.java)
    }


}