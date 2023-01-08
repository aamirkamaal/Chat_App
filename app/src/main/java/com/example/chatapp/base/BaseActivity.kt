package com.example.chatapp.base

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    protected fun init(){
        initArguments()
        initViews()
        setupData()
        setupListener()
    }

    abstract fun initArguments()
    abstract fun initViews()
    abstract fun setupListener()
    abstract fun setupData()

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun setWindowBackground(background: Drawable?) {
        if (background == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = resources.getColor(android.R.color.black)
                window.navigationBarColor = resources.getColor(android.R.color.black)
            }
            return
        }
        val window = window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(android.R.color.transparent)
            window.navigationBarColor = resources.getColor(android.R.color.black)
        }
        window.setBackgroundDrawable(background)
    }

    fun setLightStatusBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = activity.window.decorView.systemUiVisibility // get current flag
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR // add LIGHT_STATUS_BAR to flag
            activity.window.decorView.systemUiVisibility = flags
        }
    }

    fun clearLightStatusBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var flags = activity.window.decorView.systemUiVisibility // get current flag
            flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv() // use XOR here for remove LIGHT_STATUS_BAR from flags
            activity.window.decorView.systemUiVisibility = flags
        }
    }

}