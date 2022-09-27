package net.simplifiedcoding.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject


class RemoteDataSource @Inject constructor() {

    companion object {
        private const val BASE_URL = "https://restful-booker.herokuapp.com/"
    }

    fun <Api> buildApi(
        api: Class<Api>,
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}