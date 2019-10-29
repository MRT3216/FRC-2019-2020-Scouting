package com.example.a2019scouting.ui.newEntry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewEntryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewEntryViewModel()
    {
        mText = new MutableLiveData<>();

    }

    public LiveData<String> getText() {
        return mText;
    }
}