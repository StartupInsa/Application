package com.startupinsa.app.ui.estimate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by robin, on 27/11/20 at 22:30.
 * For the StartUP'INSA project.
 */
public class EstimateViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public EstimateViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is estimate fragment");
    }

    public LiveData<String> getText(){
        return mText;
    }
}
