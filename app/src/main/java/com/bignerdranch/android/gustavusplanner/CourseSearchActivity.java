package com.bignerdranch.android.gustavusplanner;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class CourseSearchActivity extends AppCompatActivity {

    private ListView courseSearchResult;
    private UUID scheduleId;

    private static final String EXTRA_SCHEDULE_ID = "com.bignerdranch.android.gustavusplanner.schedule_id";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_search);

        courseSearchResult = (ListView) findViewById(R.id.course_search_result);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {

            Bundle appData = getIntent().getBundleExtra(SearchManager.APP_DATA);
            if (appData != null) {
                scheduleId = (UUID) appData.getSerializable(EXTRA_SCHEDULE_ID);
            }

            final String query = intent.getStringExtra(SearchManager.QUERY);
            final ArrayList<ArrayList<String>> courses = getCourses(query);

            ArrayList<String> courseNames = new ArrayList<>();
            for(int i = 0; i < courses.size(); i++) {
                courseNames.add(courses.get(i).get(0)); // can change to display anything about the course
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    courseNames
            );

            courseSearchResult.setAdapter(arrayAdapter);

            courseSearchResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    ArrayList<String> clickedCourse = courses.get(i);
                    Course mCourse = new Course(
                            clickedCourse.get(0),
                            clickedCourse.get(1),
                            clickedCourse.get(2),
                            clickedCourse.get(3),
                            clickedCourse.get(4),
                            clickedCourse.get(5),
                            clickedCourse.get(6),
                            clickedCourse.get(7)
                            );
                    CourseLab.get(getApplicationContext()).addCourse(mCourse);
                    // We will add this in the future to start the view where we can see the course
                    // info and add it. For now I made it a toast so we can see how it works
                    Intent intent = CourseActivity.newIntent(
                            getApplicationContext(),
                            mCourse.getId(),
                            scheduleId
                            );
                    startActivity(intent);

                }
            });
        }

    }

    private ArrayList<ArrayList<String>> getCourses(String query) {
        ArrayList<ArrayList<String>> courses = new ArrayList<>();
        try {
            courses = new GetCourseInfo()
                    .execute(query)
                    .get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
