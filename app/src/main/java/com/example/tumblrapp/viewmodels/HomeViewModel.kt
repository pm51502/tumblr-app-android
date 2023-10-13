package com.example.tumblrapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.tumblrapp.domain.models.Blogpost
import com.example.tumblrapp.repository.BlogpostRepository
import com.example.tumblrapp.shared.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel(val blogpostRepository: BlogpostRepository) : ViewModel() {

    companion object {
        const val PAGE_SIZE = 6
        const val PREFETCH_DISTANCE = 0
        const val INITIAL_LOAD_SIZE = 6
    }

    val blogposts: Flow<PagingData<Blogpost>> = Pager(
        PagingConfig(
            pageSize = PAGE_SIZE,
            prefetchDistance = PREFETCH_DISTANCE,
            initialLoadSize = INITIAL_LOAD_SIZE
        )
    ) {
        blogpostRepository.blogpostsPagingSource()
    }.flow.map {
        it.map { blogpostEntity ->
            blogpostEntity.toModel()
        }
    }.cachedIn(viewModelScope)

    fun clearDb() {
        viewModelScope.launch {
            blogpostRepository.deleteAllBlogposts()
        }
    }
}
