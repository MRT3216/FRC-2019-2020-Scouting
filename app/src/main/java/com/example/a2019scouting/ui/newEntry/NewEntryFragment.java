package com.example.a2019scouting.ui.newEntry;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
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
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NewEntryFragment extends Fragment {

    private NewEntryViewModel newEntryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        String csv = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyCsvFile.csv");
        newEntryViewModel =
                ViewModelProviders.of(this).get(NewEntryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_slideshow, container, false);


        //region gets the EditText objects from the XML listeners so they can be called later
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
        //endregion

        final Button button = root.findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                //region inits strings from EditText objects
                String[] data = new String[20];
                data[0] = txtTeamName.getText().toString();
                data[1] = txtTeamNum.getText().toString();
                data[2] = spLevelStartedOn.getSelectedItem().toString();
                data[3] = txtHatchesPlacedSandstorm.getText().toString();
                data[4] = txtCargoPlacedSandstorm.getText().toString();
                data[5] = spAutonomousCamera.getSelectedItem().toString();
                data[6] = txtHatchesPlacedTeleop.getText().toString();
                data[7] = txtCargoPlacedTeleop.getText().toString();
                data[8] = txtRocketsFilled.getText().toString();
                data[9] = spStrategy.getSelectedItem().toString();
                data[10] = txtStrategyOther.getText().toString();
                data[11] = txtNotes.getText().toString();

                //endregion


                //region sets up the array we will pass to the writestream
                String[] toWrite = new String[20];

                for(int i = 0; i < 12; i++){
                    toWrite[i] = data[i];
                }


                //endregion


                //finally writes to the fucking file
                writeToFile(12,toWrite);

                //region clears the form after it's submitted
                clearText(txtTeamName);
                clearText(txtTeamNum);
                clearSpin(spLevelStartedOn);
                clearText(txtHatchesPlacedSandstorm);
                clearText(txtCargoPlacedSandstorm);
                clearSpin(spAutonomousCamera);
                clearText(txtHatchesPlacedTeleop);
                clearText(txtCargoPlacedTeleop);
                clearText(txtRocketsFilled);
                clearSpin(spStrategy);
                clearText(txtStrategyOther);
                clearText(txtNotes);
                //endregion


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

    public void writeToFile(int stillwrites, String[] data) {
        Context context = getContext();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("ass.txt", Context.MODE_PRIVATE));
            for (int i=1;i<=stillwrites;i++)
            {
                outputStreamWriter.write(data[i] + "|");
            }
            outputStreamWriter.write("\n");
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
            InputStream inputStream = context.openFileInput("ass.txt");

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

    public void clearText (EditText toClear)
    {
        toClear.getText().clear();
    }

    public void clearSpin (Spinner toClear)
    {
        toClear.setSelection(0);
    }



}