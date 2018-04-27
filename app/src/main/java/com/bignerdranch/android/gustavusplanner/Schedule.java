package com.bignerdranch.android.gustavusplanner;

import java.util.UUID;

public class Schedule {

    private String scheduleName;
    private UUID mId;

    public String getName() {
        return scheduleName;
    }

    public void setName(String name) {
        scheduleName = name;
    }

    public UUID getId() {
        return mId;
    }
}
