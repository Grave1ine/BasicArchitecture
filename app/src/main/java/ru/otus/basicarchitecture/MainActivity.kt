package ru.otus.basicarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.basicarchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   // private lateinit var binding: ActivityMainBinding      //для лучшей йправляемости вьюх
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
       setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.place_fragment1, Fragment1()).commit()
    }
}