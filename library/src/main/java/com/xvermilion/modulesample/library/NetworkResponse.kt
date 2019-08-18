package com.xvermilion.modulesample.library

class NetworkResponse<D> private constructor(
    var data: D? = null,
    var error: Error? = null,
    private var state: State = State.WAITING
) {

    companion object {
        fun <D> waiting() = NetworkResponse<D>()

        fun <D> successful(data: D?) = NetworkResponse(
            data,
            null,
            if (data != null) State.SUCCESSFUL else State.SUCCESS_NO_DATA
        )
    }

    fun succeeded(data: D? = null) {
        this.data = data
        state = if (data != null) State.SUCCESSFUL else State.SUCCESS_NO_DATA
    }

    fun failed(error: Throwable? = null, message: String? = null) {
        this.error = Error(
            throwable = error,
            message = message
        )
        state = State.FAILURE
    }

    fun failed(status: Int, error: String?, message: String? = null) {
        this.error = Error(
            status = status,
            error = error,
            message = message
        )
        state = State.FAILURE
    }

    fun onSuccess(action: (D?) -> Unit): NetworkResponse<D> {
        if (isSuccessful())
            action(data)
        return this
    }

    fun onFailure(action: (Error?) -> Unit): NetworkResponse<D> {
        if (isFailed())
            action(error)
        return this
    }

    fun empty() = EmptyBody()

    fun isWaiting() = state == State.WAITING

    fun isSuccessful() = state == State.SUCCESSFUL || state == State.SUCCESS_NO_DATA

    fun isFailed() = state == State.FAILURE

    data class Error(
        val status: Int = 0,
        val error: String? = null,
        val message: String? = null,
        val throwable: Throwable? = null
    )

    class EmptyBody

    enum class State {
        WAITING, SUCCESSFUL, SUCCESS_NO_DATA, FAILURE
    }
}

suspend fun <T> response(build: suspend NetworkResponse<T>.() -> Unit): NetworkResponse<T> {
    val response = NetworkResponse.waiting<T>()
    response.build()
    return response
}