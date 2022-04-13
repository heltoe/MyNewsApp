package study.heltoe.mynewsapp.ui.repository

import study.heltoe.mynewsapp.ui.api.RetrofitInstance
import study.heltoe.mynewsapp.ui.db.ArticleDataBase
import study.heltoe.mynewsapp.ui.models.Article

class NewsRepository(val db: ArticleDataBase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}