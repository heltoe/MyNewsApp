package study.heltoe.mynewsapp.ui.db

import android.content.Context
import androidx.room.*
import study.heltoe.mynewsapp.ui.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDataBase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var instanse: ArticleDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instanse ?: synchronized(LOCK) {
            instanse ?: createDatabase(context).also { instanse = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDataBase::class.java,
                "article_db.db"
            ).build()
    }
}