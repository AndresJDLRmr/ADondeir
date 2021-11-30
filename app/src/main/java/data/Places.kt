package data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Places(
    @StringRes val placeName: Int,
    @StringRes val placeHour: Int,
    @StringRes val placeLocation: Int,
    @DrawableRes val placeImage: Int
)
