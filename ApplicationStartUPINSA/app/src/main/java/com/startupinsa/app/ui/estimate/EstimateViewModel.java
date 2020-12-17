package com.startupinsa.app.ui.estimate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EstimateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EstimateViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}