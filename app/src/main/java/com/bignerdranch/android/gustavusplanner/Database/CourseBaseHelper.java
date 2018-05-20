package com.bignerdranch.android.gustavusplanner.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CourseBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "courseBase.db";

    public CourseBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + CourseDbSchema.CourseTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                CourseDbSchema.CourseTable.Cols.TITLE + ", " +
                CourseDbSchema.CourseTable.Cols.SYNONYM + ", " +
                CourseDbSchema.CourseTable.Cols.SHORT_TITLE + ", " +
                CourseDbSchema.CourseTable.Cols.MEETING_DAYS + ", " +
                CourseDbSchema.CourseTable.Cols.START_TIME + ", " +
                CourseDbSchema.CourseTable.Cols.ENDING_TIME + ", " +
                CourseDbSchema.CourseTable.Cols.FACULTY + ", " +
                CourseDbSchema.CourseTable.Cols.AREA_APPROVALS + ", " +
                CourseDbSchema.CourseTable.Cols.UUID +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
