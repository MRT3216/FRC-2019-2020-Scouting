package com.example.a2019scouting.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("TOOLS WE MIGHT WANT TO ADD - DELETE, RENAME, CHANGE OTHER FACOTRS" +
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