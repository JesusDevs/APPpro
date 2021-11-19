package com.example.apppro.pojo

import com.google.gson.annotations.SerializedName


data class LoginResponse (


    @SerializedName("STATUS")
    var STATUS:String = "OK",
    @SerializedName("api-token")
    var apiToken :String = "a88cfc8ea5ca5a47f27a5320c23db568"

)