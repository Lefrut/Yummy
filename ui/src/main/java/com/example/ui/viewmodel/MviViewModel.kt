package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.debounce
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.Syntax
import org.orbitmvi.orbit.viewmodel.container

open class MviViewModel<STATE : Any, EFFECT : Any> constructor(state: STATE) : ViewModel(),
    ContainerHost<STATE, EFFECT> {

    override val container = container<STATE, EFFECT>(state)

    init {
        listenOpeations()
    }

    private val _operations = MutableSharedFlow<() -> Unit>(100)

    @OptIn(FlowPreview::class)
    fun listenOpeations() = intent {
        _operations.debounce(20).collect { block ->
            block()
        }
    }
}

suspend fun <S : Any, E : Any> Syntax<S, E>.reduceState(block: S.() -> S) {
    reduce {
        state.block()
    }
}



