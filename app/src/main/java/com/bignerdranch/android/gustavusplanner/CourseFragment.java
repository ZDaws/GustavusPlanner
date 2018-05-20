package com.bignerdranch.android.gustavusplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by MaNgAkA fReAk on 4/26/2018.
 */

public class CourseFragment extends Fragment {

    private Button AddCourseToSchedule;
    private TextView courseName;
    private TextView courseSynonym;
    private TextView courseShortTitle;
    private TextView courseMeetingDays;
    private TextView courseStartTime;
    private TextView courseEndTime;
    private TextView courseFaculty;
    private TextView courseAreaApprovals;


    private Course mCourse;
    private Schedule mSchedule;

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

        UUID courseId = (UUID) getArguments().getSerializable(ARG_COURSE_ID);
        mCourse = CourseLab.get(getContext()).getCourse(courseId);

        UUID scheduleId = (UUID) getArguments().getSerializable(ARG_SCHEDULE_ID);
        mSchedule = ScheduleLab.get(getContext()).getSchedule(scheduleId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.course_fragment, container, false);

        courseName = (TextView) v.findViewById(R.id.course_name);
        courseName.setText(mCourse.getName());

        courseSynonym = (TextView) v.findViewById(R.id.course_synonym);
        courseSynonym.setText(mCourse.getSynonym());

        courseShortTitle = (TextView) v.findViewById(R.id.course_short_title);
        courseShortTitle.setText(mCourse.getShortTitle());

        courseMeetingDays = (TextView) v.findViewById(R.id.course_meeting_days);
        courseMeetingDays.setText(mCourse.getMeetingDays());

        courseStartTime = (TextView) v.findViewById(R.id.course_start_time);
        courseStartTime.setText(mCourse.getStartTime());

        courseEndTime = (TextView) v.findViewById(R.id.course_end_time);
        courseEndTime.setText(mCourse.getEndTime());

        courseFaculty = (TextView) v.findViewById(R.id.course_faculty);
        courseFaculty.setText(mCourse.getFaculty());

        courseAreaApprovals = (TextView) v.findViewById(R.id.course_area_approvals);
        courseAreaApprovals.setText(mCourse.getAreaApprovals());

        AddCourseToSchedule= (Button) v.findViewById(R.id.add_to_schedule);
        AddCourseToSchedule.setText("Add "+mCourse.getShortTitle()+" to schedule.");
        AddCourseToSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),
                        "Course: "+mCourse.getShortTitle()+" Schedule: "+ mSchedule.getName(),
                        Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });

        return  v;
    }


}
