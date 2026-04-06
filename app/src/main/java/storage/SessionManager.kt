package storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


object SessionManager{
    private val Context.dataStore by preferencesDataStore(name="user_session")
    private val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
    private val USER_ID = intPreferencesKey("user_id")
    private lateinit var dataStore: DataStore<Preferences>

    fun isLoggedIn(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[IS_LOGGED_IN] ?: false
        }
    }

    fun init(context: Context) {
        dataStore = context.applicationContext.dataStore
    }

    suspend fun saveSession(userID: Int){
        dataStore.edit {preferences ->
            preferences[IS_LOGGED_IN] = true
            preferences[USER_ID] = userID
        }
    }

    suspend fun clearSession(){
        dataStore.edit {preferences ->
            preferences.clear()
        }
    }
}