package com.uilover.project296.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AvatarCircle(
    @DrawableRes imageResId: Int,
    size: Dp,
    modifier: Modifier = Modifier,
    borderColor: Color? = null,
    borderWidth: Dp = 0.dp,
    contentDescription: String? = null
) {
    Box(
        modifier = modifier
            .size(size)
            .then(
                if (borderColor != null && borderWidth > 0.dp) {
                    Modifier
                        .background(borderColor, CircleShape)
                        .clip(CircleShape)
                } else {
                    Modifier.clip(CircleShape)
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(if (borderColor != null) size - (borderWidth * 2) else size)
                .clip(CircleShape)
        )
    }
}
