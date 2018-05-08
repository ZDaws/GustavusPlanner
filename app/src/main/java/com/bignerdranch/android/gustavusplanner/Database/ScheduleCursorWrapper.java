package com.bignerdranch.android.gustavusplanner.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.gustavusplanner.Schedule;

import java.util.Date;
import java.util.UUID;

public class ScheduleCursorWrapper extends CursorWrapper {
    public ScheduleCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Schedule getSchedule() {
        String uuidString = getString(getColumnIndex(ScheduleDbSchema.ScheduleTable.Cols.UUID));
        String name = getString(getColumnIndex(ScheduleDbSchema.ScheduleTable.Cols.TITLE));
        long date = getLong(getColumnIndex(ScheduleDbSchema.ScheduleTable.Cols.DATE));

        Schedule schedule = new Schedule(UUID.fromString(uuidString));
        schedule.setName(name);
        schedule.setDate(new Date(date));

        return schedule;
    }
}
