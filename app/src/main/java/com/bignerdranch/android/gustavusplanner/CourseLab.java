package com.bignerdranch.android.gustavusplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.gustavusplanner.Database.CourseBaseHelper;
import com.bignerdranch.android.gustavusplanner.Database.CourseCursorWrapper;
import com.bignerdranch.android.gustavusplanner.Database.CourseDbSchema.CourseTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseLab {

    private static CourseLab sCourseLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static CourseLab get(Context context) {
        if (sCourseLab == null) {
            sCourseLab = new CourseLab(context);
        }
        return sCourseLab;
    }

    private CourseLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new CourseBaseHelper(mContext).getWritableDatabase();
    }

    public void addCourse(Course c) {
        ContentValues values = getContentValues(c);

        mDatabase.insert(CourseTable.NAME, null, values);
    }

    public void deleteCourse(Course c) {
        mDatabase.delete(CourseTable.NAME, CourseTable.Cols.UUID + " = ?",
                new String[] { c.getId().toString()});

    }

    public List<Course> getCourses(){
        List<Course> courses = new ArrayList<>();

        CourseCursorWrapper cursor = queryCourses(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                courses.add(cursor.getCourse());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        return courses;
    }

    public Course getCourse(UUID id) {
        CourseCursorWrapper cursor = queryCourses(
                CourseTable.Cols.UUID + " = ?",
                new String[] { id.toString() }
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }

            cursor.moveToFirst();
            return cursor.getCourse();
        } finally {
            cursor.close();
        }
    }

    public void updateCourse(Course course) {
        String uuidString = course.getId().toString();
        ContentValues values = getContentValues(course);

        mDatabase.update(CourseTable.NAME, values,
                CourseTable.Cols.UUID + " = ?",
                new String[] { uuidString });
    }

    //If unneeded, delete the next two functions later on
    private CourseCursorWrapper queryCourses(String whereClause, String[] whereArgs) {
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
        values.put(CourseTable.Cols.TITLE, course.getName());
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
