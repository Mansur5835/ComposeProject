package com.example.firstjcomposeproject

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


val coroutineScope = CoroutineScope(Dispatchers.IO)

suspend fun main() {
    val state = MutableStateFlow(-100)
    val shared = MutableSharedFlow<Int>()


    val job1 = coroutineScope.launch {
        println("job1 start")
        delay(1000)
        println("job1 end")

        repeat(10) {
            state.emit(it)
            shared.emit(it)
        }
    }


    val job2 = coroutineScope.launch {
        state
            .collect {
                println("State $it")
            }



    }

    val job3 = coroutineScope.launch {
        shared
            .collect {
                println("Shared $it")
            }
    }



    job1.join()
    job2.join()
    job3.join()


    val flow = flowBuilder()



    coroutineScope.launch {
        flow.catch {  }.collect {  }
    }

}


fun flowBuilder(): Flow<Int> {
    return flow {
        repeat(10) {
            println("Emited it $it")
            emit(it)
            delay(200)
        }
    }
}