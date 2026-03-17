package storage.models

import storage.users
import java.util.Date

/*------------------User-------------------*/
var _userAI: UInt = 0u
public data class User (
    var username:String = "",
    var password:String = "",
    var role:String = "",
    val createdAt: Date = Date(),
    val id:UInt =  _userAI++,
)
fun CreateUser(u: User){
    var username = ""
    users.forEach { i, user->run{
        if(user.username == u.username)
            username = u.username
    }}

    if(username.length != 0)
        throw Exception("User with username:${username} is exist!!!\n")
    else
        users.put(u.id, u)
}

/*------------------UserProfile-------------------*/
private var _usersProfilesAI:UInt = 0u;
data class UserProfile (
    val userID: UInt = _usersProfilesAI++,
    var firstName: String = "",
    var lastName: String = "",
    var avatarUrl: String = "",
    var email: String = "",
    var phone: String = "",
)

fun CreateUserProfile(up: UserProfile){
    var userID = 0u
    users.forEach { i, user->run{
        if(user.id == up.userID)
            userID = user.id
    }}

    if(userID != 0u)
        throw Exception("User with id:${userID} not exist!!!\n")
}