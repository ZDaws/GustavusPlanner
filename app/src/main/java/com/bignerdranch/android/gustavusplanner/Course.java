package com.bignerdranch.android.gustavusplanner;

/**
 * Created by MaNgAkA fReAk on 4/24/2018.
 */

public class Course {

    private String Name;
    private int Synonym;
    private String ShortTitle;
    private String MeetingDays;
    private String StartTime;
    private String EndTime;
    private String Faculty;
    private String AreaApprovals;

    Course() {
        Name= "AAA-###-###"; // Full course name
        Synonym= 130734; // Synonym for the course. Should be 5 digits #####
        ShortTitle= "Actual name of course";
        MeetingDays= "Days of week it meets on";
        StartTime= "##:##AA";
        EndTime= "##:##AA";
        Faculty= "Professor Name";
        AreaApprovals= "Other Sections it counts as credit for";
    }

    Course(String name, int synonym, String shortTitle, String meetingDays, String startTime, String endTime, String faculty, String areaApprovals) {
        Name= name; // Full course name
        Synonym= synonym; // Synonym for the course. Should be 5 digits #####
        ShortTitle= shortTitle;
        MeetingDays= meetingDays;
        StartTime= startTime;
        EndTime= endTime;
        Faculty= faculty;
        AreaApprovals= areaApprovals;
    }




    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSynonym() {
        return Synonym;
    }

    public void setSynonym(int synonym) {
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
}
