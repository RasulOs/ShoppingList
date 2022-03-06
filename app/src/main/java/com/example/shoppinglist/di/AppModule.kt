package com.example.shoppinglist.di

import android.content.Context
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.repositories.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @Named("DB")
    fun provideDB(@ApplicationContext context: Context) = ShoppingDatabase(context)

    @Provides
    @Singleton
    @Named("Repository")
    fun provideRepository(@Named("DB") db: ShoppingDatabase) = ShoppingRepository(db)

}