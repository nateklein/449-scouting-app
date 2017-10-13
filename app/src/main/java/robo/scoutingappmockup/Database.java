package robo.scoutingappmockup;

/*
 * Database is a class that stores all data being collected.
 *
 * Used for preventing data loss between page flips and for submission.
 *
 * Created by Nate on 10/10/2017.
 */

public class Database {

    // All data being collected
    public String scoutName;
    public int matchNumber;
    public int teamNumber;
    public boolean noShow;
    public boolean noAuto;
    public boolean movedForward;
    public int autoGear;
    public int autoLowFuel;
    public int autoHighFuel;
    public int teleopGears;
    public int teleopHighFuel;
    public int teleopLowFuel;
    public int dead;
    public boolean achievedNothing;
    public int climb;
    public int catchTime;
    public int climbTime;
    public String comment;

    // Default entries
    public Database() {
        scoutName = "";
        matchNumber = 0;
        teamNumber = 0;
        noShow = false;
        noAuto = false;
        movedForward = false;
        autoGear = 0;
        autoLowFuel = 0;
        autoHighFuel = 0;
        teleopGears = 0;
        teleopHighFuel = 0;
        teleopLowFuel = 0;
        dead = 0;
        achievedNothing = false;
        climb = 0;
        catchTime = 0;
        climbTime = 0;
        comment = "";
    }
}
