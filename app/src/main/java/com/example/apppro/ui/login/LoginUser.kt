package com.example.apppro.ui.login

interface LoginUser {
    interface ViewLogin{
        fun showError(msgError:String)
        fun ShowProgressDialog()
        fun hideProgressDialog()
        fun signIn()
    }


}