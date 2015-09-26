package com.example.diana.finalproject.events;

import retrofit.RetrofitError;

/**
 * The event that is posted when a network error event occurs.
 * TODO: Consume this event in the {@link com.example.diana.finalproject.ui.BootstrapActivity} and
 * show a dialog that something went wrong.
 */
public class NetworkErrorEvent {
    private RetrofitError cause;

    public NetworkErrorEvent(RetrofitError cause) {
        this.cause = cause;
    }

    public RetrofitError getCause() {
        return cause;
    }
}
