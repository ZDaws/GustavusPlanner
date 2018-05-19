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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

public class CourseListFragment extends Fragment {

    private RecyclerView mCourseRecyclerView;
    private CourseAdapter mAdapter;
    private TextView mTitleTextView;
    private Schedule mSchedule;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        UUID scheduleId = (UUID) getActivity().getIntent()
                .getSerializableExtra(CourseListActivity.EXTRA_SCHEDULE_ID);
        mSchedule = ScheduleLab.get(getActivity()).getSchedule(scheduleId);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                ScheduleLab.get(getContext()).deleteSchedule(mSchedule);
                getActivity().finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        ScheduleLab.get(getActivity()).updateSchedule(mSchedule);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        CourseLab courseLab = CourseLab.get(getActivity());
        List<Course> courses = courseLab.getCourses();

        if (mAdapter == null) {
            mAdapter = new CourseAdapter(courses);
            mCourseRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setCourses(courses);
            mAdapter.notifyDataSetChanged();
        }
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

        public void setCourses(List<Course> courses) {
            mCourses = courses;
        }
    }

}
