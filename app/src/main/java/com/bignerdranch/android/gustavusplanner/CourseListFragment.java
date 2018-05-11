package com.bignerdranch.android.gustavusplanner;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CourseListFragment extends Fragment {

    private RecyclerView mCourseRecyclerView;
    private CourseAdapter mAdapter;
    private TextView mTitleTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);

        mCourseRecyclerView = (RecyclerView) view.findViewById(R.id.schedule_recycler_view);
        mCourseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_course_list, menu);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_courses).getActionView();
        // Assumes current activity is the searchable activity
        ComponentName componentName = new ComponentName(getContext(),
                "com.bignerdranch.android.gustavusplanner.CourseSearchActivity");
        searchView.setSearchableInfo(searchManager.getSearchableInfo(
                componentName
        ));

    }

    private void updateUI() {
        CourseLab courseLab = CourseLab.get(getActivity());
        List<Course> courses = courseLab.getCourses();

        mAdapter = new CourseAdapter(courses);
        mCourseRecyclerView.setAdapter(mAdapter);
    }

    private class CourseHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

        private Course mCourse;
        public CourseHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_schedule, parent, false));
            itemView.setOnClickListener(this);

        }

        public void bind (Course course) {
            mCourse = course;
            mTitleTextView.setText(mCourse.getName());
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), CourseFragment.class);
            startActivity(intent);
        }
    }

    private class CourseAdapter extends RecyclerView.Adapter<CourseHolder> {

        private List<Course> mCourses;

        public CourseAdapter(List<Course> courses) {
            mCourses = courses;
        }

        @Override
        public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new CourseHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CourseHolder holder, int position) {
            Course course = mCourses.get(position);
            holder.bind(course);

        }

        @Override
        public int getItemCount() {
            return mCourses.size();
        }
    }



    private int calculatePosition(String StartTime) { //Figure out where the class should show up on the schedule, in dp
        int position=0;
        String hour="";
        String minute="";
        char AM_PM;

        int i=0;
        while (StartTime.charAt(i) != ':') {
            hour=hour+StartTime.charAt(0);
            i++;
        }
        i++;
        while(StartTime.charAt(i)!='A' && StartTime.charAt(i)!='P') {
            minute=minute+StartTime.charAt(i);
            i++;
        }
        AM_PM=StartTime.charAt(i);

        if(AM_PM=='A' || hour=="12") {
            position=30*(Integer.parseInt(hour) - 8) + (Integer.parseInt(minute)/2); // 8:00AM=0dp 9:00AM=30dp 10:00AM=60dp 11:AM=90dp 12:00PM=120dp
        }
        else {
            position=30*(Integer.parseInt(hour) + 4) + (Integer.parseInt(minute)/2); // 1:00PM=150dp 11:00PM=450dp
        }

        return position;
    }

    private int calculateLengthOfCourse(String StartTime, String EndTime) { //Figure out how the height of a course, in dp
        int height=0;

        String hourStartString="";
        int hourStart=0;
        String minuteStart="";
        char AM_PM_Start;

        String hourEndString="";
        int hourEnd=0;
        String minuteEnd="";
        char AM_PM_End;

        int timeStart=0;
        int timeEnd=0;

        int i=0;
        while (StartTime.charAt(i) != ':') {
            hourStartString=hourStartString+StartTime.charAt(0);
            i++;
        }
        i++;
        while(StartTime.charAt(i)!='A' && StartTime.charAt(i)!='P') {
            minuteStart=minuteStart+StartTime.charAt(i);
            i++;
        }
        AM_PM_Start=StartTime.charAt(i);
        if(AM_PM_Start=='A' || hourStartString=="12") {
            hourStart= Integer.parseInt(hourStartString);
        }
        else {
            hourStart= Integer.parseInt(hourStartString) + 12;
        }
        timeStart=60*hourStart + Integer.parseInt(minuteStart);

        i=0;
        while (EndTime.charAt(i) != ':') {
            hourEndString=hourEndString+EndTime.charAt(0);
            i++;
        }
        i++;
        while(EndTime.charAt(i)!='A' && EndTime.charAt(i)!='P') {
            minuteEnd=minuteEnd+EndTime.charAt(i);
            i++;
        }
        AM_PM_End=EndTime.charAt(i);
        if(AM_PM_End=='A' || hourEndString=="12") {
            hourEnd= Integer.parseInt(hourEndString);
        }
        else {
            hourEnd= Integer.parseInt(hourEndString) + 12;
        }
        timeEnd=60*hourEnd + Integer.parseInt(minuteEnd);

        height=timeEnd-timeStart;

        return height;
    }

}
