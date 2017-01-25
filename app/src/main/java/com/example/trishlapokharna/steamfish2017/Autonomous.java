package com.example.trishlapokharna.steamfish2017;
//CODE ALL THE SPINNER STUFF
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
import android.view.View.OnClickListener;
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

import java.util.ArrayList;
import java.util.List;

//part 1 of input activity
public class Autonomous extends Fragment  {

    RoboInfo myRobo = RoboInfo.getInstance();
    String matchT;
    String teamT;


    Button gearHit;
    Button gearMiss;
    Button gearDelete;

    Button addFive1;
    Button addTen1;
    Button addTwenty1;

    Button addFive2;
    Button addTen2;
    Button addTwenty2;

    int i;
    int j;

    TextView highView;
    TextView lowView;
    TextView gearsView;

    TextView gearTextView;
    TextView highGoalView;

    Button submit;

    static EditText matchText;
    static EditText teamText;
    static EditText scouterText;
    static ToggleButton baseLineButton;
    static TextView highGoal;
    static TextView lowGoal;
    static TextView baselineText;

    
    static Spinner b;
    static Spinner d;

   private RoboInfo autoInfo = new RoboInfo();

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_autonomous, container, false); // adds Autonomous tab to input activity



        // 2/17 Heher revisions
        matchText = (EditText)in.findViewById(R.id.matchNumberEdit);
        teamText = (EditText)in.findViewById(R.id.teamNumberEdit);
        scouterText = (EditText)in.findViewById(R.id.scouterNameEdit);
        baseLineButton = (ToggleButton) in.findViewById(R.id.baselineToggleButton);
        highGoal = (TextView) in.findViewById(R.id.highGoalTextView);
        lowGoal = (TextView) in.findViewById(R.id.lowGoalTextView);
        gearsView = (TextView) in.findViewById(R.id.gearTextView);
        baselineText = (TextView) in.findViewById(R.id.baselineTextView);
        gearTextView = (TextView) in.findViewById(R.id.gearTextView);
        highGoalView = (TextView) in.findViewById (R.id.highGoalView);

        i = 0;
        j = 0;





        //set up radiogroup-like behaviors for toggle buttons

        gearHit = (Button) in.findViewById(R.id.gearHitButton);
        gearMiss = (Button) in.findViewById(R.id.gearMissButton);
        gearDelete = (Button) in.findViewById(R.id.gearDeleteButton);

        addFive1 = (Button) in.findViewById(R.id.highGoalAddFive);
        addTen1 = (Button) in.findViewById(R.id.highGoalAddTen);
        addTwenty1 = (Button) in.findViewById(R.id.highGoalAddTwenty);

        addFive2 = (Button) in.findViewById(R.id.lowGoalAddFive);
        addTen2 = (Button) in.findViewById(R.id.lowGoalAddTen);
        addTwenty2 = (Button) in.findViewById(R.id.lowGoalAddTwenty);

        b = (Spinner) in.findViewById(R.id.spinnerB);
        d = (Spinner) in.findViewById(R.id.spinnerD);
        addItemsOnSpinnerB();
        addItemsOnSpinnerD();
/*
        b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Teleop.b.setText(Autonomous.b.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Teleop.d.setText(Autonomous.b.getSelectedItem().toString());
            }

        });

        d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Teleop.spinner2.setText(Autonomous.d.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Teleop.spinner2.setText(Autonomous.d.getSelectedItem().toString());
            }

        });



*/




        gearHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearTextView.append("1 ");
            }
        });

        gearMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearTextView.append("0 ");
            }
        });

        gearDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearTextView.getText().length() > 0) {
                    gearTextView.setText(gearTextView.getText().subSequence(0, gearTextView.getText().length() - 2));
                }
            }
        });






        addFive1.setOnClickListener(new View.OnClickListener() {
           public void onClick (View v){
                  i +=5;
                  highGoalView.setText(String.valueOf(i));
            }

         });
        addTen1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i +=10;
                highGoalView.setText(String.valueOf(i));
            }

        });
        addTwenty1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i +=20;
                highGoalView.setText(String.valueOf(i));
            }

        });



        addFive2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j +=5;

                highGoalView.setText(String.valueOf(j));
            }

        });
        addTen2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j+=10;
                highGoalView.setText(String.valueOf(j));
            }

        });
        addTwenty2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j+=20;
                highGoalView.setText(String.valueOf(j));
            }

        });











        // 2/17 revision
        matchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = matchText.getText().toString();
                myRobo.setMatchT(str);
            }
        });

        teamText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = teamText.getText().toString();
                myRobo.setTeamT(str);
            }
        });

        scouterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = scouterText.getText().toString();
                myRobo.setScouterT(str);
            }
        });

        return in;
    }



  /*  @Override
    public RoboInfo getData() {
        this.autoInfo.matchT = this.matchT; // Assuming subcon has been updated.. else use txt1.getText();
        return this.autoInfo;
    }

    @Override
    public void setData(RoboInfo workData) {
        this.autoInfo = workData;
        // Update this page's views with the workData...
        // This assumes the fragment has already been created and txt1 is set to a view
        this.matchT = workData.matchT; // Actually could just use subCon in workData, but be aware that workData actually points to the Activity's copy (kinda makes getdata redundant.. but I like symmetry and couldn't be bothered making lots of copies of the object).
    }

    public static Autonomous newInstance(String a)
    {
        Autonomous fragment=new Autonomous();
        Bundle bundle=new Bundle();
        bundle.putString("a", "matchText");
        fragment.setArguments(bundle);
        return fragment;
    }*/

    public void addItemsOnSpinnerB() {
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

    public void addItemsOnSpinnerD() {
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("None");
        categories.add("Very Little");
        categories.add("Some");
        categories.add("Most");
        categories.add("All");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        d.setAdapter(dataAdapter);
    }

}
