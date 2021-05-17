package com.szp.mobilescrummer.utils;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class EditTextToViewModelBinder implements TextWatcher {
    public abstract void onTextChange(String text);

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        onTextChange(s.toString());
    }
}
