package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class goToPrematch extends Activity {

    // Displays prematch page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prematch_page);
    }

    // Calls activity to to auto page
    public void toAuto(View v) {
        Intent toAuto = new Intent(this, goToAuto.class);
        startActivity(toAuto);
    }
}