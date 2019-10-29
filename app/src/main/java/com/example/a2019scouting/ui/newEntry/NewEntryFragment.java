package com.example.a2019scouting.ui.newEntry;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.a2019scouting.R;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NewEntryFragment extends Fragment {

    private NewEntryViewModel newEntryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newEntryViewModel =
                ViewModelProviders.of(this).get(NewEntryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_slideshow, container, false);


        final EditText txtTeamName = root.findViewById(R.id.team_name);
        final EditText txtTeamNum = root.findViewById(R.id.team_name);
        final Spinner spLevelStartedOn = root.findViewById(R.id.level_started_on);
        final EditText txtHatchesPlacedSandstorm = root.findViewById(R.id.hatches_placed_sandstorm);
        final EditText txtCargoPlacedSandstorm = root.findViewById(R.id.cargo_placed_sandstorm);
        final Spinner spAutonomousCamera = root.findViewById(R.id.autonomous_camera);
        final EditText txtHatchesPlacedTeleop = root.findViewById(R.id.hatches_placed_teleop);
        final EditText txtCargoPlacedTeleop = root.findViewById(R.id.cargo_placed_teleop);
        final EditText txtRocketsFilled = root.findViewById(R.id.rockets_filled);
        final Spinner spStrategy = root.findViewById(R.id.Strategy);
        final EditText txtStrategyOther = root.findViewById(R.id.strategy_other);
        final EditText txtNotes = root.findViewById(R.id.notes);

        final Button button = root.findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String teamName = txtTeamName.getText().toString();
                String teamNum = txtTeamNum.getText().toString();
                String levelStartedOn = spLevelStartedOn.getSelectedItem().toString();
                String hatchesPlacedSandstorm = txtHatchesPlacedSandstorm.getText().toString();
                String CargoPlacedSandstrom = txtCargoPlacedSandstorm.getText().toString();
                String authonomousCamera = spAutonomousCamera.getSelectedItem().toString();
                String hatchesPlacedTeleop = txtHatchesPlacedTeleop.getText().toString();
                String cargoPlacedteleop = txtCargoPlacedTeleop.getText().toString();
                String rocketsFilled = txtRocketsFilled.getText().toString();
                String strategy = spStrategy.getSelectedItem().toString();
                String strategyOther = txtStrategyOther.getText().toString();
                String notes = txtNotes.getText().toString();
                writeToFile();
                String read = readFromFile();
                System.out.println(read);
            }
        });


        /*
        final TextView textView = root.findViewById(R.id.button2);
        newEntryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

         */
        return root;
    }

    public void writeToFile() {
        Context context = getContext();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write("assssss");
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public String readFromFile() {
        Context context = getContext();
        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

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