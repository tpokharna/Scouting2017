package com.example.trishlapokharna.steamfish2017;
//CODE ALL THE SPINNER SHIT
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrishlaPokharna on 1/14/17.
 */
public class Teleop {
    RoboInfo myRobo = RoboInfo.getInstance();

    TextView offense;
    ToggleButton offenseOrDefense;

    TextView gears;
    TextView gearsView;

    Button one;
    Button zero;
    Button back;

    TextView cycleTime;
    ToggleButton fastOrSlow;

    TextView highGoals;
    TextView highGoalsView;
    Button five1;
    Button ten1;
    Button twenty1;
    int i;

    TextView consistency1;
    Spinner a;

    TextView lowGoals;
    TextView lowGoalView;
    Button five2;
    Button ten2;
    Button twenty2;
    int j;

    TextView consistency2;
    Spinner b;

    ToggleButton climbOrNone;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View in = inflater.inflate(R.layout.activity_teleop, container, false); // FIX THIS -- adds Autonomous tab to input activity
        offense = (TextView) in.findViewById(R.id.offenseTextView);
        offenseOrDefense = (ToggleButton) in.findViewById(R.id.offenseToggleButton);

        gears = (TextView) in.findViewById(R.id.gearTextView1);
        gearsView = (TextView) in.findViewById(R.id.gearView1);

        one = (Button) in.findViewById(R.id.gearHitButton);
        zero = (Button) in.findViewById(R.id.gearMissButton);
        back = (Button) in.findViewById(R.id.gearDeleteButton);

        cycleTime = (TextView) in.findViewById(R.id.cycleTimeTextView);
        fastOrSlow = (ToggleButton) in.findViewById(R.id.cycleTimeToggleButton);

        highGoals = (TextView) in.findViewById(R.id.highGoalTextView1);
        highGoalsView = (TextView) in.findViewById(R.id.highGoalView);
        five1 = (Button) in.findViewById(R.id.highGoalAddFive);
        ten1 = (Button) in.findViewById(R.id.highGoalAddTen);
        twenty1 = (Button) in.findViewById(R.id.highGoalAddTwenty);
        i = 0;
        //hello

        consistency1 = (TextView) in.findViewById(R.id.textView13);
        a = (Spinner) in.findViewById(R.id.spinnerD);
        addItemsOnSpinner1();

        lowGoals = (TextView) in.findViewById(R.id.lowGoalTextView);
        lowGoalView = (TextView) in.findViewById(R.id.lowGoalView2);
        five2 = (Button) in.findViewById(R.id.lowGoalAddFive);
        ten2 = (Button) in.findViewById(R.id.lowGoalAddTenButton);
        twenty2 = (Button) in.findViewById(R.id.lowGoalAddTwentyButton);
        j = 0;

        consistency2 = (TextView) in.findViewById(R.id.textView11);
        b = (Spinner) in.findViewById(R.id.spinnerB);
        addItemsOnSpinner2();

        climbOrNone = (ToggleButton) in.findViewById(R.id.takeOffToggleButton);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("1 ");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("0 ");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearsView.getText().length() > 0) {
                    gearsView.setText(gearsView.getText().subSequence(0, gearsView.getText().length() - 2));
                }
            }
        });


        five1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i += 5;
                highGoalsView.setText(String.valueOf(i));
            }

        });
        ten1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i += 10;
                highGoalsView.setText(String.valueOf(i));
            }

        });
        twenty1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i += 20;
                highGoalsView.setText(String.valueOf(i));
            }

        });


        five2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                j += 5;

                lowGoalView.setText(String.valueOf(j));
            }

        });
        ten2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                j += 10;
                lowGoalView.setText(String.valueOf(j));
            }

        });
        twenty2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                j += 20;
                lowGoalView.setText(String.valueOf(j));
            }

        });




}
    public void addItemsOnSpinner1() {
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("None");
        categories.add("Very Little");
        categories.add("Some");
        categories.add("Most");
        categories.add("All");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        a.setAdapter(dataAdapter);
    }


    public void addItemsOnSpinner2() {
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("None");
        categories.add("Very Little");
        categories.add("Some");
        categories.add("Most");
        categories.add("All");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        b.setAdapter(dataAdapter);
    }


}