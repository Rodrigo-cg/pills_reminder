package com.abi.pills_reminder.feature.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
