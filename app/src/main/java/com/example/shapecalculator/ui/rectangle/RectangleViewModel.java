package com.example.shapecalculator.ui.rectangle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RectangleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RectangleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Enter Rectangle Values");
    }

    public LiveData<String> getText() {
        return mText;
    }
}