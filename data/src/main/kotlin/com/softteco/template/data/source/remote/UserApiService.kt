package com.softteco.template.data.source.remote

import com.softteco.template.domain.model.user.ApiResponse
import com.softteco.template.domain.model.user.CreateUserDto
import com.softteco.template.domain.model.user.LoginAuthDto
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Service for user API
 */
interface UserApiService {

    /**
     * API Login
     */
    @POST("/login")
    suspend fun login(@Body userAuth: LoginAuthDto): ApiResponse<ResponseBody>

    /**
     * API Registration
     */
    @POST("/registration")
    suspend fun registration(@Body user: CreateUserDto): ApiResponse<ResponseBody>
}
