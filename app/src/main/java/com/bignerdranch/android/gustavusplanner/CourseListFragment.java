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
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

public class CourseListFragment extends Fragment {

    private RecyclerView mCourseRecyclerView;
    private CourseAdapter mAdapter;
    private Schedule mSchedule;
    private TextView mCourseShortTitleTextView;
    private TextView mCourseStartTimeTextView;
    private TextView mCourseNameTextView;
    private TextView mCourseEndTimeTextView;


    private Button mMondayCourse1;
    private Button mMondayCourse2;
    private Button mMondayCourse3;
    private Button mMondayCourse4;
    private Button mMondayCourse5;
    private Button mMondayCourse6;
    private Button mMondayCourse7;
    private Button mMondayCourse8;
    private Button mMondayCourse9;
    private Button mMondayCourse10;

    private Button mTuesdayCourse1;
    private Button mTuesdayCourse2;
    private Button mTuesdayCourse3;
    private Button mTuesdayCourse4;
    private Button mTuesdayCourse5;
    private Button mTuesdayCourse6;
    private Button mTuesdayCourse7;
    private Button mTuesdayCourse8;
    private Button mTuesdayCourse9;
    private Button mTuesdayCourse10;

    private Button mWednesdayCourse1;
    private Button mWednesdayCourse2;
    private Button mWednesdayCourse3;
    private Button mWednesdayCourse4;
    private Button mWednesdayCourse5;
    private Button mWednesdayCourse6;
    private Button mWednesdayCourse7;
    private Button mWednesdayCourse8;
    private Button mWednesdayCourse9;
    private Button mWednesdayCourse10;

    private Button mThursdayCourse1;
    private Button mThursdayCourse2;
    private Button mThursdayCourse3;
    private Button mThursdayCourse4;
    private Button mThursdayCourse5;
    private Button mThursdayCourse6;
    private Button mThursdayCourse7;
    private Button mThursdayCourse8;
    private Button mThursdayCourse9;
    private Button mThursdayCourse10;

    private Button mFridayCourse1;
    private Button mFridayCourse2;
    private Button mFridayCourse3;
    private Button mFridayCourse4;
    private Button mFridayCourse5;
    private Button mFridayCourse6;
    private Button mFridayCourse7;
    private Button mFridayCourse8;
    private Button mFridayCourse9;
    private Button mFridayCourse10;

    private static int CourseCount= 0;


    private static final String EXTRA_SCHEDULE_ID = "com.bignerdranch.android.gustavusplanner.schedule_id";

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

        mCourseRecyclerView = (RecyclerView) view.findViewById(R.id.course_recycler_view);
        mCourseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        mMondayCourse1= (Button) view.findViewById(R.id.monday_course_1);
        mMondayCourse2= (Button) view.findViewById(R.id.monday_course_2);
        mMondayCourse3= (Button) view.findViewById(R.id.monday_course_3);
        mMondayCourse4= (Button) view.findViewById(R.id.monday_course_4);
        mMondayCourse5= (Button) view.findViewById(R.id.monday_course_5);
        mMondayCourse6= (Button) view.findViewById(R.id.monday_course_6);
        mMondayCourse7= (Button) view.findViewById(R.id.monday_course_7);
        mMondayCourse8= (Button) view.findViewById(R.id.monday_course_8);
        mMondayCourse9= (Button) view.findViewById(R.id.monday_course_9);
        mMondayCourse10= (Button) view.findViewById(R.id.monday_course_10);

        mTuesdayCourse1= (Button) view.findViewById(R.id.tuesday_course_1);
        mTuesdayCourse2= (Button) view.findViewById(R.id.tuesday_course_2);
        mTuesdayCourse3= (Button) view.findViewById(R.id.tuesday_course_3);
        mTuesdayCourse4= (Button) view.findViewById(R.id.tuesday_course_4);
        mTuesdayCourse5= (Button) view.findViewById(R.id.tuesday_course_5);
        mTuesdayCourse6= (Button) view.findViewById(R.id.tuesday_course_6);
        mTuesdayCourse7= (Button) view.findViewById(R.id.tuesday_course_7);
        mTuesdayCourse8= (Button) view.findViewById(R.id.tuesday_course_8);
        mTuesdayCourse9= (Button) view.findViewById(R.id.tuesday_course_9);
        mTuesdayCourse10= (Button) view.findViewById(R.id.tuesday_course_10);

