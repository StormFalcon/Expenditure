package com.falcon.storm.expenditure;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Flyer on 14/12/14.
 */
public class Expenses implements Parcelable {

    public String date;
    public String day;
    public Double cost;
    public String remark;

    public Expenses(String date, String day, Double cost, String remark)
    {
        this.date = date;
        this.day = day;
        this.cost = cost;
        this.remark = remark;
    }

    public Expenses()
    {
        this.date = "15 Dec 2014";
        this.day = "Monday";
        this.cost = 12.34;
        this.remark = "Dummy data";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
