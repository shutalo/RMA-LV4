package com.example.zad2.data.api

import com.example.zad2.data.model.User
import io.reactivex.Single

interface ApiService {

    fun getUsers(): Single<List<User>>

}