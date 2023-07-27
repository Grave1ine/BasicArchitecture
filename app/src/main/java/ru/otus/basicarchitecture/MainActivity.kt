package ru.otus.basicarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import ru.otus.basicarchitecture.databinding.ActivityMainBinding
import ru.otus.contextMainAct

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding      //для лучшей йправляемости вьюх

    lateinit var navController: NavController      //переменная типа нав контроллер



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.nav_host)   //инициализация нав графа

        contextMainAct = this                                                      //записываем контекст этого активити
    }

}

