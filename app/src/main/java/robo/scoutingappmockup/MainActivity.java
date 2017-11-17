package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    public static Database db;

    // Calls activity to go to prematch pages
    // and creates a Database object
    // This activity is automatically called when the app is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new Database();
        Intent initPrematch = new Intent(this, goToPrematch.class);
        startActivity(initPrematch);
    }
}
