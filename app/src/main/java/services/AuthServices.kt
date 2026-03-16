package services

import storage.users

fun IsUserExist(username:String, password :String):Boolean{
    var result = false
    users.forEach { i, user -> run {
        if(user.password == password && user.username == username)
            result = true
    }}
    return result
}

fun AuthUser(username:String, password:String){

}