package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class goToEndgame extends Activity {

    // Displays endgame page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame_page);
    }

    // Calls activity to go to teleop page
    public void toTeleop(View v) {
        Intent toTeleop = new Intent(this, goToTeleop.class);
        startActivity(toTeleop);
    }

    // Calls activity to submit
    public void submit(View v) {
        Intent submit = new Intent(this, submit.class);
        startActivity(submit);
    }
}
