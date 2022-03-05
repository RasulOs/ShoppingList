package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.data.repositories.ShoppingRepository
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    private val executorService: ExecutorService = Executors.newCachedThreadPool()

    fun upsert(item: ShoppingItem) {
        executorService.execute {
            repository.upsert(item)
        }
    }

    fun delete(item: ShoppingItem) {
        executorService.execute {
            repository.delete(item)
        }
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()

}