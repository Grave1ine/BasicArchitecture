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
    var teg1: Boolean = false,
    var teg2: Boolean = false,
    var teg3: Boolean = false,
    var teg4: Boolean = false,
    var teg5: Boolean = false,
    var teg6: Boolean = false,
    var teg7: Boolean = false,
    var teg8: Boolean = false,

)