package com.bignerdranch.android.gustavusplanner.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bignerdranch.android.gustavusplanner.Database.ScheduleDbSchema.ScheduleTable;

public class ScheduleBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "scheduleBase.db";

    public ScheduleBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ScheduleDbSchema.ScheduleTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                ScheduleTable.Cols.UUID + ", " +
                ScheduleTable.Cols.TITLE + ", " +
                ScheduleTable.Cols.DATE +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
