package ru.otus.basicarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import ru.otus.WizardCache
import ru.otus.basicarchitecture.viewState.viewStateFR2
import ru.otus.basicarchitecture.viewState.viewStateFR3

open class viewModelFR3 @JvmOverloads constructor(val cache: WizardCache = WizardCache.Impl): ViewModel() {

    val _stateFR3: MutableLiveData<viewStateFR3> = MutableLiveData<viewStateFR3>(  //хранит состояние (viewModel)
        viewStateFR3() // Начальное значение
    )

    val viewState: LiveData<viewStateFR3> get() = _stateFR3.distinctUntilChanged()

    private fun renderView() {   //обновлялка viewState (синхронизация с WizardCache)
        _stateFR3.value = with(cache.data) {
            viewStateFR3(
                //  viewStateFR2 = WizardCache
                  teg1 = teg1,
                  teg2 = teg2,
                  teg3 = teg3,
                  teg4 = teg4,
                  teg5 = teg5,
                  teg6 = teg5,
                  teg7 = teg7,
                  teg8 = teg8,


                )
        }
    }

    fun setTeg1(value: Boolean) {
        if (!value) return
        //
        cache.data = cache.data.copy(teg1 = true)   //
        renderView()
    }

    fun setTeg2(value: Boolean) {
        if (!value) return
        //
        cache.data = cache.data.copy(teg2 = true)   //
        renderView()
    }

    fun setTeg3(value: Boolean) {
        if (!value) return
        //
        cache.data = cache.data.copy(teg3 = true)   //
        renderView()
    }

    fun setTeg4(value: Boolean) {
        if (value) return
        //
        cache.data = cache.data.copy(teg4 = true)   //
        renderView()
    }

    fun setTeg5(value: Boolean) {
        if (value) return
        //
        cache.data = cache.data.copy(teg5 = true)   //
        renderView()
    }

    fun setTeg6(value: Boolean) {
        if (value) return
        //
        cache.data = cache.data.copy(teg6 = true)   //
        renderView()
    }

    fun setTeg7(value: Boolean) {
        if (value) return
        //
        cache.data = cache.data.copy(teg7 = true)   //
        renderView()
    }

    fun setTeg8(value: Boolean) {
        if (value) return
        //
        cache.data = cache.data.copy(teg8 = true)   //
        renderView()
    }

}