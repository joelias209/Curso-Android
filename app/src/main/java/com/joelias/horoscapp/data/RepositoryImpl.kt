package com.joelias.horoscapp.data

import android.util.Log
import com.joelias.horoscapp.data.network.HoroscopeApiService
import com.joelias.horoscapp.data.network.response.PredictionResponse
import com.joelias.horoscapp.domain.Repository
import com.joelias.horoscapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService):Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Joelias", "Ha ocurrido un error: ${it.message}") }
        return null
    }
}