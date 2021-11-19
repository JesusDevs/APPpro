package com.example.apppro.ui.login

interface LoginUser {

    //metodos mensajes de login
    interface ViewLogin{
        fun showError(msgError:String)
        fun ShowProgressDialog()
        fun hideProgressDialog()
        fun signIn()
    }


}