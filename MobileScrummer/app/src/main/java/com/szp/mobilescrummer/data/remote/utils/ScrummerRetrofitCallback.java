package com.szp.mobilescrummer.data.remote.utils;

import android.util.Log;

import com.szp.mobilescrummer.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ScrummerRetrofitCallback<T> implements Callback<T> {
    public ScrummerRetrofitCallback(IToastCallback toastCallback) {
        this.toastCallback = toastCallback;
    }

    private IToastCallback toastCallback;
    protected abstract void onPositiveResponse(T response);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (!response.isSuccessful()) {
            Log.e(getClass().getName(), call.request().body().toString() + " IS NOT SUCCESSFUL!");
            toastCallback.makeToast(R.string.rest_request_failure_default_message);
            return;
        }
        onPositiveResponse(response.body());
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e(getClass().getName(), call.request().body().toString() + " FAILURE!", t);
        toastCallback.makeToast(R.string.rest_request_failure_default_message);
    }
}
