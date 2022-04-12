package study.heltoe.mynewsapp.ui.db

import androidx.room.TypeConverter
import study.heltoe.mynewsapp.ui.models.Source

class Converters {
    @TypeConverter
    fun fromSourse(sourse: Source): String {
        return sourse.name
    }

    @TypeConverter
    fun toSourse(name: String): Source {
        return Source(name, name)
    }
}