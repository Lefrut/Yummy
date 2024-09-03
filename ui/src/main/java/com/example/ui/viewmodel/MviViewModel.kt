package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.Syntax
import org.orbitmvi.orbit.viewmodel.container

open class MviViewModel<STATE : Any, EFFECT : Any> constructor(state: STATE) : ViewModel(),
    ContainerHost<STATE, EFFECT> {

    override val container = container<STATE, EFFECT>(state)
}

suspend fun <S : Any, E : Any> Syntax<S, E>.reduceState(block: S.() -> S) {
    reduce {
        state.block()
    }
}



