package com.bignerdranch.android.gustavusplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

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

    private static final String ARG_COURSE_INFO = "course_info";


    public static CourseFragment newInstance(ArrayList<String> course) {
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_COURSE_INFO, course);

        CourseFragment fragment = new CourseFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> course = (ArrayList<String>) getArguments().getStringArrayList(ARG_COURSE_INFO);
        mCourse = new Course(
                course.get(0),
                course.get(1),
                course.get(2),
                course.get(3),
                course.get(4),
                course.get(5),
                course.get(6),
                course.get(7));
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

                //Add to schedule code here
                //Add mCourse to the schedule lab or something like that

            }
        });

        return  v;
    }
}
