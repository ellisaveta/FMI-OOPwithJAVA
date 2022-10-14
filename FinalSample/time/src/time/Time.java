package time;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Time implements Serializable {
    private int timeZone;
    private int hours;
    private int minutes;
    private int seconds;

    public Time(){
        new Time(0, 0, 0, 0);
    }

    public Time(int timeZone, int hours, int minutes, int seconds) {
        setTimeZone(timeZone);
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public Time(Time T){
        setTimeZone(T.timeZone);
        setHours(T.hours);
        setMinutes(T.minutes);
        setSeconds(T.seconds);
    }

    public void setTimeZone(int timeZone) {
        if(timeZone > 13 || timeZone < -12)
            this.timeZone = 0;
        else
            this.timeZone = timeZone;
    }

    public void setHours(int hours) {
        this.hours = Math.min(hours, 23);
    }

    public void setMinutes(int minutes) {
        this.minutes = Math.min(minutes, 59);
    }

    public void setSeconds(int seconds) {
        this.seconds = Math.min(seconds, 59);
    }

    public int getTimeZone() {
        return timeZone;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setTime(Time T){
        if(T == null) return;

        setTimeZone(T.getTimeZone());
        setHours(T.getHours());
        setMinutes(T.getMinutes());
        setSeconds(T.getSeconds());
    }

    public Time getTime(){
        return new Time(this);
    }

    public void tickSeconds(){
        if(seconds < 59){
            seconds++;
        }
        else{
            seconds = 0;
            if(minutes < 59){
                minutes++;
            }
            else{
                minutes = 0;
                if(hours < 23)
                    hours++;
                else
                    hours = 0;
            }
        }
    }

    public void setCurrentTime(){
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        setHours(gregorianCalendar.getTime().getHours());
        setMinutes(gregorianCalendar.getTime().getMinutes());
        setSeconds(gregorianCalendar.getTime().getSeconds());
    }

    @Override
    public String toString() {
        if(timeZone >= 0)
            return String.format("%02d:%02d:%02d TZ:+%02d", hours, minutes, seconds, timeZone);
        else
            return String.format("%02d:%02d:%02d TZ:-%02d", hours, minutes, seconds, timeZone);
    }

    public static void main(String[] args) {
        Time t1 = new Time(10, 23, 59, 59);
        Time t2 = new Time(t1);
        //t2.setTime(t1);

        t2.setCurrentTime();
        t1.tickSeconds();

        System.out.println(t1);
        System.out.println(t2);
    }
}
