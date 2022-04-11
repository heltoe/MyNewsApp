package study.heltoe.mynewsapp.ui

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)