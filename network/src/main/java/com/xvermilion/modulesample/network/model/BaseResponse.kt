package com.xvermilion.modulesample.network.model

open class BaseResponse(var status: Int = 200, error: String? = null, var message: String? = null) {

    var error: String? = error
        set(value) {
            field = value
            error?.let {
                if (it.isNotEmpty() && status == -1)
                    status = 500
            }
        }

    open fun isSuccessful() = status == 200 || status == 0

    override fun toString() = "BaseResponse{status=$status, message=$message, error=$error}"
}