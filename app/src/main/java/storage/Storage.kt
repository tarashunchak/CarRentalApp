package storage

import storage.models.CreateUser
import storage.models.User
import storage.models.UserProfile
import java.util.Date

public var users =  mutableMapOf<UInt, User>()
public var usersProfiles = mutableMapOf<UInt, UserProfile>()

public fun FillWithTestData(){
    CreateUser(User("admin", "admin"))
}