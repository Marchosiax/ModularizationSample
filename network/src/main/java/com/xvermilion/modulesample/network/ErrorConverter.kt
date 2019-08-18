package com.xvermilion.modulesample.network

import com.xvermilion.modulesample.network.model.BaseResponse
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.IOException
import java.net.ConnectException
import java.net.UnknownHostException

class ErrorConverter(private val converter: Converter<ResponseBody, BaseResponse>) {

    fun <T : BaseResponse> getErrorBody(body: ResponseBody, ret: T): T {
        return try {
            val br = converter.convert(body) as BaseResponse
            ret.message = br.message
            if ("Service Unavailable. Please try after sometime" == br.message) {
                ret.status = 503
                ret.message = "Service unavailable"
            } else {
                ret.status = br.status
                ret.error = br.error
            }
            ret
        } catch (e: IOException) {
            getErrorBody(e, ret)
        }

    }

    fun <T : BaseResponse> getErrorBody(e: Throwable, ret: T): T {
        when (e) {
            is ConnectException -> {
                ret.status = 500
                ret.error = "-2"
                ret.message = "Connection Error"
                return ret
            }
            is CustomException -> {
                ret.status = e.status
                ret.error = e.error
                ret.message = e.message
                return ret
            }
            else -> {
                ret.status = -1
                ret.error = e.message
                return ret
            }
        }
    }

    fun getError(body: ResponseBody): Throwable {
        try {
            val error = converter.convert(body)
            if ("Service Unavailable. Please try after sometime" == error?.message) {
                error.status = 503
                error.message = "Service unavailable"
            }
            if (error?.status == 0)
                error.status = 500
            return CustomException(error?.status!!, error.error, error.message)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return Throwable("Unexpected Error")
    }

    fun getCustomError(e: Throwable): CustomException {
        return if (e is ConnectException || e is UnknownHostException) {
            CustomException(500, "-2", "Connection error")
        } else if (e is CustomException) {
            e as CustomException
        } else {
            CustomException(500, "-1", e.message)
        }
    }

    fun getError(status: Int, body: ResponseBody): Throwable {
        try {
            val error = converter.convert(body)
            if ("Service Unavailable. Please try after sometime" == error?.message) {
                error.message = "Service unavailable"
            }
            error?.status = status
            return CustomException(error?.status!!, error.error, error.message)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return Throwable("Unexpected Error")
    }

}