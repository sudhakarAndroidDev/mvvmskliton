package net.simplifiedcoding.data.network


import net.simplifiedcoding.data.responses.HomeResponse
import net.simplifiedcoding.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi : BaseApi {

    @FormUrlEncoded
    @POST("auth")
    suspend fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): LoginResponse
    @GET("booking")
    suspend fun getBook() : HomeResponse
}