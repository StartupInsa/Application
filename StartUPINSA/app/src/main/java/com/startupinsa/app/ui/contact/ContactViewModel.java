package com.startupinsa.app.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by robin, on 27/11/20 at 21:06.
 * For the StartUP'INSA project.
 */
public class ContactViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ContactViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is contact fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
