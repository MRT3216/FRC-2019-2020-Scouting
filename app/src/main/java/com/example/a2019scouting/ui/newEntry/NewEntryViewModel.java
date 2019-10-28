package com.example.a2019scouting.ui.newEntry;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewEntryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewEntryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ADD ENTRY ACTIVITY HERE" +
                "SoMETIMES\n" +
                "\n" +
                "God TaKes MOMMIES\n" +
                "\n" +
                "aNd PuPPIES AWAY…\n" +
                "\n" +
                "And SoMETIMES…\n" +
                "\n" +
                "Just SoMETIMES…\n" +
                "\n" +
                " I do.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}