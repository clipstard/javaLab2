package sample;

import javax.swing.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame {
    private static JFrame frame;
    private TimeFactor seconder;
    private TimeFactor minuter;
    private TimeFactor hourer;
    private Calendar cal;
    private TimeZone zone;


    public static void main(String[] args)
    {
        frame = new Main();
        frame.setTitle("Analog clock with 1 hour refresh");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public Main() {
        seconder = new TimeFactor(Constant.Time.SECOND);
        minuter = new TimeFactor(Constant.Time.MINUTE);
        hourer = new TimeFactor(Constant.Time.HOUR);

        zone = TimeZone.getDefault();
        TimerTask validate = new TimerTask() {
            @Override
            public void run() {
                console.log("" + (int)(150 * Math.cos(seconder.getAngle())) + " " + (int)(150* Math.sin(seconder.getAngle())));
            }
        };
        Timer timer = new Timer();
        timer.schedule(validate, Constant.Time.SECOND, Constant.Time.SECOND);
    }
}

