package com.nosetrap.recyclerview.model.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nosetrap.recyclerview.data.Word

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)

    @Query("DELETE FROM words_table")
    fun deleteAllEntries()

    @Query("SELECT * FROM words_table ORDER BY chosen_word ASC")
    fun getAllWords(): LiveData<List<Word>>
}