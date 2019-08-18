package com.xvermilion.modulesample.network

import com.xvermilion.modulesample.network.model.BaseResponse

class CustomException(message: String?, cause: Throwable?) : RuntimeException(message, cause) {

    private val response = BaseResponse()

    val status: Int
        get() = response.status

    val error: String?
        get() = response.error

    override val message: String?
        get() = response.message

    constructor(status: Int, error: String?) : this(null, null) {
        response.status = status
        response.error = error
    }

    constructor(
        status: Int,
        error: String?,
        message: String?
    ) : this(message, null) {
        response.status = status
        response.error = error
        response.message = message
    }

    constructor(
        status: Int,
        error: String?,
        cause: Throwable?
    ) : this(null, cause) {
        response.status = status
        response.error = error
    }

}