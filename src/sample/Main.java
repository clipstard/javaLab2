package sample;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame {
    private static JFrame frame;
    public final static int WIDTH = 400;
    public final static int HEIGHT = 400;
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
        frame.setBounds(100, 100, WIDTH, HEIGHT);
    }
    public Main() {
        seconder = new TimeFactor(Constant.Time.SECOND);
        minuter = new TimeFactor(Constant.Time.MINUTE);
        hourer = new TimeFactor(Constant.Time.HOUR);

        zone = TimeZone.getDefault();
        TimerTask validate = new TimerTask() {
            @Override
            public void run() {
                //console.log("" + (int)(360 * Math.cos(seconder.getAngle())) + " " + (int)(360* Math.sin(seconder.getAngle())));
                repaint();
            }
        };
        Timer timer = new Timer();
        timer.schedule(validate, 0, Constant.Time.SECOND);
    }

    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        int centerX = WIDTH/2, centerY = HEIGHT/2;
        this.drawHours(g);
        this.drawArc(g, (int)Math.round(centerX * (150 * Math.cos(seconder.getAngle()))), (int)Math.round(centerY * (150* Math.sin(seconder.getAngle()))));
        this.drawArc(g, (int)Math.round(centerX * ( 150 * Math.cos(minuter.getAngle()))), (int)Math.round(centerY * ( 150 * Math.sin(minuter.getAngle()))), 3);
        this.drawArc(g, (int)Math.round(centerX * (90 * Math.cos(hourer.getAngle()))), (int)Math.round(centerY * (90 * Math.sin(hourer.getAngle()))),5);
    }

    private void drawHours(Graphics g)
    {
        Color prevColor = g.getColor();
        g.setColor(Color.WHITE);
        int centerX = WIDTH/2;
        int centerY = HEIGHT/2;

        for (int i = 0 ; i < 60; i+=5) {
            double minute =  (((i * Constant.Angle.SECOND * Math.PI)/180) - (Math.PI/2));
            int extX = centerX * (int)Math.round((150 * Math.cos(minute)));
            int extY = centerY * (int)Math.round(150 * Math.sin(minute));
            g.drawLine((int)(centerX + Math.round(150 * Math.cos(minute))), (int)(centerY + Math.round(150 * Math.sin(minute))), extX, extY);
            String str;
            if ( i == 0) str = "12";
            else str = "" + i/5;
            g.drawString(str, (int)(centerX + Math.round(130 * Math.cos(minute))), (int)(centerY + Math.round(130 * Math.sin(minute))));
        }
        g.setColor(prevColor);
    }

    private void drawArc(Graphics g, int x, int y)
    {
        Color prevColor = g.getColor();
        g.setColor(Color.RED);
        int centerX = WIDTH/2;
        int centerY = HEIGHT/2;

        g.drawLine(centerX, centerY, x, y);
        g.setColor(prevColor);
    }
    private void drawArc(Graphics g, int x, int y, int stroke)
    {
        Graphics2D g2 = (Graphics2D)g;
        Color prevColor = g2.getColor();
        g2.setColor(Color.ORANGE);
        int centerX = WIDTH/2;
        int centerY = HEIGHT/2;
        g2.setStroke(new BasicStroke(stroke));

        g2.drawLine(centerX, centerY, x, y);
        g2.setColor(prevColor);
        g2.setStroke(new BasicStroke(1));
    }
}

