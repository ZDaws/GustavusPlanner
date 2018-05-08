package com.bignerdranch.android.gustavusplanner.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.gustavusplanner.Course;
import com.bignerdranch.android.gustavusplanner.Database.CourseDbSchema.CourseTable;

import java.util.UUID;

public class CourseCursorWrapper extends CursorWrapper {
    public CourseCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Course getCourse() {
        String synonym = getString(getColumnIndex(CourseTable.Cols.SYNONYM));
        String shortTitle = getString(getColumnIndex(CourseTable.Cols.SHORT_TITLE));
        String meetingDays = getString(getColumnIndex(CourseTable.Cols.MEETING_DAYS));
        String startTime = getString(getColumnIndex(CourseTable.Cols.START_TIME));
        String endTime = getString(getColumnIndex(CourseTable.Cols.ENDING_TIME));
        String faculty = getString(getColumnIndex(CourseTable.Cols.FACULTY));
        String approvals = getString(getColumnIndex(CourseTable.Cols.AREA_APPROVALS));
        String uuidString = getString(getColumnIndex(CourseTable.Cols.UUID));

        Course course = new Course(UUID.fromString(uuidString));
        course.setSynonym(synonym);
        course.setShortTitle(shortTitle);
        course.setMeetingDays(meetingDays);
        course.setStartTime(startTime);
        course.setEndTime(endTime);
        course.setFaculty(faculty);
        course.setAreaApprovals(approvals);

        return course;
    }
}

