package storage.models

import java.util.Date

public data class User (
    val id: UInt,
    var username:String = "",
    var password:String = "",
    val createdAt: Date = Date(),
)
