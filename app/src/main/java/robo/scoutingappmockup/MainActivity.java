package robo.scoutingappmockup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Calls activity to go to prematch pages
    // This activity is automatically called when the app is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent initPrematch = new Intent(this, goToPrematch.class);
        startActivity(initPrematch);
    }
}