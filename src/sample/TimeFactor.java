package sample;

import java.util.Calendar;

public class TimeFactor extends Thread{
    protected int factor;
    protected String voice = "";
    protected int currentSecond;
    protected int currentMinute;
    protected int currentHour;
    protected boolean running;
    protected Calendar cal;
    public TimeFactor(int factor)
    {
        this.cal = Calendar.getInstance();
        this.currentHour = this.cal.get(Calendar.HOUR);
        this.currentMinute = this.cal.get(Calendar.MINUTE);
        this.currentSecond = this.cal.get(Calendar.SECOND);
        this.running = true;
        this.factor = factor;
        this.start();
    }

    public int getFactor() {
        return factor;
    }

    public TimeFactor setFactor(int factor) {
        this.factor = factor;

        return this;
    }

    public TimeFactor setRunning(boolean running) {
        this.running = running;

        return this;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public double getAngle(){
        double seconds  =    ((this.currentSecond * Constant.Angle.SECOND * Math.PI)/180) - (Math.PI/2);
        double minutes  =    ((this.currentMinute * Constant.Angle.SECOND * Math.PI)/180) - (Math.PI/2);
        double hours    =    ((this.currentHour * Constant.Angle.MINUTE * Math.PI)/180) - (Math.PI/2);
        switch (this.factor) {
            case Constant.Time.SECOND:
                return seconds;
            case Constant.Time.MINUTE:
                return minutes;
            case Constant.Time.HOUR:
                return hours;
        }
        return 0;
    }

    public void run() {
        while(running) {
            try{
                sleep(factor);
            } catch( Exception e){}
            this.cal = Calendar.getInstance();
            this.currentHour = this.cal.get(Calendar.HOUR);
            this.currentMinute = this.cal.get(Calendar.MINUTE);
            this.currentSecond = this.cal.get(Calendar.SECOND);
        }
    }

}
