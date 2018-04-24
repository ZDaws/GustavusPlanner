package com.bignerdranch.android.gustavusplanner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CourseFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the course data from the list of fall courses on WebAdvisor
        ArrayList<String> courseInfo = new ArrayList<String>();
        Document doc = Jsoup.parse("https://gustavus.edu/registrar/webadvisor/mstrfall.html");
        Element table = doc.select("table").get(0);
        Elements rows = doc.select("tr");
        for(int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            for(int j = 0; j < cols.size(); j++) {
                courseInfo.add(cols.get(j).text().toString());
            }
        }
        Log.d("TESTING QUERY", courseInfo.toString());
    }
}
