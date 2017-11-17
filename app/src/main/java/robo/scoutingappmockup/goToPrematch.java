package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class goToPrematch extends Activity implements AdapterView.OnItemSelectedListener{

    // Input fields
    private EditText scoutNameText;
    private CheckBox noShowBox;
    private Spinner teamNumber;
    private ArrayAdapter<CharSequence> teamAdapter;
    private Spinner matchNumber;
    private ArrayAdapter<CharSequence> matchAdapter;

    // Displays prematch page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prematch_page);
        // Creates and sets data trackers to Database values
        scoutNameText = (EditText) findViewById(R.id.scoutName);
        scoutNameText.setText(MainActivity.db.scoutName);
        noShowBox = (CheckBox) findViewById(R.id.noShow);
        noShowBox.setChecked(MainActivity.db.noShow);
        teamNumber = (Spinner) findViewById(R.id.teamNumber);
        teamAdapter = ArrayAdapter.createFromResource(this, R.array.teams, android.R.layout.simple_spinner_item);
        teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        teamNumber.setAdapter(teamAdapter);
        teamNumber.setOnItemSelectedListener(this);
        teamNumber.setSelection(MainActivity.db.teamNumber);
        matchNumber = (Spinner) findViewById(R.id.matchNumber);
        matchAdapter = ArrayAdapter.createFromResource(this, R.array.matches, android.R.layout.simple_spinner_item);
        matchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        matchNumber.setAdapter(matchAdapter);
        matchNumber.setOnItemSelectedListener(this);
        matchNumber.setSelection(MainActivity.db.matchNumber);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // Checks which dropdown was selected and changes the Database value accordingly
        if (parent.getId() == R.id.matchNumber) {
            MainActivity.db.matchNumber = pos;
        }
        else if (parent.getId() == R.id.teamNumber) {
            MainActivity.db.teamNumber = pos;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Checks which dropdown was selected and changes the Database value accordingly
        if (parent.getId() == R.id.matchNumber) {
            MainActivity.db.matchNumber = 0;
        }
        else if (parent.getId() == R.id.teamNumber) {
            MainActivity.db.teamNumber = 0;
        }
    }

    // Calls activity to go to auto page
    public void toAuto(View v) {
        // Saves values to Database
        MainActivity.db.scoutName = scoutNameText.getText().toString();
        MainActivity.db.noShow = noShowBox.isChecked();
        // Switches pages
        Intent toAuto = new Intent(this, goToAuto.class);
        startActivity(toAuto);
    }
}
