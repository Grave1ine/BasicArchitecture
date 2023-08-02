package ru.otus.basicarchitecture.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import ru.otus.WizardCache
import ru.otus.basicarchitecture.viewState.viewStateFR3

open class viewModelFR3 @JvmOverloads constructor(val cache: WizardCache = WizardCache.Impl): ViewModel() {

    val _stateFR3: MutableLiveData<viewStateFR3> = MutableLiveData<viewStateFR3>(  //хранит состояние (viewModel)
        viewStateFR3(cache.data.tags) // Начальное значение
    )

    val viewState: LiveData<viewStateFR3> get() = _stateFR3.distinctUntilChanged()

    private fun renderView() {   //обновлялка viewState (синхронизация с WizardCache)
        _stateFR3.value = with(cache.data) {
            viewStateFR3(tags)
        }
    }

    fun toggleTag(name: String) {
        val currentValue = cache.data.tags[name]
        if (null == currentValue) {
            // Проверяем, что идем по заданным тэгам, а не от балды
            return
        }
        // Меняем значение на противоположное
        cache.data = cache.data.copy(tags = cache.data.tags.plus(name to currentValue.not()))
        renderView()
    }
}