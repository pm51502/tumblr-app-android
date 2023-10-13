package com.example.tumblrapp.data.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tumblrapp.data.database.entity.BlogpostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogpostDao {
    @Query("SELECT * FROM blogpost")
    fun getBlogposts(): Flow<List<BlogpostEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(blogpost: BlogpostEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMany(blogpostList: List<BlogpostEntity>)

    @Query("DELETE FROM blogpost")
    suspend fun deleteAll()

    @Query("SELECT * FROM blogpost")
    fun blogpostPagingSource(): PagingSource<Int, BlogpostEntity>
}
