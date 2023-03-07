package com.mkrdeveloper.tabviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.mkrdeveloper.tabviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fragmentsList = arrayListOf(FirstFragment(), SecondFragment(), ThirdFragment())

        binding.apply{
            viewPager.adapter = ViewPagerAdapter(fragmentsList, this@MainActivity.supportFragmentManager, lifecycle)

            TabLayoutMediator(tabView, viewPager){ tab, position ->

                when(position){

                    0 -> { tab.text = "fragment 1"
                        tab.icon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_home_24)

                    }
                    1 -> tab.text = "fragment ${position + 1}"
                    2 -> tab.text = "fragment 3"



                }

            }.attach()



        }
    }
}