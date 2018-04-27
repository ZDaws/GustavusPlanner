package com.bignerdranch.android.gustavusplanner;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CourseLab {
    private static CourseLab sCourseLab;

    private List<Course> mCourses;

    public static CourseLab get(Context context) {
        if (sCourseLab == null) {
            sCourseLab = new CourseLab(context);
        }
        return sCourseLab;
    }

    private CourseLab(Context context) {
        mCourses = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Course course = new Course();
            course.setShortTitle("Course #" + i);
            mCourses.add(course);
        }
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
}
