package com.example.tumblrapp.repository

import androidx.paging.PagingSource
import com.example.tumblrapp.data.database.dao.BlogpostDao
import com.example.tumblrapp.data.database.entity.BlogpostEntity
import com.example.tumblrapp.data.network.requests.BlogpostApi
import com.example.tumblrapp.data.network.responses.Blog
import com.example.tumblrapp.domain.models.Blogpost
import com.example.tumblrapp.shared.toEntity
import com.example.tumblrapp.shared.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

interface BlogpostRepository {
    suspend fun fetchBlogposts(): Response<Blog>
    fun getBlogposts(): Flow<List<Blogpost>>
    suspend fun insertBlogpost(blogpost: Blogpost)
    suspend fun insertBlogposts(blogpostList: List<Blogpost>)
    suspend fun deleteAllBlogposts()
    fun blogpostsPagingSource(): PagingSource<Int, BlogpostEntity>
}

class BlogpostRepositoryImpl(
    private val blogpostApi: BlogpostApi,
    private val blogpostDao: BlogpostDao
) : BlogpostRepository {
    override suspend fun fetchBlogposts(): Response<Blog> =
        blogpostApi.getBlogposts()

    override fun getBlogposts(): Flow<List<Blogpost>> =
        blogpostDao.getBlogposts().map {
            it.map { blogpostEntity ->
                blogpostEntity.toModel()
            }
        }

    override suspend fun insertBlogpost(blogpost: Blogpost) =
        blogpostDao.insert(blogpost = blogpost.toEntity())

    override suspend fun insertBlogposts(blogpostList: List<Blogpost>) =
        blogpostDao.insertMany(blogpostList = blogpostList.map { it.toEntity() })

    override suspend fun deleteAllBlogposts() =
        blogpostDao.deleteAll()

    override fun blogpostsPagingSource(): PagingSource<Int, BlogpostEntity> =
        blogpostDao.blogpostPagingSource()
}
