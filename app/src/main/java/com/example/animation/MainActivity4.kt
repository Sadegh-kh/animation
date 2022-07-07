package com.example.animation

import android.os.Bundle
import com.example.animation.databinding.ActivityMain4Binding
import com.example.animation.ext.BaseActivity

class MainActivity4 : BaseActivity() {
    lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}