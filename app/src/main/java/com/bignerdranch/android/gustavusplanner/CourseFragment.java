package com.bignerdranch.android.gustavusplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by MaNgAkA fReAk on 4/26/2018.
 */

public class CourseFragment extends Fragment {

    private Button AddCourseToSchedule;
    private EditText courseName;
    private EditText courseSynonym;
    private EditText courseShortTitle;
    private EditText courseMeetingDays;
    private EditText courseStartTime;
    private EditText courseEndTime;
    private EditText courseFaculty;
    private EditText courseAreaApprovals;


    private Course mCourse;
    private Schedule mSchedule;

    private UUID mCourseID;
    private UUID mScheduleID;

    private static final String ARG_COURSE_ID = "course_id";
    private static final String ARG_SCHEDULE_ID = "schedule_id";


    public static CourseFragment newInstance(UUID courseId, UUID scheduleId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_COURSE_ID, courseId);
        args.putSerializable(ARG_SCHEDULE_ID, scheduleId);

        CourseFragment fragment = new CourseFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mCourseID = (UUID) getArguments().getSerializable(ARG_COURSE_ID);
        mCourse = CourseLab.get(getContext()).getCourse(mCourseID);

        mScheduleID = (UUID) getArguments().getSerializable(ARG_SCHEDULE_ID);
        mSchedule = ScheduleLab.get(getContext()).getSchedule(mScheduleID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.course_fragment, container, false);

        courseName = v.findViewById(R.id.course_name);
        courseName.setText(mCourse.getName());
        courseName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCourse.setName(s.toString());
                CourseLab.get(getContext()).updateCourse(mCourse);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        courseSynonym = v.findViewById(R.id.course_synonym);
        courseSynonym.setText(mCourse.getSynonym());
        courseSynonym.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCourse.setSynonym(s.toString());
                CourseLab.get(getContext()).updateCourse(mCourse);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        courseShortTitle = v.findViewById(R.id.course_short_title);
        courseShortTitle.setText(mCourse.getShortTitle());
        courseShortTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCourse.setShortTitle(s.toString());
                CourseLab.get(getContext()).updateCourse(mCourse);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        courseMeetingDays = v.findViewById(R.id.course_meeting_days);
        courseMeetingDays.setText(mCourse.getMeetingDays());
        courseMeetingDays.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCourse.setMeetingDays(s.toString());
                CourseLab.get(getContext()).updateCourse(mCourse);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        courseStartTime = v.findViewById(R.id.course_start_time);
        courseStartTime.setText(mCourse.getStartTime());
        courseStartTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCourse.setStartTime(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(mCourse.getStartTime().length()==7) {
                    if (mCourse.getStartTime().charAt(0) >= '0' && mCourse.getStartTime().charAt(0) <= '9')
                        if (mCourse.getStartTime().charAt(1) >= '0' && mCourse.getStartTime().charAt(1) <= '9')
                            if (mCourse.getStartTime().charAt(2) == ':')
                                if (mCourse.getStartTime().charAt(3) >= '0' && mCourse.getStartTime().charAt(3) <= '9')
                                    if (mCourse.getStartTime().charAt(4) >= '0' && mCourse.getStartTime().charAt(4) <= '9')
                                        if (mCourse.getStartTime().charAt(5) == 'A' || mCourse.getStartTime().charAt(5) == 'P')
                                            if (mCourse.getStartTime().charAt(6) == 'M')
                                                CourseLab.get(getContext()).updateCourse(mCourse);
                }
                else if(mCourse.getStartTime().length()==6) {
                    if (mCourse.getStartTime().charAt(0) >= '0' && mCourse.getStartTime().charAt(0) <= '9')
                        if (mCourse.getStartTime().charAt(1) == ':')
                            if (mCourse.getStartTime().charAt(2) >= '0' && mCourse.getStartTime().charAt(2) <= '9')
                                if (mCourse.getStartTime().charAt(3) >= '0' && mCourse.getStartTime().charAt(3) <= '9')
                                    if (mCourse.getStartTime().charAt(4) == 'A' || mCourse.getStartTime().charAt(4) == 'P')
                                        if (mCourse.getStartTime().charAt(5) == 'M')
                                            CourseLab.get(getContext()).updateCourse(mCourse);
                }
            }
        });

        courseEndTime = v.findViewById(R.id.course_end_time);
        courseEndTime.setText(mCourse.getEndTime());
        courseEndTime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCourse.setEndTime(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(mCourse.getEndTime().length()==7) {
                    if (mCourse.getEndTime().charAt(0) >= '0' && mCourse.getEndTime().charAt(0) <= '9')
                        if (mCourse.getEndTime().charAt(1) >= '0' && mCourse.getEndTime().charAt(1) <= '9')
                            if (mCourse.getEndTime().charAt(2) == ':')
                                if (mCourse.getEndTime().charAt(3) >= '0' && mCourse.getEndTime().charAt(3) <= '9')
                                    if (mCourse.getEndTime().charAt(4) >= '0' && mCourse.getEndTime().charAt(4) <= '9')
                                        if (mCourse.getEndTime().charAt(5) == 'A' || mCourse.getEndTime().charAt(5) == 'P')
                                            if (mCourse.getEndTime().charAt(6) == 'M')
                                                CourseLab.get(getContext()).updateCourse(mCourse);
                }
                else if(mCourse.getEndTime().length()==6) {
                    if (mCourse.getEndTime().charAt(0) >= '0' && mCourse.getEndTime().charAt(0) <= '9')
                        if (mCourse.getEndTime().charAt(1) == ':')
                            if (mCourse.getEndTime().charAt(2) >= '0' && mCourse.getEndTime().charAt(2) <= '9')
                                if (mCourse.getEndTime().charAt(3) >= '0' && mCourse.getEndTime().charAt(3) <= '9')
                                    if (mCourse.getEndTime().charAt(4) == 'A' || mCourse.getEndTime().charAt(4) == 'P')
                                        if (mCourse.getEndTime().charAt(5) == 'M')
                                            CourseLab.get(getContext()).updateCourse(mCourse);
                }
            }
        });

        courseFaculty = v.findViewById(R.id.course_faculty);
        courseFaculty.setText(mCourse.getFaculty());
        courseFaculty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCourse.setFaculty(s.toString());
                CourseLab.get(getContext()).updateCourse(mCourse);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        courseAreaApprovals = v.findViewById(R.id.course_area_approvals);
        courseAreaApprovals.setText(mCourse.getAreaApprovals());
        courseAreaApprovals.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCourse.setAreaApprovals(s.toString());
                CourseLab.get(getContext()).updateCourse(mCourse);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        AddCourseToSchedule= (Button) v.findViewById(R.id.add_to_schedule);
        AddCourseToSchedule.setText("Confirm");
        AddCourseToSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CourseLab.get(getContext()).addCourse(mCourse);
                Intent intent = CourseListActivity.newIntent(getContext(), mSchedule.getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //makes it so you can't go back to search screen after
                startActivity(intent);
            }
        });

        return  v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_course, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_course:
                CourseLab courseLab = CourseLab.get(getContext());
                if (courseLab.getCourse(mCourse.getId()) != null) {
                    courseLab.deleteCourse(mCourse);
                    getActivity().finish();
                } else {
                    //currently doesn't work due to fact that the course is always added
                    Toast.makeText(getActivity(),
                            "You can't delete a course that you haven't added",
                            Toast.LENGTH_SHORT).show();
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
