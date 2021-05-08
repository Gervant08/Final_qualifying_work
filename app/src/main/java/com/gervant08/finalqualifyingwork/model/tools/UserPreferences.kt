package com.gervant08.finalqualifyingwork.model.tools

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserPreferences(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_data_store")
    private val dataStoreScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var INSTANCE: UserPreferences? = null

        fun getInstance(context: Context): UserPreferences {
            return if (INSTANCE == null) {
                INSTANCE = UserPreferences(context)
                INSTANCE!!
            } else {
                INSTANCE!!
            }

        }


        val KEY_PASSWORD = stringPreferencesKey("password")
        val KEY_EMAIL = stringPreferencesKey("email")
    }

    val userEmail: Flow<String?>
        get() = context.dataStore.data.map { preferences ->
            preferences[KEY_EMAIL]
        }


    val userPassword: Flow<String?>
        get() = context.dataStore.data.map { preferences ->
            preferences[KEY_EMAIL]
        }


    suspend fun writeData(email: String, password: String) {
        context.dataStore.edit { user_data_store ->
            user_data_store[KEY_EMAIL] = email
            user_data_store[KEY_PASSWORD] = password
        }
    }


}