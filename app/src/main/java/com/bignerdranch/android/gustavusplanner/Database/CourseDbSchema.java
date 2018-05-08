package com.bignerdranch.android.gustavusplanner.Database;

public class CourseDbSchema {
    public static final class CourseTable {
        public static final String NAME = "name";

        public static final class Cols {
            public static final String SYNONYM = "synonym";
            public static final String SHORT_TITLE = "short_title";
            public static final String MEETING_DAYS = "meeting_days";
            public static final String START_TIME = "start_time";
            public static final String ENDING_TIME = "end_time";
            public static final String FACULTY = "faculty";
            public static final String AREA_APPROVALS = "area_approvals";
            public static final String UUID = "uuid";
        }
    }
}
