public class Time {
    // Time consist of hours, minutes and seconds. These variables are private to prevent direct modification.
    private int hour, minute, second;

    public Time(){
        // Default constructor. If this is initialised it'll generate 00:00:00
        hour = 0;
        minute = 0;
        second = 0;
    }

    public Time(int hour, int minute, int second){
        // Our overloaded constructor, this takes an integer for each variable
        setHour(hour);
        setMinute(minute);
        setSecond(second);

    }
    // Mutators are used to modify the existing time variables
    public void setHour(int hour){
        if (this.hour < 0 || this.hour > 23) {
            this.hour = 0;
        }
        else {
            this.hour = hour;
        }
    }
    public void setMinute(int minute){
        if (this.minute < 0 || this.minute > 59) {
            this.minute = 0;
        }
        else {
            this.minute = minute;
        }
    }
    public void setSecond(int second){
        if (this.second < 0 || second > 59) {
            this.second = 0;
        }
        else {
            this.second = second;
        }
    }
    // Accessors are used to display the variables safely
    public int getHour(){return hour;}
    public int getMinute(){return minute;}
    public int getSecond(){return second;}

    public void getTime(){
        // This accessor is used to manipulate the time variables to display time in HH:MM:SS
        var hours = getHour();
        var minutes = getMinute();
        var seconds = getSecond();
        String formatTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        System.out.println(formatTime);
    }
}
