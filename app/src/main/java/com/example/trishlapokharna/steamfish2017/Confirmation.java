package com.example.trishlapokharna.steamfish2017;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by TrishlaPokharna on 1/23/17.
 */




public class Confirmation {
    TextView matchD;
    TextView teamD;
    TextView scouterD;
    TextView baseline;
    TextView gears;
    TextView highGoals;
    TextView consistencyH;
    TextView lowGoals;
    TextView consistencyL;


    TextView offenseOrDefense;
    TextView gears2;
    TextView cycleTime;
    TextView highGoals2;
    TextView consistencyH2;
    TextView lowGoals2;
    TextView consistencyL2;

    TextView
    TextView notes;
    TextView reachedPressure;
    TextView takeOff;
    TextView result;
    TextView totalPoints;


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);

        matchD = (TextView) findViewById(R.id.matchNumberDisplay);
        teamD = (TextView) findViewById(R.id.teamNumberDisplay);
        scouterD = (TextView) findViewById(R.id.scouterNameDisplay);

        baseline = (TextView) findViewById(R.id.baselineDisplay);
        gears = (TextView) findViewById(R.id.gearsDisplay);
        highGoals = (TextView) findViewById(R.id.highGoalsDisplay);
        consistencyH = (TextView) findViewById(R.id.consistencyHighGoalDisplay);
        lowGoals = (TextView) findViewById(R.id.lowGoalDisplay);
        consistencyL = (TextView) findViewById(R.id.lowGoalConsistencyDisplay);

        offenseOrDefense = (TextView) findViewById(R.id.offenseOrDefenseDisplay1);
        gears2 = (TextView) findViewById(R.id.gearsDisplay2);
        cycleTime = (TextView) findViewById(R.id.cycleTimeDisplay1);
        highGoals2 = (TextView) findViewById (R.id.highGoalDisplay1);
        consistencyH2 = (TextView) findViewById (R.id.highGoalConsistencyDisplay1);
        lowGoals2 = (TextView) findViewById (R.id.lowGoalDisplay1);
        consistencyL2 = (TextView) findViewById (R.id.lowGoalConsistencyDisplay1);

        notes = (TextView) findViewById (R.id.notesDisplay);
        reachedPressure = (TextView) findViewById.(R.id.pressureDisplay);
        takeOff = (TextView) findViewById (R.id.takeoffDisplay);
        result = (TextView) findViewById (R.id.resultDisplay);
        totalPoints = (TextView) findViewById (R.id.totalPointsDisplay);

        Bundle bundle = new Bundle();
        final String name = bundle.getString("a");
        matchD.setText(name);

        RoboInfo confirm = RoboInfo.getInstance();





    }
