package com.example.apppro.ui.login

interface LoginUser {

    //metodos mensajes de login
    interface ViewLogin{
        fun showError(msgError:String)
        fun showProgressDialog()
        fun hideProgressDialog()
        fun signIn()
    }


}