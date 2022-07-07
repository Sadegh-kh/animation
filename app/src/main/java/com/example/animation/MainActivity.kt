package com.example.animation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.*
import androidx.annotation.RequiresApi
import com.example.animation.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Alpha Animation=>
        binding.btnAnim.setOnClickListener {
            useAnimFromXMl()
        }

    }




    private fun alphaAnimation() {
        val anim = AlphaAnimation(0f, 1f)

        //for all animation
        anim.duration = 3000L//3 sec
        anim.fillAfter = true
        anim.repeatCount = 5//6 time replay

        anim.repeatMode = Animation.REVERSE

        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                Log.v("testAnimation", "anim started")
            }

            override fun onAnimationEnd(p0: Animation?) {
                Log.v("testAnimation", "anim ended")
            }

            override fun onAnimationRepeat(p0: Animation?) {
                Log.v("testAnimation", "anim repeat")
            }

        })


        binding.imgAnim.startAnimation(anim)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    private fun translateAnimation() {
        val anim = TranslateAnimation(0f, 0f, 0f, 1400f)
        anim.duration = 2000L
        anim.fillAfter = true
        //anim.interpolator = AccelerateDecelerateInterpolator()
        //anim.interpolator=DecelerateInterpolator()
        //anim.interpolator=AccelerateInterpolator()
        //anim.interpolator=AnticipateOvershootInterpolator()
        //anim.interpolator=BounceInterpolator()
        //anim.interpolator=CycleInterpolator(4f)
        //anim.interpolator=OvershootInterpolator()
        //anim.interpolator=AnticipateOvershootInterpolator()
        //anim.interpolator=LinearInterpolator()
        anim.interpolator = PathInterpolator(0.1f, 0.1f)
        binding.imgAnim.startAnimation(anim)
    }

    private fun rotateAnimation():RotateAnimation {
        val anim = RotateAnimation(
            0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim.repeatCount=10
        anim.duration = 2000L
        return anim
    }

    private fun scaleAnimation():ScaleAnimation  {
        val anim1 = ScaleAnimation(1f, 2f, 1f, 2f)
        anim1.duration = 2000L
        anim1.fillAfter = true
        val anim2 = ScaleAnimation(
            1f, 2f, 1f, 2f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim2.duration = 2000
        return anim2
    }

    private fun useMultipleAnimation() {
        val animSet = AnimationSet(false)
        animSet.addAnimation(rotateAnimation())
        animSet.addAnimation(scaleAnimation())
        animSet.duration=2000
        animSet.repeatCount=3
        binding.imgAnim.startAnimation(animSet)
    }

    private fun useAnimFromXMl(){
        val anim = AnimationUtils.loadAnimation(this,R.anim.anim_alpha)
        anim.fillAfter=true
        binding.imgAnim.startAnimation(anim)

    }
}