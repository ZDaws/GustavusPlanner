package com.bignerdranch.android.gustavusplanner;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CourseActivity extends SingleFragmentActivity {

    private static final String EXTRA_COURSE_ID = "com.bignerdranch.android.gustavusplanner.course_id";
    private static final String EXTRA_SCHEDULE_ID = "com.bignerdranch.android.gustavusplanner.schedule_id";

    public static Intent newIntent(Context packageContext, UUID courseId, UUID scheduleId) {
        Intent intent = new Intent(packageContext, CourseActivity.class);
        intent.putExtra(EXTRA_COURSE_ID, courseId);
        intent.putExtra(EXTRA_SCHEDULE_ID, scheduleId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID courseId = (UUID) getIntent().getSerializableExtra(EXTRA_COURSE_ID);
        UUID scheduleId = (UUID) getIntent().getSerializableExtra(EXTRA_SCHEDULE_ID);
        return CourseFragment.newInstance(courseId, scheduleId);
    }
}