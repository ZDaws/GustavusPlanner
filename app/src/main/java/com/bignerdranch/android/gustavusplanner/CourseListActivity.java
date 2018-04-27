package com.bignerdranch.android.gustavusplanner;

import android.support.v4.app.Fragment;

public class CourseListActivity extends SingleFragmentActivity{
    @Override
    protected Fragment createFragment() {
        new GetCourseInfo().execute("https://gustavus.edu/registrar/webadvisor/mstrfall.html");
        return new CourseListFragment();
    }
}
