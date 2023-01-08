package com.example.chatapp.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupListener()
        loadData()
    }

    fun showToast(msg: String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    abstract fun initViews(view: View)
    abstract fun setupListener()
    abstract fun loadData()


}