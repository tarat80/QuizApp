package com.example.quizapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.util.stream.Collectors

@ProvidedTypeConverter
class Converter {
    @TypeConverter
    fun fromList(hobbies: List<String>): String {
        return hobbies.stream().collect(Collectors.joining(","))
    }

    @TypeConverter
    fun toList(data: String): List<String> {
        return listOf(*data.split(",".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray())
    }
}