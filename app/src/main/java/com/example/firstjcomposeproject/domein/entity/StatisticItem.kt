package com.example.firstjcomposeproject.domein.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StatisticItem(
    val type: StatisticType,
    var count: Int = 0
): Parcelable


enum class StatisticType {
    VIEW, COMMENTS, SHARES, LIKES
}