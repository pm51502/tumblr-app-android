package com.example.tumblrapp.ui.shared.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.example.tumblrapp.domain.models.Blogpost
import kotlinx.coroutines.flow.Flow

@Composable
fun BlogpostList(
    modifier: Modifier = Modifier,
    blogpostFlow: Flow<PagingData<Blogpost>>,
    onItemClick: (blogpost: Blogpost) -> Unit
) {
    val lazyBlogpostItems: LazyPagingItems<Blogpost> = blogpostFlow.collectAsLazyPagingItems()
    val listState: LazyListState = rememberLazyListState()

    when (lazyBlogpostItems.itemCount) {
        0 -> LoadingView()
        else -> {
            LazyColumn(
                modifier = modifier,
                state = listState
            ) {
                items(
                    items = lazyBlogpostItems,
                    key = { it.id }
                ) { blogpost ->
                    blogpost?.let {
                        BlogpostListItem(
                            blogpost = blogpost,
                            onItemClick = onItemClick
                        )
                    }
                }

                lazyBlogpostItems.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                        }
                        loadState.append is LoadState.Loading -> {
                            item { LoadingItem() }
                        }
                        loadState.refresh is LoadState.Error -> {
                            val e = lazyBlogpostItems.loadState.refresh as LoadState.Error
                            item {
                                ErrorItem(
                                    modifier = Modifier.fillParentMaxSize(),
                                    message = e.error.localizedMessage,
                                    onRetryClick = { retry() }
                                )
                            }
                        }
                        loadState.append is LoadState.Error -> {
                            val e = lazyBlogpostItems.loadState.append as LoadState.Error
                            item {
                                ErrorItem(
                                    message = e.error.localizedMessage,
                                    onRetryClick = { retry() }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
