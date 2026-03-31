package services

import android.content.Context
import android.widget.Toast
import storage.setCurrentUserID
import storage.users

enum class AuthStatus {
    UsernameISCorrect,
    UsernameISNotCorrect,
    PasswordISCorrect,
    PasswordISNotCorrect,
}

fun IsUserExist(username:String, password :String):Pair<AuthStatus, AuthStatus>{
    var result: Pair<AuthStatus, AuthStatus>
    = AuthStatus.UsernameISNotCorrect to AuthStatus.PasswordISNotCorrect
    users.forEach { i, user -> run {
        if(user.password == password && user.username == username)
            result = AuthStatus.UsernameISCorrect to AuthStatus.PasswordISCorrect
        else if(user.username == username && user.password != password)
           result = AuthStatus.UsernameISCorrect to AuthStatus.PasswordISNotCorrect
    }}
    return result
}

fun AuthUser(username:String, password:String, context: Context) : Boolean{
    val result = IsUserExist(username, password)
    if(result.first == AuthStatus.UsernameISCorrect) {
        if (result.second == AuthStatus.PasswordISCorrect) {
            setCurrentUserID(users.entries.find { it.value.username == username }?.key ?: 0u)
            return true
        }
        /*else{
            Toast.makeText(context, "Incorrect password!", Toast.LENGTH_SHORT)?.show()
            return false
        }*/
    }
    Toast.makeText(context, "Incorrect login data", Toast.LENGTH_SHORT)?.show()
    return false
}