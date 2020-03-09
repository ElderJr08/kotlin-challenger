package com.br.elderjr.kotlinchallenger.wrapper

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.MongoException

class MongoDbWrapper {
    val stringConnection: String = "mongodb+srv://omnistack:senha123@cluster0-0opql.mongodb.net/test?retryWrites=true&w=majority";

    fun connection(database: String) {
        var mongoClient: MongoClient? = null;
        val mongoURI: MongoClientURI = MongoClientURI(stringConnection);
        try {
            mongoClient = MongoClient(mongoURI);
            val database = mongoClient.getDatabase(database);
            println("Connected!");
        } catch (e: MongoException) {
            println(e);
            mongoClient?.close();
        }
    }
}