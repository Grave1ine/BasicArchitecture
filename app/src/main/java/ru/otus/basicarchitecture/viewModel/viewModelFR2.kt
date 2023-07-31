package ru.otus.basicarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import ru.otus.WizardCache
import ru.otus.basicarchitecture.viewState.viewStateFR1
import ru.otus.basicarchitecture.viewState.viewStateFR2

open class viewModelFR2 @JvmOverloads constructor(val cache: WizardCache = WizardCache.Impl): ViewModel() {

    val _stateFR2: MutableLiveData<viewStateFR2> = MutableLiveData<viewStateFR2>(  //хранит состояние (viewModel)
        viewStateFR2() // Начальное значение
    ) //для обращений внурти (тут)

    val viewState: LiveData<viewStateFR2> get() = _stateFR2.distinctUntilChanged()  //в фрагментах/активити использовать это поле для обращения к состоянию
    //для обращений снаружи(ativity/frahment)

    private fun renderView() {   //обновлялка viewState (синхронизация с WizardCache)
        _stateFR2.value = with(cache.data) {
            viewStateFR2(
            //  viewStateFR2 = WizardCache
                country = country,
                city = city,
                address = address,

            )
        }
    }

    fun setCountry(value: String) {
        if (value == cache.data.country) return
        cache.data = cache.data.copy(country = value)
        renderView()
    }

    fun setCity(value: String) {
        if (value == cache.data.city) return
        cache.data = cache.data.copy(city = value)
        renderView()
    }

    fun setAddress(value: String) {
        if (value == cache.data.address) return
        cache.data = cache.data.copy(address = value)
        renderView()
    }

}