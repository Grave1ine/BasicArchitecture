package ru.otus.basicarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import ru.otus.WizardCache
import ru.otus.basicarchitecture.internetAdrdess.AddressServiceModule
import ru.otus.basicarchitecture.viewState.viewStateFR2
import javax.inject.Inject


@HiltViewModel
open class viewModelFR2 @Inject constructor(private val cache: WizardCache): ViewModel() {

    val _stateFR2: MutableLiveData<viewStateFR2> = MutableLiveData<viewStateFR2>(  //хранит состояние (viewModel)
        viewStateFR2() // Начальное значение
    ) //для обращений внурти (тут)

    val viewState: LiveData<viewStateFR2> get() = _stateFR2.distinctUntilChanged()  //в фрагментах/активити использовать это поле для обращения к состоянию
    //для обращений снаружи(ativity/frahment)

    private fun renderView() {   //обновлялка viewState (синхронизация с WizardCache)
        _stateFR2.value = with(cache) {
            viewStateFR2(
            //  viewStateFR2 = WizardCache
                country = country,
//                city = city,
//                address = address,

            )
        }
    }

     fun cancelCoroutineScope() = runBlocking {
            coroutineScope {
                val goToInet = AddressServiceModule().retrofitService()
                val a = goToInet.getAddressAnswer()
            }
    }

    fun setCountry(value: String) {
        if (value == cache.country) return
        cache.country = value
        renderView()
    }

//    fun setCity(value: String) {
//        if (value == cache.city) return
//        cache.city = value
//        renderView()
//    }
//
//    fun setAddress(value: String) {
//        if (value == cache.address) return
//        cache.address = value
//        renderView()
//    }

}