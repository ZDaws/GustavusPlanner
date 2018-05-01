package com.bignerdranch.android.gustavusplanner;

import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ScheduleListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        ArrayList<ArrayList<String>> courses;
        try {
            courses = new GetCourseInfo().execute(
                    "https://gustavus.edu/registrar/webadvisor/mstrfall.html"
            ).get();
            Log.d("TESTING", courses.toString());
            for(int i = 0; i < courses.size(); i++) {
                Course course = new Course();
                course.setName(courses.get(i).get(0));
                course.setSynonym(courses.get(i).get(1));
                course.setShortTitle(courses.get(i).get(2));
                course.setMeetingDays(courses.get(i).get(3));
                course.setStartTime(courses.get(i).get(4));
                course.setEndTime(courses.get(i).get(5));
                course.setFaculty(courses.get(i).get(6));
                course.setAreaApprovals(courses.get(i).get(7));
                CourseLab.get(getApplicationContext()).addCourse(course);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return new ScheduleListFragment();
    }
}
