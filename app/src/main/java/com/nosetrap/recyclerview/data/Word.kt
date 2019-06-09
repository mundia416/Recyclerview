package com.nosetrap.recyclerview.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words_table")
data class Word(@PrimaryKey(autoGenerate = true) var id: Int,
                @ColumnInfo(name = "chosen_word") var word:String)