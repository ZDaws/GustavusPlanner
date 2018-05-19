package com.bignerdranch.android.gustavusplanner;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CourseListActivity extends SingleFragmentActivity {

    public static final String EXTRA_SCHEDULE_ID =
            "com.bignerdranch.android.gustavusplanner.schedule_id";

    public static Intent newIntent(Context packageContext, UUID scheduleId) {
        Intent intent = new Intent(packageContext, CourseListActivity.class);
        intent.putExtra(EXTRA_SCHEDULE_ID, scheduleId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new CourseListFragment();
    }
}
