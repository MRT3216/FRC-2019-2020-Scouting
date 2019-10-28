package com.example.a2019scouting.ui.browseEntrys;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BrowseEntrysViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BrowseEntrysViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is browse fragment" +
                "\nSoMETIMES\n" +
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