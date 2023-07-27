package ru.otus.basicarchitecture

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import ru.otus.basicarchitecture.databinding.Fragment1Binding
import ru.otus.basicarchitecture.viewModel.viewModelFR1


class Fragment1 : Fragment() {

    private lateinit var binding: Fragment1Binding

     private val dataModel: viewModelFR1 by activityViewModels()  //activityViewModels для фрагментов

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = Fragment1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataModel.viewState.observe(this) {state ->
            binding.goToFR2.isClickable = state.dataOK  //должна блокировать или не блокировать кнопку
            binding.name.text ?: state.name    //есть ли в этом смысл? наверно нет т.к editText
        }

        binding.goToFR2.setOnClickListener{
            //contextMainAct.navController.navigate(R.id.action_fragment1_to_fragment2)
            dataModel.openFrag(R.id.action_fragment1_to_fragment2)
        }

        dataModel.setName(binding.name.text.toString())  // запись имени в модель?
        dataModel.setSurname(binding.surName.text.toString())
        dataModel.setData(binding.data.text.toString())


    }



}