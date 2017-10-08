package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class goToAuto extends Activity {

    // Displays auto page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autonomous_page);
    }

    // Calls activity to go to teleop page
    public void toTeleop(View v) {
        Intent toTeleop = new Intent(this, goToTeleop.class);
        startActivity(toTeleop);
    }

    // Calls activity to go to prematch page
    public void toPrematch(View v) {
        Intent toPrematch = new Intent(this, goToPrematch.class);
        startActivity(toPrematch);
    }
}
