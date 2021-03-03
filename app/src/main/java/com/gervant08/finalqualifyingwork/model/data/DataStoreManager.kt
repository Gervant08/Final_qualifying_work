package com.gervant08.finalqualifyingwork.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DataStoreManager ( private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_data_store")
    private val dataStoreScope = CoroutineScope(Dispatchers.IO)

    object UserScheme {
        val FIELD_EMAIL = stringPreferencesKey("email")
        val FIELD_PASSWORD = stringPreferencesKey("password")
    }

    suspend fun writeData(email: String, password: String) {
        context.dataStore.edit { user_data_store ->
            user_data_store[UserScheme.FIELD_EMAIL] = email
            user_data_store[UserScheme.FIELD_PASSWORD] = password
        }
    }

    fun readEmailAndPassword(): User {
        var email: String? = ""
        var password: String? = ""

        dataStoreScope.launch {
            context.dataStore.data
                .collect {
                    email = it[UserScheme.FIELD_EMAIL]
                    password = it[UserScheme.FIELD_PASSWORD]
                }
        }

        return User(email, password)
    }
}