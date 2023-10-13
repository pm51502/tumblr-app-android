package com.example.tumblrapp.ui.shared.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.example.tumblrapp.R
import com.example.tumblrapp.domain.models.Tag
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun BlogpostTags(
    modifier: Modifier = Modifier,
    tags: List<Tag>
) {
    FlowRow(
        modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.blogpost_tags_horizontal_padding)),
        mainAxisAlignment = MainAxisAlignment.Center,
        mainAxisSize = SizeMode.Expand,
        crossAxisSpacing = dimensionResource(id = R.dimen.blogpost_tags_cross_axis_spacing),
        mainAxisSpacing = dimensionResource(id = R.dimen.blogpost_tags_main_axis_spacing)
    ) {
        tags.forEach {
            Text(
                text = " #${it.name}",
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
        }
    }
}
