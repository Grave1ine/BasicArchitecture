package ru.otus.basicarchitecture.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.otus.basicarchitecture.viewState.viewStateFR1
import ru.otus.contextMainAct
import java.time.DateTimeException
import java.time.LocalDate
import java.time.Month

open class viewModelFR1: ViewModel() {    //хранит состояние вьюх

     val _stateFR1: MutableLiveData<viewStateFR1> by lazy {  //хранилище данных типа viewStateFR1
        MutableLiveData<viewStateFR1>()
    }//LiveData - хранилище данных, работающее по принципу паттерна Observer (наблюдатель).

    val viewState: LiveData<viewStateFR1> = _stateFR1    //не знаю нужна ли


     fun openFrag(i: Int){
        contextMainAct.navController.navigate(i)

    }

    private val valueFR1 = _stateFR1.value?: viewStateFR1()   //не очень понимаю зачем это

    fun setName(name: String){
        valueFR1.name = name
    }

    fun setSurname(surname: String){
        valueFR1.surName = surname
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setData(data: String?){
        valueFR1.data = data

        val vet = valueFR1.data?.split(".")   //делит введенную дату
        val splitData = mutableListOf<String>()
        if (vet != null) {

            for (i in vet){                             //записываем в список
            splitData.add(i)   //dd, mm, gggg
            }
        }

        val today = LocalDate.now()  //сегодня

        try {
                val specificDate = LocalDate.of(
                splitData[2].toInt(),
                splitData[1].toInt(),
                splitData[0].toInt()
            ) //введенная дата

            valueFR1.dataOK = today.minusYears(18).isAfter(specificDate)   //true если болше 18

        } catch (_: Exception){
            valueFR1.dataOK = false
        }




    }



}