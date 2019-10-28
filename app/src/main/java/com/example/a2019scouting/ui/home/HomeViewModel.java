package com.example.a2019scouting.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        //Set's the text for the home - screen
        mText.setValue("Welcome to the 2019 MRT3216 Scouting app!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}