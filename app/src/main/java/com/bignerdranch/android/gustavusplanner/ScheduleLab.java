package com.bignerdranch.android.gustavusplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.bignerdranch.android.gustavusplanner.Database.ScheduleCursorWrapper;
import com.bignerdranch.android.gustavusplanner.Database.ScheduleBaseHelper;
import com.bignerdranch.android.gustavusplanner.Database.ScheduleDbSchema.ScheduleTable;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScheduleLab {

    private static ScheduleLab sScheduleLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ScheduleLab get(Context context) {
        if (sScheduleLab == null) {
            sScheduleLab = new ScheduleLab(context);
        }
        return sScheduleLab;
    }

    private ScheduleLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ScheduleBaseHelper(mContext)
                .getWritableDatabase();
    }

    public void addSchedule(Schedule s) {
        ContentValues values = getContentValues(s);
        mDatabase.insert(ScheduleTable.NAME, null, values);
    }

    public void deleteSchedule(Schedule s) {
        mDatabase.delete(ScheduleTable.NAME, ScheduleTable.Cols.UUID + " = ?",
                new String[] { s.getId().toString()});

    }

    public List<Schedule> getSchedules(){
        List<Schedule> schedules = new ArrayList<>();
        ScheduleCursorWrapper cursor = querySchedules(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                schedules.add(cursor.getSchedule());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return schedules;
    }

    public Schedule getSchedule(UUID id) {
        ScheduleCursorWrapper cursor = querySchedules(
                ScheduleTable.Cols.UUID + " = ?",
                new String[] {id.toString() }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getSchedule();
        } finally {
            cursor.close();
        }
    }

    public void updateSchedule(Schedule schedule) {
        String uuidString = schedule.getId().toString();
        ContentValues values = getContentValues(schedule);

        mDatabase.update(ScheduleTable.NAME, values,
                ScheduleTable.Cols.UUID + " = ?",
                new String[] { uuidString});
    }

    private ScheduleCursorWrapper querySchedules(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ScheduleTable.NAME, null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new ScheduleCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Schedule schedule) {
        ContentValues values = new ContentValues();
        values.put(ScheduleTable.Cols.UUID, schedule.getId().toString());
        values.put(ScheduleTable.Cols.TITLE, schedule.getName());
        values.put(ScheduleTable.Cols.DATE, schedule.getDate().getTime());
        return values;
    }
}
