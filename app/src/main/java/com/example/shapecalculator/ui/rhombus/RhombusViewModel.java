package com.example.shapecalculator.ui.rhombus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RhombusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RhombusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}