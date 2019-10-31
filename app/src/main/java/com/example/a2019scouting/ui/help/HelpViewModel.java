package com.example.a2019scouting.ui.help;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HelpViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Click on the new entry tab. Then, fill out all the data for that match. You will not be able to submit the round unless all information is filled out.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}