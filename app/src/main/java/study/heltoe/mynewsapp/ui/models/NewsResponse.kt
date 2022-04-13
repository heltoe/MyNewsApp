package study.heltoe.mynewsapp.ui.models

import study.heltoe.mynewsapp.ui.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)