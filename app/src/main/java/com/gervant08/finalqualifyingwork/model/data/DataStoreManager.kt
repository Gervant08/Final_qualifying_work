package com.gervant08.finalqualifyingwork.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class DataStoreManager(private val context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_data_store")
    private val dataStoreScope = CoroutineScope(Dispatchers.IO)

    companion object {
        private var INSTANCE: DataStoreManager? = null
        fun getInstance(context: Context): DataStoreManager =
            INSTANCE ?: DataStoreManager(context)

        val FIELD_PASSWORD = stringPreferencesKey("password")
        val FIELD_EMAIL = stringPreferencesKey("email")
    }

    suspend fun writeData(email: String, password: String) {
        context.dataStore.edit { user_data_store ->
            user_data_store[FIELD_EMAIL] = email
            user_data_store[FIELD_PASSWORD] = password
        }
    }

//    fun readEmailAndPassword(): User {
//        var email: String? = ""
//        var password: String? = ""
//
//        dataStoreScope.launch {
//            context.dataStore.data
//                .collect {
//                    email = it[FIELD_EMAIL]
//                    password = it[FIELD_PASSWORD]
//                }
//        }
//
//        return User(email, password)
//    }

    fun readEmail(): Flow<String> =
        context.dataStore.data.map { preference ->
            return@map preference[FIELD_EMAIL].toString()
        }


    fun readPassword(): Flow<String> =
        context.dataStore.data.map { preference ->
        return@map preference[FIELD_PASSWORD].toString()
        }

}