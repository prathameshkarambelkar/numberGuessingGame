package com.example.guessingnumbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.guessingnumbergame.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  var count = 0
    private var r1: Int? = null
    private var r2: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        giveRandomNumber()
        binding.btnLeft.setOnClickListener {
            if(r1!! > r2!!)
                count++
            else
                count--
            binding.tvPoints.text = "Count $count"
            giveRandomNumber()
        }
        binding.btnRight.setOnClickListener {
                if(r1!! < r2!!)
                    count++
                else
                    count--
                binding.tvPoints.text = "Count $count"
            giveRandomNumber()
        }
    }


    fun giveRandomNumber(){
        val rand = Random
        if(count == 5){
            count = 0
            Toast.makeText(this,"You Won!" ,Toast.LENGTH_SHORT).show()
            binding.tvPoints.text = "Count $count"
        } else{
            r1 = rand.nextInt(10);
            while(true){
                r2 = rand.nextInt(10)
                if(r1!=r2)
                    break
            }

        }
        binding.btnLeft.text = "$r1"
        binding.btnRight.text = "$r2"
    }

}