        mWednesdayCourse1= (Button) view.findViewById(R.id.wednesday_course_1);
        mWednesdayCourse2= (Button) view.findViewById(R.id.wednesday_course_2);
        mWednesdayCourse3= (Button) view.findViewById(R.id.wednesday_course_3);
        mWednesdayCourse4= (Button) view.findViewById(R.id.wednesday_course_4);
        mWednesdayCourse5= (Button) view.findViewById(R.id.wednesday_course_5);
        mWednesdayCourse6= (Button) view.findViewById(R.id.wednesday_course_6);
        mWednesdayCourse7= (Button) view.findViewById(R.id.wednesday_course_7);
        mWednesdayCourse8= (Button) view.findViewById(R.id.wednesday_course_8);
        mWednesdayCourse9= (Button) view.findViewById(R.id.wednesday_course_9);
        mWednesdayCourse10= (Button) view.findViewById(R.id.wednesday_course_10);

        mThursdayCourse1= (Button) view.findViewById(R.id.thursday_course_1);
        mThursdayCourse2= (Button) view.findViewById(R.id.thursday_course_2);
        mThursdayCourse3= (Button) view.findViewById(R.id.thursday_course_3);
        mThursdayCourse4= (Button) view.findViewById(R.id.thursday_course_4);
        mThursdayCourse5= (Button) view.findViewById(R.id.thursday_course_5);
        mThursdayCourse6= (Button) view.findViewById(R.id.thursday_course_6);
        mThursdayCourse7= (Button) view.findViewById(R.id.thursday_course_7);
        mThursdayCourse8= (Button) view.findViewById(R.id.thursday_course_8);
        mThursdayCourse9= (Button) view.findViewById(R.id.thursday_course_9);
        mThursdayCourse10= (Button) view.findViewById(R.id.thursday_course_10);

        mFridayCourse1= (Button) view.findViewById(R.id.friday_course_1);
        mFridayCourse2= (Button) view.findViewById(R.id.friday_course_2);
        mFridayCourse3= (Button) view.findViewById(R.id.friday_course_3);
        mFridayCourse4= (Button) view.findViewById(R.id.friday_course_4);
        mFridayCourse5= (Button) view.findViewById(R.id.friday_course_5);
        mFridayCourse6= (Button) view.findViewById(R.id.friday_course_6);
        mFridayCourse7= (Button) view.findViewById(R.id.friday_course_7);
        mFridayCourse8= (Button) view.findViewById(R.id.friday_course_8);
        mFridayCourse9= (Button) view.findViewById(R.id.friday_course_9);
        mFridayCourse10= (Button) view.findViewById(R.id.friday_course_10);


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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent searchIntent = new Intent(getContext(), CourseSearchActivity.class);
                searchIntent.putExtra(SearchManager.QUERY, query);

                Bundle appData = new Bundle();
                appData.putSerializable(EXTRA_SCHEDULE_ID, mSchedule.getId()); // put extra data to Bundle
                searchIntent.putExtra(SearchManager.APP_DATA, appData); // pass the search context data
                searchIntent.setAction(Intent.ACTION_SEARCH);

                startActivity(searchIntent);

                return true; // we start the search activity manually
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

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
        CourseCount= 0;
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
            super(inflater.inflate(R.layout.list_item_course, parent, false));
            itemView.setOnClickListener(this);

