package com.example.apppro.ui.SplashScreenAnima

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.apppro.R
import com.example.apppro.base.BaseActivity
import com.example.apppro.databinding.ActivitySplashBinding
import com.example.apppro.ui.login.LoginFullActivity


@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 2000 //2 seconds

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext,LoginFullActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {

        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }

}
