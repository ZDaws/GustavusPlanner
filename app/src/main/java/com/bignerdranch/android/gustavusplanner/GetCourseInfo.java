package com.bignerdranch.android.gustavusplanner;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class GetCourseInfo extends AsyncTask<String, Void, ArrayList<ArrayList<String>>>{

    @Override
    protected ArrayList<ArrayList<String>> doInBackground(String... queries) {
        //Get the course data from the list of fall courses on WebAdvisor

        String input;
        String output = "";
        String query = queries[0];
        ArrayList<ArrayList<String>> courses = new ArrayList<>();

        try {
            URL url = new URL("https://gustavus.edu/registrar/webadvisor/mstrfall.html");
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(con.getInputStream()));

            while ((input = br.readLine()) != null){
                output+=input;
            }
            br.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(output);
        Element table = doc.select("table").get(0);
        Elements rows = table.select("tr");
        for(int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            ArrayList<String> courseInfo = new ArrayList<>();
            Boolean containsQuery = false;
            for(int j = 0; j < cols.size(); j++) {
                String courseAttribute = cols.get(j).text();
                if(courseAttribute.contains(query)) {
                    containsQuery = true;
                }
                courseInfo.add(courseAttribute);
            }
            if (containsQuery) {
                courses.add(courseInfo);
            }
        }
        return courses;
    }


}
