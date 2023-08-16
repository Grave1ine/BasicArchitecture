package ru.otus.basicarchitecture.viewModel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import ru.otus.WizardCache
import ru.otus.basicarchitecture.internetAdrdess.AddressService
import ru.otus.basicarchitecture.internetAdrdess.AddressServiceModule
import ru.otus.basicarchitecture.internetAdrdess.Query
import ru.otus.basicarchitecture.viewState.viewStateFR2
import javax.inject.Inject


@HiltViewModel
open class viewModelFR2 @Inject constructor(private val cache: WizardCache): ViewModel() {

    val _stateFR2: MutableLiveData<viewStateFR2> =
        MutableLiveData<viewStateFR2>(  //хранит состояние (viewModel)
            viewStateFR2() // Начальное значение
        ) //для обращений внурти (тут)

    val viewState: LiveData<viewStateFR2> get() = _stateFR2.distinctUntilChanged()  //в фрагментах/активити использовать это поле для обращения к состоянию
    //для обращений снаружи(ativity/frahment)

    private fun renderView() {   //обновлялка viewState (синхронизация с WizardCache)
        _stateFR2.value = with(cache) {
            viewStateFR2(
                //  viewStateFR2 = WizardCache
                country = country,
                variantCountry = variantCountry,
//                city = city,
//                address = address,

                test = TEST
            )
        }
    }


    fun setCountry(value: String) {

        if (value == cache.country) return

        viewModelScope.launch() {
            val goToInet = AddressServiceModule().retrofitService()  //создание ретрофита
            val variantCountry =
                goToInet.getAddressAnswer(Query(value))    //передача в сеть введенного сдлова и получение (если есть чего)
            cache.variantCountry = variantCountry.body().toString()
            ////////////////////////////////////////////////

            //cache.TEST = variantCountry
            val a = variantCountry.body()?.suggestions
            if (a != null) {
                for (i in a) {
                    cache.TEST = i.value
                }


            }

            cache.country = value
            if (cache.country == "") {
                cache.variantCountry = ""
                cache.TEST = ""
            }

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
}