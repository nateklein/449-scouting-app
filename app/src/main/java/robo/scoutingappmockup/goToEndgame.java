package robo.scoutingappmockup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class goToEndgame extends Activity {

    // Text fields
    private TextView climbTimeText;
    private TextView catchTimeText;

    // Input fields
    private SeekBar climbTime;
    private SeekBar catchTime;
    private RadioGroup climb;
    private EditText comments;
    // Displays endgame page on activity call
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame_page);
        climbTime = (SeekBar) findViewById(R.id.climbTime);
        climbTime.setProgress(MainActivity.db.climbTime);
        catchTime = (SeekBar) findViewById(R.id.catchTime);
        catchTime.setProgress(MainActivity.db.catchTime);
        climb = (RadioGroup) findViewById(R.id.climb);
        switch (MainActivity.db.climb) {
            case 0:
                climb.clearCheck();
                break;
            case 1:
                climb.check(R.id.climbNoAttempt);
                break;
            case 2:
                climb.check(R.id.climbSuccess);
                break;
            case 3:
                climb.check(R.id.climbFail);
                break;
        }
        comments = (EditText) findViewById(R.id.comments);
        comments.setText(MainActivity.db.comment);
    }

    // Calls activity to go to teleop page
    public void toTeleop(View v) {
        // Saves values to Database
        MainActivity.db.catchTime = catchTime.getProgress();
        MainActivity.db.climbTime = climbTime.getProgress();
        switch (climb.getCheckedRadioButtonId()) {
            case R.id.climbNoAttempt:
                MainActivity.db.climb = 1;
                break;
            case R.id.climbSuccess:
                MainActivity.db.climb = 2;
                break;
            case R.id.climbFail:
                MainActivity.db.climb = 3;
                break;
            default:
                MainActivity.db.climb = 0;
                break;
        }
        MainActivity.db.comment = comments.getText().toString();
        // Switches pages
        Intent toTeleop = new Intent(this, goToTeleop.class);
        startActivity(toTeleop);
    }

    // Calls activity to submit
    public void submit(View v) {
        Intent submit = new Intent(this, submit.class);
        startActivity(submit);
    }
}
