package robo.scoutingappframe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class goToEndgame extends Activity {

    // Input fields

    // Displays endgame page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame_page);
        // Create and set data trackers to their Database values
    }

    // Calls activity to go to teleop page
    public void toTeleop(View v) {
        // Save values to Database
        // Switches pages
        Intent toTeleop = new Intent(this, goToTeleop.class);
        startActivity(toTeleop);
    }

    // Calls activity to submit
    public void submit(View v) {
        // Save values to Database
        Intent submit = new Intent(this, submit.class);
        startActivity(submit);
    }
}
