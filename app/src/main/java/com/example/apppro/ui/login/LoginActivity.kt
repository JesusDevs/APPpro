package com.example.apppro.ui.login

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


import com.example.apppro.databinding.LoginBinding

class LoginActivity : AppCompatActivity(),LoginUser.ViewLogin {
 private lateinit var binding : LoginBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //pantalla sin barra de notificaciones
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    override fun showError(msgError: String) {
        Toast.makeText(this,msgError,Toast.LENGTH_SHORT).show()
    }

    override fun ShowProgressDialog() {
        TODO("Not yet implemented")
    }

    override fun hideProgressDialog() {
        TODO("Not yet implemented")
    }

    override fun signIn() {
        TODO("Not yet implemented")
    }


}