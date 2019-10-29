package com.example.a2019scouting.ui.browseEntrys;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.a2019scouting.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BrowseEntrysFragment extends Fragment {

    private BrowseEntrysViewModel browseEntrysViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        browseEntrysViewModel =
                ViewModelProviders.of(this).get(BrowseEntrysViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        final TextView mainView = root.findViewById(R.id.MainViewer);

        //region inits the reader and reads from the file.
        String in = readFromFile();



        browseEntrysViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mainView.setText(in);
            }
        });
        final Button button = root.findViewById(R.id.clear_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Context context = getContext();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("log.txt", Context.MODE_PRIVATE));
                    outputStreamWriter.close();
                }
                catch (FileNotFoundException e) {
                    Log.e("login activity", "File not found: " + e.toString());
                } catch (IOException e) {
                    Log.e("login activity", "Can not read file: " + e.toString());
                }
            }
        });



        return root;
    }
    public String readFromFile() {
        Context context = getContext();
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("log.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return ret;
    }
}