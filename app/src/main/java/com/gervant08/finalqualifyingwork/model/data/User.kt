package com.gervant08.finalqualifyingwork.model.data

import java.io.Serializable

class User(val uId: String,
           val name: String,
           val email: String,
           val isAuthenticated: Boolean = false,
           val isCreated: Boolean = true
) : Serializable {
    val isNew: Boolean? = null
}
