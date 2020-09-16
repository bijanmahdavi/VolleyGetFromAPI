package com.example.volleydatafromapi.Models

data class NewsResult(
    val articles: ArrayList<Article>,
    val status: String,
    val totalResults: Int
)

data class Article(
    val author: Any,
    val content: Any,
    val description: Any,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: Any
)

data class Source(
    val id: String,
    val name: String
)