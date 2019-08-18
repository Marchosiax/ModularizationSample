package com.xvermilion.modulesample.network

import com.xvermilion.modulesample.library.NetworkResponse
import com.xvermilion.modulesample.network.model.BaseResponse
import retrofit2.Response

fun <T> Response<T>.ifSuccessful(action: (T) -> Unit): Response<T> {
    if (isSuccessful || (body() is BaseResponse && (body() as BaseResponse).isSuccessful()))
        body()?.let { action(it) }
    return this
}

fun <T> Response<T>.handleResponse(
    errorConverter: ErrorConverter,
    networkResponse: NetworkResponse<*>,
    action: (T) -> Unit
): Response<T> {
    if (isSuccessful || (body() is BaseResponse && (body() as BaseResponse).isSuccessful()))
        body()?.let { action(it) }
    else {
        errorBody()?.let {
            val e = errorConverter.getErrorBody(it, BaseResponse())
            networkResponse.failed(e.status, e.error, e.message)
        }
    }
    return this
}

fun <T> Response<T>.ifFailed(
    errorConverter: ErrorConverter? = null,
    action: (BaseResponse?) -> Unit
): Response<T> {
    if (!isSuccessful || (body() is BaseResponse && !(body() as BaseResponse).isSuccessful()))
        errorBody()?.let { action(errorConverter?.getErrorBody(it, BaseResponse())) }
    return this
}

fun <T> Response<T>.ifFailedCaptureError(
    errorConverter: ErrorConverter,
    networkResponse: NetworkResponse<*>
): Response<T> {
    if (!isSuccessful || (body() is BaseResponse && !(body() as BaseResponse).isSuccessful()))
        errorBody()?.let {
            val e = errorConverter.getErrorBody(it, BaseResponse())
            networkResponse.failed(e.status, e.error, e.message)
        }
    return this
}