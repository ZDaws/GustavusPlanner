package com.bignerdranch.android.gustavusplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.gustavusplanner.Database.CourseCursorWrapper;
import com.bignerdranch.android.gustavusplanner.Database.CourseBaseHelper;
import com.bignerdranch.android.gustavusplanner.Database.CourseDbSchema.CourseTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseLab {

    private static CourseLab sCourseLab;

    //If unneeded, delete later
    private SQLiteDatabase mDatabase;

    private List<Course> mCourses;

    public static CourseLab get(Context context) {
        if (sCourseLab == null) {
            sCourseLab = new CourseLab(context);
        }
        return sCourseLab;
    }

    private CourseLab(Context context) {
        mCourses = new ArrayList<>();
    }

    public List<Course> getCourses(){
        return mCourses;
    }

    public Course getCourse(UUID id) {
        for (Course course: mCourses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    public void addCourse(Course c) {
        mCourses.add(c);
    }

    //If unneeded, delete the next two functions later on
    private CourseCursorWrapper queryCrimes(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                CourseTable.NAME, null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        return new CourseCursorWrapper(cursor);
    }

    private static ContentValues getContentValues(Course course) {
        ContentValues values = new ContentValues();
        values.put(CourseTable.Cols.SYNONYM, course.getSynonym());
        values.put(CourseTable.Cols.SHORT_TITLE, course.getShortTitle());
        values.put(CourseTable.Cols.MEETING_DAYS, course.getMeetingDays());
        values.put(CourseTable.Cols.START_TIME, course.getStartTime());
        values.put(CourseTable.Cols.ENDING_TIME, course.getEndTime());
        values.put(CourseTable.Cols.FACULTY, course.getFaculty());
        values.put(CourseTable.Cols.AREA_APPROVALS, course.getAreaApprovals());
        values.put(CourseTable.Cols.UUID, course.getId().toString());

        return values;
    }
}
