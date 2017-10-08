package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class goToTeleop extends Activity {

    // Displays teleop page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_page);
    }

    // Calls activity to go to auto page
    public void toAuto(View v) {
        Intent toAuto = new Intent(this, goToAuto.class);
        startActivity(toAuto);
    }

    // Calls activity to go to endgame page
    public void toEndgame(View v) {
        Intent toEndgame = new Intent(this, goToEndgame.class);
        startActivity(toEndgame);
    }
}
