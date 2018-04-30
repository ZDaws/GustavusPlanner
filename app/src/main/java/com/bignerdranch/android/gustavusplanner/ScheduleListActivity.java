package com.bignerdranch.android.gustavusplanner;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;

public class ScheduleListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        new GetCourseInfo().execute("https://gustavus.edu/registrar/webadvisor/mstrfall.html");
        return new ScheduleListFragment();
    }
}
