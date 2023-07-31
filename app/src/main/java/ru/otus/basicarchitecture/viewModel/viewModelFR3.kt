package ru.otus.basicarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import ru.otus.WizardCache
import ru.otus.basicarchitecture.viewState.viewStateFR2
import ru.otus.basicarchitecture.viewState.viewStateFR3

open class viewModelFR3@JvmOverloads constructor(val cache: WizardCache = WizardCache.Impl): ViewModel() {

    val _stateFR3: MutableLiveData<viewStateFR3> = MutableLiveData<viewStateFR3>(  //хранит состояние (viewModel)
        viewStateFR3() // Начальное значение
    )

    val viewState: LiveData<viewStateFR3> get() = _stateFR3.distinctUntilChanged()

}