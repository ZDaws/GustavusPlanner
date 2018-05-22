package com.bignerdranch.android.gustavusplanner;

import android.graphics.Color;

import java.util.Random;
import java.util.UUID;

/**
 * Created by MaNgAkA fReAk on 4/24/2018.
 */

public class Course {

    private String Name;
    private String Synonym;
    private String ShortTitle;
    private String MeetingDays;
    private String StartTime;
    private String EndTime;
    private String Faculty;
    private String AreaApprovals;

    private UUID mId;


    //These are for the table in CourseListFragment
    private String positionInTable= ""; //Top location of course box
    private int heightInTable= 0; //height of course box
    private static int courseColor= 130734;
    private static int textColor= 130734;



    public Course() {
        Name= "AAA-###-###"; // Full course name
        Synonym= "130734"; // Synonym for the course. Should be 5 digits #####
        ShortTitle= "Actual name of course";
        MeetingDays= "Days of week it meets on";
        StartTime= "##:##AA";
        EndTime= "##:##AA";
        Faculty= "Professor Name";
        AreaApprovals= "Other Sections it counts as credit for";
        mId= UUID.randomUUID();
    }

    //If unneeded, delete later
    public Course (UUID id) {
        mId = id;
    }

    Course(String name, String synonym, String shortTitle, String meetingDays, String startTime, String endTime, String faculty, String areaApprovals) {
        Name= name; // Full course name
        Synonym= synonym; // Synonym for the course. Should be 5 digits #####
        ShortTitle= shortTitle;
        MeetingDays= meetingDays;
        StartTime= startTime;
        EndTime= endTime;
        Faculty= faculty;
        AreaApprovals= areaApprovals;
        mId= UUID.randomUUID();
    }




    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSynonym() {
        return Synonym;
    }

    public void setSynonym(String synonym) {
        Synonym = synonym;
    }

    public String getShortTitle() {
        return ShortTitle;
    }

    public void setShortTitle(String shortTitle) {
        ShortTitle = shortTitle;
    }

    public String getMeetingDays() {
        return MeetingDays;
    }

    public void setMeetingDays(String meetingDays) {
        MeetingDays = meetingDays;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public String getAreaApprovals() {
        return AreaApprovals;
    }

    public void setAreaApprovals(String areaApprovals) {
        AreaApprovals = areaApprovals;
    }

    public UUID getId() {
        return mId;
    }


    public String getPositionInTable() {
        return positionInTable;
    }

    public int getHeightInTable() {
        return heightInTable;
    }

    public int getCourseColor() {
        return courseColor;
    }

    public void setCourseColor(int courseColor) {
        this.courseColor = courseColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void calculateTableBox() { //Figure out where the class should show up on the schedule, in dp
        String hourStartString="";
        int hourStart=0;
        String minuteStartString="";
        char AM_PM_Start;

        String hourEndString="";
        int hourEnd=0;
        String minuteEndString="";
        char AM_PM_End;

        int timeStart=0;
        int timeEnd=0;
        int position;

        int i=0;
        while (StartTime.charAt(i) != ':') {
            hourStartString=hourStartString+StartTime.charAt(0);
            i++;
        }
        i++;
        while(StartTime.charAt(i)!='A' && StartTime.charAt(i)!='P') {
            minuteStartString=minuteStartString+StartTime.charAt(i);
            i++;
        }
        AM_PM_Start=StartTime.charAt(i);

        if(AM_PM_Start=='A' || hourStartString=="12") {
            position=30*(Integer.parseInt(hourStartString) - 8) + (Integer.parseInt(minuteStartString)/2); // 8:00AM=0dp 9:00AM=30dp 10:00AM=60dp 11:AM=90dp 12:00PM=120dp
            hourStart= Integer.parseInt(hourStartString);
        }
        else {
            position=30*(Integer.parseInt(hourStartString) + 4) + (Integer.parseInt(minuteStartString)/2); // 1:00PM=150dp 11:00PM=450dp
            hourStart= Integer.parseInt(hourStartString) + 12;
        }
        timeStart=60*hourStart + Integer.parseInt(minuteStartString);

        i=0;
        while (EndTime.charAt(i) != ':') {
            hourEndString=hourEndString+EndTime.charAt(0);
            i++;
        }
        i++;
        while(EndTime.charAt(i)!='A' && EndTime.charAt(i)!='P') {
            minuteEndString=minuteEndString+EndTime.charAt(i);
            i++;
        }
        AM_PM_End=EndTime.charAt(i);

        if(AM_PM_End=='A' || hourEndString=="12") {
            hourEnd= Integer.parseInt(hourEndString);
        }
        else {
            hourEnd= Integer.parseInt(hourEndString) + 12;
        }
        timeEnd=60*hourEnd + Integer.parseInt(minuteEndString);


        positionInTable=Integer.toString(position);
        heightInTable=timeEnd-timeStart;

        int color= new Random().nextInt();       //Assign random color to course
        courseColor= color;
        String courseColorHex= Integer.toHexString(courseColor);
        color = (int)Long.parseLong(courseColorHex, 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        int invertedRed = 255 - r;
        int invertedGreen = 255 - g;
        int invertedBlue = 255 - b;

        textColor = Color.rgb(invertedRed, invertedGreen, invertedBlue);
                   //Assign inverted color to text
    }

}