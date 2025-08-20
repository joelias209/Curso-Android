package com.joelias.horoscapp.domain

import com.joelias.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}