package com.bignerdranch.android.gustavusplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.UUID;

/**
 * Created by MaNgAkA fReAk on 4/26/2018.
 */

public class CourseFragment extends Fragment {

    private Button AddCourseToSchedule;

    private Course mCourse;

    private static final String ARG_COURSE_ID = "Course ID";


    public static CourseFragment newInstance(UUID courseId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_COURSE_ID, courseId);

        CourseFragment fragment = new CourseFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID courseId = (UUID) getArguments().getSerializable(ARG_COURSE_ID);
        mCourse = CourseLab.get(getActivity()).getCourse(courseId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.course_fragment, container, false);

        AddCourseToSchedule= (Button) v.findViewById(R.id.add_to_schedule);
        AddCourseToSchedule.setText("Add "+mCourse.getShortTitle()+" to schedule.");
        AddCourseToSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Add to schedule code here

            }
        });

        return  v;
    }
}
