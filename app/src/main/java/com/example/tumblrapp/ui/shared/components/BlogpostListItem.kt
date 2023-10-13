package com.example.tumblrapp.ui.shared.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.example.tumblrapp.R
import com.example.tumblrapp.domain.models.Blogpost
import com.example.tumblrapp.shared.toDate

@Composable
fun BlogpostListItem(
    modifier: Modifier = Modifier,
    blogpost: Blogpost,
    onItemClick: (blogpost: Blogpost) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.blogpost_list_item_border_radius)),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = dimensionResource(id = R.dimen.blogpost_list_item_elevation),
        modifier = modifier
            .padding(vertical = dimensionResource(id = R.dimen.blogpost_list_item_vertical_padding))
            .fillMaxWidth()
            .clickable { onItemClick.invoke(blogpost) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.blogpost_list_item_padding)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.blogpost_list_item_horizontal_spacing)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = blogpost.imageUrl),
                contentDescription = stringResource(id = R.string.blogpost_image),
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.blogpost_list_item_image_padding))
                    .size(dimensionResource(id = R.dimen.blogpost_list_item_image_size))
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.blogpost_list_item_vertical_spacing)),
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.blogpost_list_item_vertical_padding))
            ) {
                Text(
                    text = blogpost.caption,
                    fontWeight = FontWeight.Bold
                )

                Text(text = "Posted on ${blogpost.timestamp.toDate()}")
            }
        }
    }
}
