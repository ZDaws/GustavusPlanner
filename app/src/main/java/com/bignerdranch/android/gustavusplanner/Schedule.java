package com.bignerdranch.android.gustavusplanner;

import java.util.Date;
import java.util.UUID;

public class Schedule {

    private String scheduleName;
    private UUID mId;
    private Date mDate;

    public Schedule() {
        this(UUID.randomUUID());
    }

    public Schedule (UUID id) {
        mId = id;
        mDate = new Date();
    }


    public String getName() {
        return scheduleName;
    }

    public void setName(String name) {
        scheduleName = name;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public UUID getId() {
        return mId;
    }

}
