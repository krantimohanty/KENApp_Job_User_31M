package com.example.suchismita.essappleave.Model;

/**
 * Created by suchismita on 2/23/2017.
 */

public class ListModel {
    public  String date,event;

    public  ListModel(String date, String event)
    {
        this.date=date;
        this.event=event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
    public String toString() {
        return date + ":" + event;
    }
}
