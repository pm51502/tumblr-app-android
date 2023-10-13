package com.example.tumblrapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.OpenInBrowser
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tumblrapp.R
import com.example.tumblrapp.domain.models.Blogpost
import com.example.tumblrapp.shared.toDate
import com.example.tumblrapp.ui.shared.components.BlogpostTags
import com.example.tumblrapp.ui.shared.components.ScreenTitle

@Composable
fun DetailsScreen(blogpost: Blogpost?) {
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenTitle(
            title = stringResource(id = R.string.details_screen),
            modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.blogpost_details_title_bottom_padding))
        )

        blogpost?.let {
            Card(
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.blogpost_details_card_border_radius)),
                backgroundColor = MaterialTheme.colors.surface,
                elevation = dimensionResource(id = R.dimen.blogpost_details_card_elevation),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.blogpost_details_card_vertical_spacing)),
                    modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.blogpost_details_card_vertical_padding))
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(model = blogpost.imageUrl),
                        contentDescription = stringResource(id = R.string.blogpost_image),
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(id = R.dimen.blogpost_details_card_image_padding))
                            .size(dimensionResource(id = R.dimen.blogpost_details_card_image_size))
                    )
                    Text(text = blogpost.caption)

                    Text(text = "Posted on ${blogpost.timestamp.toDate()}")

                    BlogpostTags(tags = blogpost.tags)

                    IconButton(onClick = { uriHandler.openUri(blogpost.postUrl) }) {
                        Icon(
                            imageVector = Icons.Sharp.OpenInBrowser,
                            contentDescription = stringResource(id = R.string.open_in_browser_icon)
                        )
                    }
                }
            }
        }
    }
}
