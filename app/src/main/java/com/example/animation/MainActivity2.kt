package com.example.animation

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import com.example.animation.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lottieLoading.playAnimation()
        var count=0f
        binding.btnStartAnime.setOnClickListener {
            if (count==0.9f){
                count=0f
            }
            binding.lottieLoading.progress=count
            count+=0.1f

        }
        binding.lottieLoading.addAnimatorListener(object :Animator.AnimatorListener{
            override fun onAnimationStart(p0: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(p0: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationCancel(p0: Animator?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(p0: Animator?) {
                TODO("Not yet implemented")
            }

        })
    }
}