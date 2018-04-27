package com.bignerdranch.android.gustavusplanner;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class GetCourseInfo extends AsyncTask<String, Void, Void>{

    @Override
    protected Void doInBackground(String... urls) {
        //Get the course data from the list of fall courses on WebAdvisor

        String input;
        String output = "";

        try {
            URL url = new URL(urls[0]);
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
            String name = cols.get(0).text();
            String synonym = cols.get(1).text();
            String shortTitle = cols.get(2).text();
            String meetingDays = cols.get(3).text();
            String startTime = cols.get(4).text();
            String endTime = cols.get(5).text();
            String faculty = cols.get(6).text();
            String areaApprovals = cols.get(7).text();
            String test = name+" "+synonym+" "+shortTitle+" "+meetingDays+" "+startTime+" "+
                    endTime+" "+faculty+" "+areaApprovals;
            Log.d("TESTING QUERY", test);
        }
        return null;
    }


}
