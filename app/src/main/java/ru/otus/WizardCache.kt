package ru.otus

import java.time.LocalDate

/**
 * Общие данные для всех экранов
 */
interface WizardCache {
    var data: WizardData

    /**
     * Потом переделать на хилт с ActivityRetainedScope
     */
    object Impl : WizardCache {
        // Начальное состояние
        override var data: WizardData = WizardData()
    }
}

/**
 * Общие данные
 */
data class WizardData(

//Fragment1
    val name: String = "",
    val surName: String= "",
    val bd: LocalDate? = null,

//*************************************

//Fragment2
    var country: String = "",
    var city: String = "",
    var address: String = "",

//*************************************

//Fragment3

)