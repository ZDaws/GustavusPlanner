package com.bignerdranch.android.gustavusplanner;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CourseSearchActivity extends AppCompatActivity {

    private ListView courseSearchResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_search);

        courseSearchResult = (ListView) findViewById(R.id.course_search_result);

        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {

            final String query = intent.getStringExtra(SearchManager.QUERY);
            final ArrayList<ArrayList<String>> courses = getCourses();
            final ArrayList<String> courseNames = getSearchedCourses(courses, query);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    courseNames
            );

            courseSearchResult.setAdapter(arrayAdapter);

            courseSearchResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    ArrayList<Course> coursesInList = makeCourseObjects(courses, query);
                    Course clickedCourse = coursesInList.get(i);
                    Toast.makeText(CourseSearchActivity.this,
                            "Made a new course object for "+courseNames.get(i),
                            Toast.LENGTH_LONG)
                            .show();
                }
            });
        }

    }

    private ArrayList<ArrayList<String>> getCourses() {
        ArrayList<ArrayList<String>> courses = new ArrayList<>();
        try {
            courses = new GetCourseInfo()
                    .execute("https://gustavus.edu/registrar/webadvisor/mstrfall.html")
                    .get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return courses;
    }

    private ArrayList<String> getSearchedCourses(ArrayList<ArrayList<String>> courseList, String query) {
        ArrayList<String> searchResults = new ArrayList<>();
        for(int i = 0; i < courseList.size(); i++) {
            for (int j = 0; j < courseList.get(i).size(); j++) {
                if (courseList.get(i).get(j).contains(query)) {
                    searchResults.add(courseList.get(i).get(j));
                }
            }
        }

        return searchResults;
    }

    private ArrayList<Course> makeCourseObjects(ArrayList<ArrayList<String>> courseList, String query) {
        ArrayList<Course> searchResults = new ArrayList<>();
        for(int i = 0; i < courseList.size(); i++) {
            for (int j = 0; j < courseList.get(i).size(); j++) {
                if (courseList.get(i).get(j).contains(query)) {
                    Course course = new Course();
                    course.setName(courseList.get(i).get(0));
                    course.setSynonym(courseList.get(i).get(1));
                    course.setShortTitle(courseList.get(i).get(2));
                    course.setMeetingDays(courseList.get(i).get(3));
                    course.setStartTime(courseList.get(i).get(4));
                    course.setEndTime(courseList.get(i).get(5));
                    course.setFaculty(courseList.get(i).get(6));
                    course.setAreaApprovals(courseList.get(i).get(7));
                    searchResults.add(course);
                }
            }
        }

        return searchResults;
    }
}