            mCourseShortTitleTextView = (TextView) itemView.findViewById(R.id.course_list_item_short_title);
            mCourseStartTimeTextView = (TextView) itemView.findViewById(R.id.course_list_item_start_time);
            mCourseNameTextView = (TextView) itemView.findViewById(R.id.course_list_item_name);
            mCourseEndTimeTextView = (TextView) itemView.findViewById(R.id.course_list_item_end_time);

        }

        public void bind (Course course) {
            mCourse = course;
            mCourseShortTitleTextView.setText(mCourse.getShortTitle());
            mCourseStartTimeTextView.setText(mCourse.getStartTime());
            mCourseNameTextView.setText(mCourse.getName());
            mCourseEndTimeTextView.setText(mCourse.getEndTime());


            course.calculateTableBox();

            boolean M= false;
            boolean T= false;
            boolean W= false;
            boolean R= false;
            boolean F= false;
            String MeetingDays= course.getMeetingDays();
            for(int i=0; i<MeetingDays.length(); i++) {
                if(MeetingDays.charAt(i)=='M') {
                    M= true;
                }
                else if(MeetingDays.charAt(i)=='T') {
                    T= true;
                }
                else if(MeetingDays.charAt(i)=='W') {
                    W= true;
                }
                else if(MeetingDays.charAt(i)=='R') {
                    R= true;
                }
                else if(MeetingDays.charAt(i)=='F') {
                    F= true;
                }
            }

            CourseCount++;
            if(CourseCount==1) {
                if(M) {
                    mMondayCourse1.setText(course.getShortTitle());
                    //mMondayCourse1.setBackgroundColor(course.getCourseColor());
                    //mMondayCourse1.setTextColor(course.getTextColor());
                    mMondayCourse1.setTop(course.getPositionInTable());
                    mMondayCourse1.setHeight(course.getHeightInTable());
                    mMondayCourse1.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse1.setText(course.getShortTitle());
                    mTuesdayCourse1.setTop(course.getPositionInTable());
                    mTuesdayCourse1.setHeight(course.getHeightInTable());
                    mTuesdayCourse1.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse1.setText(course.getShortTitle());
                    mWednesdayCourse1.setTop(course.getPositionInTable());
                    mWednesdayCourse1.setHeight(course.getHeightInTable());
                    mWednesdayCourse1.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse1.setText(course.getShortTitle());
                    mThursdayCourse1.setTop(course.getPositionInTable());
                    mThursdayCourse1.setHeight(course.getHeightInTable());
                    mThursdayCourse1.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse1.setText(course.getShortTitle());
                    mFridayCourse1.setTop(course.getPositionInTable());
                    mFridayCourse1.setHeight(course.getHeightInTable());
                    mFridayCourse1.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==2) {
                if(M) {
                    mMondayCourse2.setText(course.getShortTitle());
                    mMondayCourse2.setTop(course.getPositionInTable());
                    mMondayCourse2.setHeight(course.getHeightInTable());
                    mMondayCourse2.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse2.setText(course.getShortTitle());
                    mTuesdayCourse2.setTop(course.getPositionInTable());
                    mTuesdayCourse2.setHeight(course.getHeightInTable());
                    mTuesdayCourse2.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse2.setText(course.getShortTitle());
                    mWednesdayCourse2.setTop(course.getPositionInTable());
                    mWednesdayCourse2.setHeight(course.getHeightInTable());
                    mWednesdayCourse2.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse2.setText(course.getShortTitle());
                    mThursdayCourse2.setTop(course.getPositionInTable());
                    mThursdayCourse2.setHeight(course.getHeightInTable());
                    mThursdayCourse2.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse2.setText(course.getShortTitle());
                    mFridayCourse2.setTop(course.getPositionInTable());
                    mFridayCourse2.setHeight(course.getHeightInTable());
                    mFridayCourse2.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==3) {
                if(M) {
                    mMondayCourse3.setText(course.getShortTitle());
                    mMondayCourse3.setTop(course.getPositionInTable());
                    mMondayCourse3.setHeight(course.getHeightInTable());
                    mMondayCourse3.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse3.setText(course.getShortTitle());
                    mTuesdayCourse3.setTop(course.getPositionInTable());
                    mTuesdayCourse3.setHeight(course.getHeightInTable());
                    mTuesdayCourse3.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse3.setText(course.getShortTitle());
                    mWednesdayCourse3.setTop(course.getPositionInTable());
                    mWednesdayCourse3.setHeight(course.getHeightInTable());
                    mWednesdayCourse3.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse3.setText(course.getShortTitle());
                    mThursdayCourse3.setTop(course.getPositionInTable());
                    mThursdayCourse3.setHeight(course.getHeightInTable());
                    mThursdayCourse3.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse3.setText(course.getShortTitle());
                    mFridayCourse3.setTop(course.getPositionInTable());
                    mFridayCourse3.setHeight(course.getHeightInTable());
                    mFridayCourse3.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==4) {
                if(M) {
                    mMondayCourse4.setText(course.getShortTitle());
                    mMondayCourse4.setTop(course.getPositionInTable());
                    mMondayCourse4.setHeight(course.getHeightInTable());
                    mMondayCourse4.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse4.setText(course.getShortTitle());
                    mTuesdayCourse4.setTop(course.getPositionInTable());
                    mTuesdayCourse4.setHeight(course.getHeightInTable());
                    mTuesdayCourse4.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse4.setText(course.getShortTitle());
                    mWednesdayCourse4.setTop(course.getPositionInTable());
                    mWednesdayCourse4.setHeight(course.getHeightInTable());
                    mWednesdayCourse4.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse4.setText(course.getShortTitle());
                    mThursdayCourse4.setTop(course.getPositionInTable());
                    mThursdayCourse4.setHeight(course.getHeightInTable());
                    mThursdayCourse4.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse4.setText(course.getShortTitle());
                    mFridayCourse4.setTop(course.getPositionInTable());
                    mFridayCourse4.setHeight(course.getHeightInTable());
                    mFridayCourse4.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==5) {
                if(M) {
                    mMondayCourse5.setText(course.getShortTitle());
                    mMondayCourse5.setTop(course.getPositionInTable());
                    mMondayCourse5.setHeight(course.getHeightInTable());
                    mMondayCourse5.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse5.setText(course.getShortTitle());
                    mTuesdayCourse5.setTop(course.getPositionInTable());
                    mTuesdayCourse5.setHeight(course.getHeightInTable());
                    mTuesdayCourse5.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse5.setText(course.getShortTitle());
                    mWednesdayCourse5.setTop(course.getPositionInTable());
                    mWednesdayCourse5.setHeight(course.getHeightInTable());
                    mWednesdayCourse5.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse5.setText(course.getShortTitle());
                    mThursdayCourse5.setTop(course.getPositionInTable());
                    mThursdayCourse5.setHeight(course.getHeightInTable());
                    mThursdayCourse5.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse5.setText(course.getShortTitle());
                    mFridayCourse5.setTop(course.getPositionInTable());
                    mFridayCourse5.setHeight(course.getHeightInTable());
                    mFridayCourse5.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==6) {
                if(M) {
                    mMondayCourse6.setText(course.getShortTitle());
                    mMondayCourse6.setTop(course.getPositionInTable());
                    mMondayCourse6.setHeight(course.getHeightInTable());
                    mMondayCourse6.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse6.setText(course.getShortTitle());
                    mTuesdayCourse6.setTop(course.getPositionInTable());
                    mTuesdayCourse6.setHeight(course.getHeightInTable());
                    mTuesdayCourse6.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse6.setText(course.getShortTitle());
                    mWednesdayCourse6.setTop(course.getPositionInTable());
                    mWednesdayCourse6.setHeight(course.getHeightInTable());
                    mWednesdayCourse6.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse6.setText(course.getShortTitle());
                    mThursdayCourse6.setTop(course.getPositionInTable());
                    mThursdayCourse6.setHeight(course.getHeightInTable());
                    mThursdayCourse6.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse6.setText(course.getShortTitle());
                    mFridayCourse6.setTop(course.getPositionInTable());
                    mFridayCourse6.setHeight(course.getHeightInTable());
                    mFridayCourse6.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==7) {
                if(M) {
                    mMondayCourse7.setText(course.getShortTitle());
                    mMondayCourse7.setTop(course.getPositionInTable());
                    mMondayCourse7.setHeight(course.getHeightInTable());
                    mMondayCourse7.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse7.setText(course.getShortTitle());
                    mTuesdayCourse7.setTop(course.getPositionInTable());
                    mTuesdayCourse7.setHeight(course.getHeightInTable());
                    mTuesdayCourse7.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse7.setText(course.getShortTitle());
                    mWednesdayCourse7.setTop(course.getPositionInTable());
                    mWednesdayCourse7.setHeight(course.getHeightInTable());
                    mWednesdayCourse7.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse7.setText(course.getShortTitle());
                    mThursdayCourse7.setTop(course.getPositionInTable());
                    mThursdayCourse7.setHeight(course.getHeightInTable());
                    mThursdayCourse7.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse7.setText(course.getShortTitle());
                    mFridayCourse7.setTop(course.getPositionInTable());
                    mFridayCourse7.setHeight(course.getHeightInTable());
                    mFridayCourse7.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==8) {
                if(M) {
                    mMondayCourse8.setText(course.getShortTitle());
                    mMondayCourse8.setTop(course.getPositionInTable());
                    mMondayCourse8.setHeight(course.getHeightInTable());
                    mMondayCourse8.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse8.setText(course.getShortTitle());
                    mTuesdayCourse8.setTop(course.getPositionInTable());
                    mTuesdayCourse8.setHeight(course.getHeightInTable());
                    mTuesdayCourse8.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse8.setText(course.getShortTitle());
                    mWednesdayCourse8.setTop(course.getPositionInTable());
                    mWednesdayCourse8.setHeight(course.getHeightInTable());
                    mWednesdayCourse8.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse8.setText(course.getShortTitle());
                    mThursdayCourse8.setTop(course.getPositionInTable());
                    mThursdayCourse8.setHeight(course.getHeightInTable());
                    mThursdayCourse8.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse8.setText(course.getShortTitle());
                    mFridayCourse8.setTop(course.getPositionInTable());
                    mFridayCourse8.setHeight(course.getHeightInTable());
                    mFridayCourse8.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==9) {
                if(M) {
                    mMondayCourse9.setText(course.getShortTitle());
                    mMondayCourse9.setTop(course.getPositionInTable());
                    mMondayCourse9.setHeight(course.getHeightInTable());
                    mMondayCourse9.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse9.setText(course.getShortTitle());
                    mTuesdayCourse9.setTop(course.getPositionInTable());
                    mTuesdayCourse9.setHeight(course.getHeightInTable());
                    mTuesdayCourse9.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse9.setText(course.getShortTitle());
                    mWednesdayCourse9.setTop(course.getPositionInTable());
                    mWednesdayCourse9.setHeight(course.getHeightInTable());
                    mWednesdayCourse9.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse9.setText(course.getShortTitle());
                    mThursdayCourse9.setTop(course.getPositionInTable());
                    mThursdayCourse9.setHeight(course.getHeightInTable());
                    mThursdayCourse9.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse9.setText(course.getShortTitle());
                    mFridayCourse9.setTop(course.getPositionInTable());
                    mFridayCourse9.setHeight(course.getHeightInTable());
                    mFridayCourse9.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==10) {
                if(M) {
                    mMondayCourse10.setText(course.getShortTitle());
                    mMondayCourse10.setTop(course.getPositionInTable());
                    mMondayCourse10.setHeight(course.getHeightInTable());
                    mMondayCourse10.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse10.setText(course.getShortTitle());
                    mTuesdayCourse10.setTop(course.getPositionInTable());
                    mTuesdayCourse10.setHeight(course.getHeightInTable());
                    mTuesdayCourse10.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse10.setText(course.getShortTitle());
                    mWednesdayCourse10.setTop(course.getPositionInTable());
                    mWednesdayCourse10.setHeight(course.getHeightInTable());
                    mWednesdayCourse10.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse10.setText(course.getShortTitle());
                    mThursdayCourse10.setTop(course.getPositionInTable());
                    mThursdayCourse10.setHeight(course.getHeightInTable());
                    mThursdayCourse10.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse10.setText(course.getShortTitle());
                    mFridayCourse10.setTop(course.getPositionInTable());
                    mFridayCourse10.setHeight(course.getHeightInTable());
                    mFridayCourse10.setVisibility(View.VISIBLE);
                }
            }

        }

        @Override
        public void onClick(View view) {
            Intent intent = CourseActivity.newIntent(getActivity(), mCourse.getId(), mSchedule.getId());
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
