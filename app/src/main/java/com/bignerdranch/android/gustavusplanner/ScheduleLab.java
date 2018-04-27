package com.bignerdranch.android.gustavusplanner;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScheduleLab {

    private static ScheduleLab sScheduleLab;

    private List<Schedule> mSchedules;

    public static ScheduleLab get(Context context) {
        if (sScheduleLab == null) {
            sScheduleLab = new ScheduleLab(context);
        }
        return sScheduleLab;
    }

    private ScheduleLab(Context context) {
        mSchedules = new ArrayList<>();
    }

    public List<Schedule> getSchedules(){
        return mSchedules;
    }

    public Schedule getSchedule(UUID id) {
        for (Schedule schedule: mSchedules) {
            if (schedule.getId().equals(id)) {
                return schedule;
            }
        }
        return null;
    }

    public void addSchedule(Schedule s) {
        mSchedules.add(s);
    }
}
