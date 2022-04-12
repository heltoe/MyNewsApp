package study.heltoe.mynewsapp.ui.repository

import study.heltoe.mynewsapp.ui.api.RetrofitInstance
import study.heltoe.mynewsapp.ui.db.ArticleDataBase

class NewsRepository(val db: ArticleDataBase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)
}