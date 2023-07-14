package com.naftalimurgor.recyclerview.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// An object instance of Affirmation represents one affirmation
// we use anotation to prevent passing the wrong resourceId since all are of type Int
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)