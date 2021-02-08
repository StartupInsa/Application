package com.startupinsa.app.ui.achievements;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by robin, on 27/11/20 at 22:30.
 * For the StartUP'INSA project.
 */
public class AchievementsViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AchievementsViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is achievements fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
