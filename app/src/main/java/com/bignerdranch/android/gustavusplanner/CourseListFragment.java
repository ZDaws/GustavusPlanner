package com.bignerdranch.android.gustavusplanner;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
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

    private CourseLab courseLab;


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

    private UUID scheduleId;


    private static final String EXTRA_SCHEDULE_ID = "com.bignerdranch.android.gustavusplanner.schedule_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        scheduleId = (UUID) getActivity().getIntent()
                .getSerializableExtra(CourseListActivity.EXTRA_SCHEDULE_ID);
        mSchedule = ScheduleLab.get(getActivity()).getSchedule(scheduleId);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
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

        mMondayCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(0).itemView.performClick();
            }
        });
        mMondayCourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(1).itemView.performClick();
            }
        });
        mMondayCourse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(2).itemView.performClick();
            }
        });
        mMondayCourse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(3).itemView.performClick();
            }
        });
        mMondayCourse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(4).itemView.performClick();
            }
        });
        mMondayCourse6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(5).itemView.performClick();
            }
        });
        mMondayCourse7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(6).itemView.performClick();
            }
        });
        mMondayCourse8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(7).itemView.performClick();
            }
        });
        mMondayCourse9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(8).itemView.performClick();
            }
        });
        mMondayCourse10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(9).itemView.performClick();
            }
        });

        mTuesdayCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(0).itemView.performClick();
            }
        });
        mTuesdayCourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(1).itemView.performClick();
            }
        });
        mTuesdayCourse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(2).itemView.performClick();
            }
        });
        mTuesdayCourse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(3).itemView.performClick();
            }
        });
        mTuesdayCourse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(4).itemView.performClick();
            }
        });
        mTuesdayCourse6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(5).itemView.performClick();
            }
        });
        mTuesdayCourse7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(6).itemView.performClick();
            }
        });
        mTuesdayCourse8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(7).itemView.performClick();
            }
        });
        mTuesdayCourse9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(8).itemView.performClick();
            }
        });
        mTuesdayCourse10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(9).itemView.performClick();
            }
        });

        mWednesdayCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(0).itemView.performClick();
            }
        });
        mWednesdayCourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(1).itemView.performClick();
            }
        });
        mWednesdayCourse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(2).itemView.performClick();
            }
        });
        mWednesdayCourse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(3).itemView.performClick();
            }
        });
        mWednesdayCourse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(4).itemView.performClick();
            }
        });
        mWednesdayCourse6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(5).itemView.performClick();
            }
        });
        mWednesdayCourse7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(6).itemView.performClick();
            }
        });
        mWednesdayCourse8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(7).itemView.performClick();
            }
        });
        mWednesdayCourse9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(8).itemView.performClick();
            }
        });
        mWednesdayCourse10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(9).itemView.performClick();
            }
        });

        mThursdayCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(0).itemView.performClick();
            }
        });
        mThursdayCourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(1).itemView.performClick();
            }
        });
        mThursdayCourse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(2).itemView.performClick();
            }
        });
        mThursdayCourse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(3).itemView.performClick();
            }
        });
        mThursdayCourse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(4).itemView.performClick();
            }
        });
        mThursdayCourse6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(5).itemView.performClick();
            }
        });
        mThursdayCourse7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(6).itemView.performClick();
            }
        });
        mThursdayCourse8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(7).itemView.performClick();
            }
        });
        mThursdayCourse9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(8).itemView.performClick();
            }
        });
        mThursdayCourse10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(9).itemView.performClick();
            }
        });

        mFridayCourse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(0).itemView.performClick();
            }
        });
        mFridayCourse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(1).itemView.performClick();
            }
        });
        mFridayCourse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(2).itemView.performClick();
            }
        });
        mFridayCourse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(3).itemView.performClick();
            }
        });
        mFridayCourse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(4).itemView.performClick();
            }
        });
        mFridayCourse6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(5).itemView.performClick();
            }
        });
        mFridayCourse7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(6).itemView.performClick();
            }
        });
        mFridayCourse8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(7).itemView.performClick();
            }
        });
        mFridayCourse9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(8).itemView.performClick();
            }
        });
        mFridayCourse10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCourseRecyclerView.findViewHolderForAdapterPosition(9).itemView.performClick();
            }
        });

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
            /* case R.id.add_course:
                Course BlankCourse = new Course("", "", "", "", "", "", "", "");
                CourseLab.get(getActivity()).addCourse(BlankCourse);
                Intent intent = CourseActivity
                        .newIntent(getActivity(), BlankCourse.getId(), scheduleId);
                startActivity(intent);
                CourseLab.get(getContext()).addCourse(BlankCourse);
                return true; */
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
        courseLab = CourseLab.get(getActivity());
        List<Course> courses = courseLab.getCourses();

        int CourseCount=0;

        mMondayCourse1.setVisibility(View.GONE); //Refresh Schedule Table
        mTuesdayCourse1.setVisibility(View.GONE);
        mWednesdayCourse1.setVisibility(View.GONE);
        mThursdayCourse1.setVisibility(View.GONE);
        mFridayCourse1.setVisibility(View.GONE);
        mMondayCourse2.setVisibility(View.GONE);
        mTuesdayCourse2.setVisibility(View.GONE);
        mWednesdayCourse2.setVisibility(View.GONE);
        mThursdayCourse2.setVisibility(View.GONE);
        mFridayCourse2.setVisibility(View.GONE);
        mMondayCourse3.setVisibility(View.GONE);
        mTuesdayCourse3.setVisibility(View.GONE);
        mWednesdayCourse3.setVisibility(View.GONE);
        mThursdayCourse3.setVisibility(View.GONE);
        mFridayCourse3.setVisibility(View.GONE);
        mMondayCourse4.setVisibility(View.GONE);
        mTuesdayCourse4.setVisibility(View.GONE);
        mWednesdayCourse4.setVisibility(View.GONE);
        mThursdayCourse4.setVisibility(View.GONE);
        mFridayCourse4.setVisibility(View.GONE);
        mMondayCourse5.setVisibility(View.GONE);
        mTuesdayCourse5.setVisibility(View.GONE);
        mWednesdayCourse5.setVisibility(View.GONE);
        mThursdayCourse5.setVisibility(View.GONE);
        mFridayCourse5.setVisibility(View.GONE);
        mMondayCourse6.setVisibility(View.GONE);
        mTuesdayCourse6.setVisibility(View.GONE);
        mWednesdayCourse6.setVisibility(View.GONE);
        mThursdayCourse6.setVisibility(View.GONE);
        mFridayCourse6.setVisibility(View.GONE);
        mMondayCourse7.setVisibility(View.GONE);
        mTuesdayCourse7.setVisibility(View.GONE);
        mWednesdayCourse7.setVisibility(View.GONE);
        mThursdayCourse7.setVisibility(View.GONE);
        mFridayCourse7.setVisibility(View.GONE);
        mMondayCourse8.setVisibility(View.GONE);
        mTuesdayCourse8.setVisibility(View.GONE);
        mWednesdayCourse8.setVisibility(View.GONE);
        mThursdayCourse8.setVisibility(View.GONE);
        mFridayCourse8.setVisibility(View.GONE);
        mMondayCourse9.setVisibility(View.GONE);
        mTuesdayCourse9.setVisibility(View.GONE);
        mWednesdayCourse9.setVisibility(View.GONE);
        mThursdayCourse9.setVisibility(View.GONE);
        mFridayCourse9.setVisibility(View.GONE);
        mMondayCourse10.setVisibility(View.GONE);
        mTuesdayCourse10.setVisibility(View.GONE);
        mWednesdayCourse10.setVisibility(View.GONE);
        mThursdayCourse10.setVisibility(View.GONE);
        mFridayCourse10.setVisibility(View.GONE);

        for(int c=0; c<courses.size() && c<10; c++) {
            Course course=courses.get(c);

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

            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);


            int pixelHeight= (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, course.getHeightInTable(), getResources()
                            .getDisplayMetrics());

            int pixelPosition= (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, course.getPositionInTable(), getResources()
                            .getDisplayMetrics());

            layoutParams.setMargins(0, pixelPosition, 0, 0);
            layoutParams.height= pixelHeight;
            layoutParams.width= 130734;

            CourseCount++;
            if(CourseCount==1) {
                if(M) {
                    mMondayCourse1.setText(course.getShortTitle());
                    //mMondayCourse1.setBackgroundColor(course.getCourseColor());
                    //mMondayCourse1.setTextColor(course.getTextColor());
                    mMondayCourse1.setLayoutParams(layoutParams);
                    mMondayCourse1.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse1.setText(course.getShortTitle());
                    mTuesdayCourse1.setLayoutParams(layoutParams);
                    mTuesdayCourse1.setHeight(pixelHeight);
                    mTuesdayCourse1.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse1.setText(course.getShortTitle());
                    mWednesdayCourse1.setLayoutParams(layoutParams);
                    mWednesdayCourse1.setHeight(pixelHeight);
                    mWednesdayCourse1.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse1.setText(course.getShortTitle());
                    mThursdayCourse1.setLayoutParams(layoutParams);
                    mThursdayCourse1.setHeight(pixelHeight);
                    mThursdayCourse1.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse1.setText(course.getShortTitle());
                    mFridayCourse1.setLayoutParams(layoutParams);
                    mFridayCourse1.setHeight(pixelHeight);
                    mFridayCourse1.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==2) {
                if(M) {
                    mMondayCourse2.setText(course.getShortTitle());
                    mMondayCourse2.setLayoutParams(layoutParams);
                    mMondayCourse2.setHeight(pixelHeight);
                    mMondayCourse2.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse2.setText(course.getShortTitle());
                    mTuesdayCourse2.setLayoutParams(layoutParams);
                    mTuesdayCourse2.setHeight(pixelHeight);
                    mTuesdayCourse2.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse2.setText(course.getShortTitle());
                    mWednesdayCourse2.setLayoutParams(layoutParams);
                    mWednesdayCourse2.setHeight(pixelHeight);
                    mWednesdayCourse2.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse2.setText(course.getShortTitle());
                    mThursdayCourse2.setLayoutParams(layoutParams);
                    mThursdayCourse2.setHeight(pixelHeight);
                    mThursdayCourse2.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse2.setText(course.getShortTitle());
                    mFridayCourse2.setLayoutParams(layoutParams);
                    mFridayCourse2.setHeight(pixelHeight);
                    mFridayCourse2.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==3) {
                if(M) {
                    mMondayCourse3.setText(course.getShortTitle());
                    mMondayCourse3.setLayoutParams(layoutParams);
                    mMondayCourse3.setHeight(pixelHeight);
                    mMondayCourse3.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse3.setText(course.getShortTitle());
                    mTuesdayCourse3.setLayoutParams(layoutParams);
                    mTuesdayCourse3.setHeight(pixelHeight);
                    mTuesdayCourse3.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse3.setText(course.getShortTitle());
                    mWednesdayCourse3.setLayoutParams(layoutParams);
                    mWednesdayCourse3.setHeight(pixelHeight);
                    mWednesdayCourse3.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse3.setText(course.getShortTitle());
                    mThursdayCourse3.setLayoutParams(layoutParams);
                    mThursdayCourse3.setHeight(pixelHeight);
                    mThursdayCourse3.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse3.setText(course.getShortTitle());
                    mFridayCourse3.setLayoutParams(layoutParams);
                    mFridayCourse3.setHeight(pixelHeight);
                    mFridayCourse3.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==4) {
                if(M) {
                    mMondayCourse4.setText(course.getShortTitle());
                    mMondayCourse4.setLayoutParams(layoutParams);
                    mMondayCourse4.setHeight(pixelHeight);
                    mMondayCourse4.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse4.setText(course.getShortTitle());
                    mTuesdayCourse4.setLayoutParams(layoutParams);
                    mTuesdayCourse4.setHeight(pixelHeight);
                    mTuesdayCourse4.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse4.setText(course.getShortTitle());
                    mWednesdayCourse4.setLayoutParams(layoutParams);
                    mWednesdayCourse4.setHeight(pixelHeight);
                    mWednesdayCourse4.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse4.setText(course.getShortTitle());
                    mThursdayCourse4.setLayoutParams(layoutParams);
                    mThursdayCourse4.setHeight(pixelHeight);
                    mThursdayCourse4.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse4.setText(course.getShortTitle());
                    mFridayCourse4.setLayoutParams(layoutParams);
                    mFridayCourse4.setHeight(pixelHeight);
                    mFridayCourse4.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==5) {
                if(M) {
                    mMondayCourse5.setText(course.getShortTitle());
                    mMondayCourse5.setLayoutParams(layoutParams);
                    mMondayCourse5.setHeight(pixelHeight);
                    mMondayCourse5.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse5.setText(course.getShortTitle());
                    mTuesdayCourse5.setLayoutParams(layoutParams);
                    mTuesdayCourse5.setHeight(pixelHeight);
                    mTuesdayCourse5.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse5.setText(course.getShortTitle());
                    mWednesdayCourse5.setLayoutParams(layoutParams);
                    mWednesdayCourse5.setHeight(pixelHeight);
                    mWednesdayCourse5.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse5.setText(course.getShortTitle());
                    mThursdayCourse5.setLayoutParams(layoutParams);
                    mThursdayCourse5.setHeight(pixelHeight);
                    mThursdayCourse5.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse5.setText(course.getShortTitle());
                    mFridayCourse5.setLayoutParams(layoutParams);
                    mFridayCourse5.setHeight(pixelHeight);
                    mFridayCourse5.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==6) {
                if(M) {
                    mMondayCourse6.setText(course.getShortTitle());
                    mMondayCourse6.setLayoutParams(layoutParams);
                    mMondayCourse6.setHeight(pixelHeight);
                    mMondayCourse6.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse6.setText(course.getShortTitle());
                    mTuesdayCourse6.setLayoutParams(layoutParams);
                    mTuesdayCourse6.setHeight(pixelHeight);
                    mTuesdayCourse6.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse6.setText(course.getShortTitle());
                    mWednesdayCourse6.setLayoutParams(layoutParams);
                    mWednesdayCourse6.setHeight(pixelHeight);
                    mWednesdayCourse6.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse6.setText(course.getShortTitle());
                    mThursdayCourse6.setLayoutParams(layoutParams);
                    mThursdayCourse6.setHeight(pixelHeight);
                    mThursdayCourse6.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse6.setText(course.getShortTitle());
                    mFridayCourse6.setLayoutParams(layoutParams);
                    mFridayCourse6.setHeight(pixelHeight);
                    mFridayCourse6.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==7) {
                if(M) {
                    mMondayCourse7.setText(course.getShortTitle());
                    mMondayCourse7.setLayoutParams(layoutParams);
                    mMondayCourse7.setHeight(pixelHeight);
                    mMondayCourse7.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse7.setText(course.getShortTitle());
                    mTuesdayCourse7.setLayoutParams(layoutParams);
                    mTuesdayCourse7.setHeight(pixelHeight);
                    mTuesdayCourse7.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse7.setText(course.getShortTitle());
                    mWednesdayCourse7.setLayoutParams(layoutParams);
                    mWednesdayCourse7.setHeight(pixelHeight);
                    mWednesdayCourse7.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse7.setText(course.getShortTitle());
                    mThursdayCourse7.setLayoutParams(layoutParams);
                    mThursdayCourse7.setHeight(pixelHeight);
                    mThursdayCourse7.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse7.setText(course.getShortTitle());
                    mFridayCourse7.setLayoutParams(layoutParams);
                    mFridayCourse7.setHeight(pixelHeight);
                    mFridayCourse7.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==8) {
                if(M) {
                    mMondayCourse8.setText(course.getShortTitle());
                    mMondayCourse8.setLayoutParams(layoutParams);
                    mMondayCourse8.setHeight(pixelHeight);
                    mMondayCourse8.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse8.setText(course.getShortTitle());
                    mTuesdayCourse8.setLayoutParams(layoutParams);
                    mTuesdayCourse8.setHeight(pixelHeight);
                    mTuesdayCourse8.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse8.setText(course.getShortTitle());
                    mWednesdayCourse8.setLayoutParams(layoutParams);
                    mWednesdayCourse8.setHeight(pixelHeight);
                    mWednesdayCourse8.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse8.setText(course.getShortTitle());
                    mThursdayCourse8.setLayoutParams(layoutParams);
                    mThursdayCourse8.setHeight(pixelHeight);
                    mThursdayCourse8.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse8.setText(course.getShortTitle());
                    mFridayCourse8.setLayoutParams(layoutParams);
                    mFridayCourse8.setHeight(pixelHeight);
                    mFridayCourse8.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==9) {
                if(M) {
                    mMondayCourse9.setText(course.getShortTitle());
                    mMondayCourse9.setLayoutParams(layoutParams);
                    mMondayCourse9.setHeight(pixelHeight);
                    mMondayCourse9.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse9.setText(course.getShortTitle());
                    mTuesdayCourse9.setLayoutParams(layoutParams);
                    mTuesdayCourse9.setHeight(pixelHeight);
                    mTuesdayCourse9.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse9.setText(course.getShortTitle());
                    mWednesdayCourse9.setLayoutParams(layoutParams);
                    mWednesdayCourse9.setHeight(pixelHeight);
                    mWednesdayCourse9.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse9.setText(course.getShortTitle());
                    mThursdayCourse9.setLayoutParams(layoutParams);
                    mThursdayCourse9.setHeight(pixelHeight);
                    mThursdayCourse9.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse9.setText(course.getShortTitle());
                    mFridayCourse9.setLayoutParams(layoutParams);
                    mFridayCourse9.setHeight(pixelHeight);
                    mFridayCourse9.setVisibility(View.VISIBLE);
                }
            }
            else if(CourseCount==10) {
                if(M) {
                    mMondayCourse10.setText(course.getShortTitle());
                    mMondayCourse10.setLayoutParams(layoutParams);
                    mMondayCourse10.setHeight(pixelHeight);
                    mMondayCourse10.setVisibility(View.VISIBLE);
                }
                if(T) {
                    mTuesdayCourse10.setText(course.getShortTitle());
                    mTuesdayCourse10.setLayoutParams(layoutParams);
                    mTuesdayCourse10.setHeight(pixelHeight);
                    mTuesdayCourse10.setVisibility(View.VISIBLE);
                }
                if(W) {
                    mWednesdayCourse10.setText(course.getShortTitle());
                    mWednesdayCourse10.setLayoutParams(layoutParams);
                    mWednesdayCourse10.setHeight(pixelHeight);
                    mWednesdayCourse10.setVisibility(View.VISIBLE);
                }
                if(R) {
                    mThursdayCourse10.setText(course.getShortTitle());
                    mThursdayCourse10.setLayoutParams(layoutParams);
                    mThursdayCourse10.setHeight(pixelHeight);
                    mThursdayCourse10.setVisibility(View.VISIBLE);
                }
                if(F) {
                    mFridayCourse10.setText(course.getShortTitle());
                    mFridayCourse10.setLayoutParams(layoutParams);
                    mFridayCourse10.setHeight(pixelHeight);
                    mFridayCourse10.setVisibility(View.VISIBLE);
                }
            }
        }

        //if (mAdapter == null) {                                      //Refresh RecyclerView
            mAdapter = new CourseAdapter(courses);
            mCourseRecyclerView.setAdapter(mAdapter);
        /* } else {
            mAdapter.setCourses(courses);
            mAdapter.notifyDataSetChanged();
        } */
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
