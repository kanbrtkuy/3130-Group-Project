package com.example.neoprojectver2.model;

public class TrainTime {
    private String username;
    private int hour;
    private int minute;

    public TrainTime() {

    }

    public TrainTime(String username, int hour, int minute) {
        this.username = username;
        this.hour = hour;
        this.minute = minute;

    }

    public String getUsername(){
        return username;
    }
    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }

    public boolean starttime(int h, int m){
        boolean temp = false;
        if (h == 8 && m > 30){
            return !temp;
        }
        else if(h >8){
            return !temp;
        }
        return temp;
    }

    public boolean endtime(int h, int m){
        boolean temp = false;
        if (h == 22 && m < 30){
            return !temp;
        }
        else if(h < 23){
            return !temp;
        }
        return temp;
    }

}

