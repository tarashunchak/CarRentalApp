package storage

import storage.models.User
import java.util.Date


private var _usersAI:UInt = 0u;

public var users =  mutableMapOf<UInt, User>(
    _usersAI++ to User(_usersAI,"admin" , "admin"),
    _usersAI++ to User(_usersAI,"user", "pass"),
)

