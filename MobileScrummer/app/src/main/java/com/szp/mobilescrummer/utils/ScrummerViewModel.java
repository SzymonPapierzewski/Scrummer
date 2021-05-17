package com.szp.mobilescrummer.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ScrummerViewModel extends AndroidViewModel {
    public ScrummerViewModel(@NonNull Application application) {
        super(application);
    }

    private MutableLiveData<Integer> toastMessage = new MutableLiveData<>();

    public MutableLiveData<Integer> getToastMessage() {
        return toastMessage;
    }

    public void displayToastMessage(Integer message) {
        if (message != null && message != 0) {
            toastMessage.setValue(message);
        }
    }
}
