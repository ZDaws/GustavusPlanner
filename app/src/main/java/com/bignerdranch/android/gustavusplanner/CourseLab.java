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

    private ClassLab(Context context) {
        mCourses = new ArrayList<>();
    }

    public List<Class> getCourses(){
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
}
