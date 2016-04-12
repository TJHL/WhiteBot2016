package org.jointheleague.iaroc;

import android.os.SystemClock;

import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import org.wintrisstech.irobot.ioio.IRobotCreateAdapter;
import org.wintrisstech.irobot.ioio.IRobotCreateInterface;
import org.jointheleague.iaroc.sensors.UltraSonicSensors;

public class Brain extends IRobotCreateAdapter {
    private final Dashboard dashboard;
    public UltraSonicSensors sonar;

    public Brain(IOIO ioio, IRobotCreateInterface create, Dashboard dashboard)
            throws ConnectionLostException {
        super(create);
        sonar = new UltraSonicSensors(ioio);
        this.dashboard = dashboard;
    }

    /* This method is executed when the robot first starts up. */
    public void initialize() throws ConnectionLostException {
        dashboard.log("Hello! I'm a Clever Robot!");
        //what would you like me to do, Clever Human?
        int totalangel =90;
        while (totalangel> 0){

            driveDirect(500,-500);
            readSensors(SENSORS_ANGLE);ß
            int n  = getAngle();
           if(n>0)
               totalangel-=n;
            else
               totalangel+=n;
            dashboard.log("" +n);

        }

        //makesquare();



        driveDirect(0,0);



        dashboard.log("TEAM SMT");

    }

    private void makesquare() throws ConnectionLostException {
        for (int i=0;i< 4;i++) {

            driveDirect(500, 500);
            SystemClock.sleep(1000);
            driveDirect(-500, 500);
            SystemClock.sleep(430);
        }
        driveDirect(0,0);
    }

    /* This method is called repeatedly. */
    public void loop() throws ConnectionLostException {}


}