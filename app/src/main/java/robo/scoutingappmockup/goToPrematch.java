package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class goToPrematch extends Activity {

    // Input fields
    private EditText scoutNameText;
    private CheckBox noShowBox;

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
