package com.bignerdranch.android.gustavusplanner;

import android.support.v4.app.Fragment;

public class CourseActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CourseFragment();
    }
}