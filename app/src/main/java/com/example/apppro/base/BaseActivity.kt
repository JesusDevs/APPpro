package com.example.apppro.base

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import androidx.annotation.LayoutRes

import com.example.apppro.databinding.ActivityMainBinding
/* actividad base para crear metodos extendidos (Extension function)
* se extiende de AppCompactActivity y permite crear plantillas de trabajo reduciendo codigo redundante an cada activity
* */

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}