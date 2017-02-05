package com.example.trishlapokharna.steamfish2017;
import com.trishlapokharna.android.R;
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
        highGoals2 = (TextView) findViewById(R.id.highGoalDisplay1);
        consistencyH2 = (TextView) findViewById(R.id.highGoalConsistencyDisplay1);
        lowGoals2 = (TextView) findViewById(R.id.lowGoalDisplay1);
        consistencyL2 = (TextView) findViewById(R.id.lowGoalConsistencyDisplay1);

        notes = (TextView) findViewById(R.id.notesDisplay);
        reachedPressure = (TextView) findViewById (R.id.pressureDisplay);
        takeOff = (TextView) findViewById(R.id.takeoffDisplay);
        result = (TextView) findViewById(R.id.resultDisplay);
        totalPoints = (TextView) findViewById(R.id.totalPointsDisplay);

        Bundle bundle = new Bundle();
        final String name = bundle.getString("a");
        matchD.setText(name);

        RoboInfo confirm = RoboInfo.getInstance();
        matchD.setText(Autonomous.matchText.getText().toString());
        teamD.setText(Autonomous.teamText.getText().toString());
        scouterD.setText(Autonomous.scouterText.getText().toString());
        baseline.setText(Autonomous.baseLineButton.getText().toString());
        gears.setText(Autonomous.gearsView.getText().toString());
        highGoals.setText(Autonomous.highGoalView.getText().toString());
        consistencyH.setText(Autonomous.b.getSelectedItem().toString());
        lowGoals.setText(Autonomous.lowGoalView.getText().toString());
        consistencyL.setText(Autonomous.d.getSelectedItem().toString());

        offenseOrDefense.setText(Teleop.offenseOrDefense.getText().toString());
        gears2.setText(Teleop.gearsView.getText().toString());
        cycleTime.setText(Teleop.fastOrSlow.getText().toString());
        highGoals2.setText(Teleop.highGoalsView.getText().toString());
        consistencyH2.setText(Teleop.a.getSelectedItem().toString());
        lowGoals2.setText(Teleop.lowGoalView.getText().toString());
        consistencyL2.setText(Teleop.b.getSelectedItem().toString());

        notes.setText(PostMatch.notesText.getText().toString());
        reachedPressure.setText(PostMatch.reach.getText().toString());
        takeOff.setText(PostMatch.takeoff.getText().toString());
        // result.setText(PostMatch.);   WHER IS THE RESULT
        totalPoints.setText(PostMatch.totalPoints.getText().toString());


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    // write text to file
    public void Export(View v) {
        try {
            verifyStoragePermissions(this);
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            // if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(root, "r2.txt");  // file path to save
            FileWriter writer = new FileWriter(filepath, true);
        public void Export (View v){
            try {
                verifyStoragePermissions(this);
                File root = new File(Environment.getExternalStorageDirectory(), "Notes");
                // if external memory exists and folder with name Notes
                if (!root.exists()) {
                    root.mkdirs(); // this will create folder.
                }
                File filepath = new File(root, "r2.txt");  // file path to save
                FileWriter writer = new FileWriter(filepath, true);
                if (filepath.length() != 0) {
                    writer.append("\n");
                }
                writer.append("Team Number, " + Autonomous.teamText.getText().toString() + "\n");
                writer.append("Match Number, " + Autonomous.matchText.getText().toString() + "\n");
                writer.append("Scouter Name, " + Autonomous.scouterText.getText().toString() + "\n");
                writer.append("Baseline, " + getTf(Autonomous.baseLineButton.getText().toString() + "\n "));
                writer.append("Auto Gears, " + Autonomous.gearsView.getText().toString() + "\n");
                writer.append("Auto High Goal, " + Autonomous.highGoalView.getText().toString() + "\n");
                writer.append("Consistency for Auto High Goals, " + getAb(Autonomous.b.getSelectedItem().toString()) + "\n");
                writer.append("Auto Low Goal, " + Autonomous.lowGoalView.getText().toString() + "\n");
                writer.append("Consistency for Auto Low Goals, " + Autonomous.d.getSelectedItem().toString() + "\n");
                writer.append("Offense or Defense, " + getTf(Teleop.offenseOrDefense.getText().toString()) + "\n");
                writer.append("Teleop Gears, " + Teleop.gearsView.getText().toString() + "\n");
                writer.append("Cycle Time, " + Teleop.fastOrSlow.getText().toString() + "\n");
                writer.append("Teleop High Goal, " + Teleop.highGoalsView.getText().toString() + "\n");
                writer.append("Consistency for Teleop High Goal, " + getAb(Teleop.a.getSelectedItem().toString()) + "\n");
                writer.append("Teleop Low Goal, " + Teleop.lowGoalView.getText().toString() + "\n");
                writer.append("Consistency for Teleop Low Goal, " + getAb(Teleop.b.getSelectedItem().toString()) + "\n");
                writer.append("Reached Pressure, " + getAb(PostMatch.reach.getText().toString()) + "\n");
                writer.append("Takeoff, " + getAb(PostMatch.takeoff.getText().toString()) + "\n");
                writer.append("Total Points, " + PostMatch.totalPoints.getText().toString() + "\n");
                writer.append("End Game, " + myRobo.getEndGameT());
                writer.append("\n");
                writer.append("Result, " + myRobo.getResult().toString() + "\n");
                writer.append("Notes, " + PostMatch.notesText.getText().toString());
                writer.flush();
                writer.close();
                Toast.makeText(getBaseContext(), "File updated!", Toast.LENGTH_SHORT).show();
                Intent toHome = new Intent(this, MainActivity.class);
                startActivity(toHome);

            } catch (IOException e) {
                e.printStackTrace();
                Log.d("file error", "" + e.getMessage());
            }


        }


        }


    }

    public String getTf(String str) {
        switch (str) {
            case "Yes":
                return "True";
            case "No":
                return "False";
            default:
                return " ";
        }
    }

    public String getAb(String str) {
        switch (str) {
            case "None":
                return "None";
            case "Very Little":
                return "Very Little";
            case "Some":
                return "Some";
            case "Most":
                return "Most";
            case "All":
                return "All";
            default:
                return " ";
        }
    }
}

