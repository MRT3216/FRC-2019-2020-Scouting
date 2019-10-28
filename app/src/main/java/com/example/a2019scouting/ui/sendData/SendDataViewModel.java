package com.example.a2019scouting.ui.sendData;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendDataViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SendDataViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment" +
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