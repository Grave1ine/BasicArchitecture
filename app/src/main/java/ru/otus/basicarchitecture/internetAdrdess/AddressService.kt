package ru.otus.basicarchitecture.internetAdrdess

import retrofit2.http.Body
import retrofit2.http.GET

interface AddressService {
    @GET("suggestions/api/4_1/rs/suggest/address")
    suspend fun getAddressAnswer(@Body query: Query): List<AddressAnswer>     //почему @Body?
    abstract fun getAddressAnswer(): List<AddressAnswer>
}
//POST   постоянная часть ссылки - https://suggestions.dadata.ru
// переменная часть ссылки указывается в аннотации - /suggestions/api/4_1/rs/suggest/address
//не ясно использовать GET или POST