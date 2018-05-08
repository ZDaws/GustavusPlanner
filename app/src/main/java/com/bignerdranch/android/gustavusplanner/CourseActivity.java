package com.bignerdranch.android.gustavusplanner;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

public class CourseActivity extends SingleFragmentActivity {

    private static final String EXTRA_COURSE_INFO = "com.bignerdranch.android.gustavusplanner.course_info";

    public static Intent newIntent(Context packageContext, ArrayList<String> course) {
        Intent intent = new Intent(packageContext, CourseActivity.class);
        intent.putStringArrayListExtra(EXTRA_COURSE_INFO, course);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        ArrayList<String> courseInfo = (ArrayList<String>) getIntent()
                .getStringArrayListExtra(EXTRA_COURSE_INFO);
        return CourseFragment.newInstance(courseInfo);
    }
}