package com.example.shapecalculator.ui.triangle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TriangleViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TriangleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Enter Triangle Values");
    }

    public LiveData<String> getText() {
        return mText;
    }
}