package com.example.radgl.tryeventwrapper.ui.main

import android.arch.lifecycle.Observer

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<EventWrapper<T>> {
    override fun onChanged(event: EventWrapper<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}