package com.bignerdranch.android.gustavusplanner.Database;

public class CourseDbSchema {
    public static final class CourseTable {
        public static final String NAME = "name";

        public static final class Cols {
            public static final String SYNONYM = "synonym";
            public static final String SHORT_TITLE = "short title";
            public static final String MEETING_DAYS = "meeting days";
            public static final String START_TIME = "start time";
            public static final String END_TIME = "end time";
            public static final String FACULTY = "faculty";
            public static final String AREA_APPROVALS = "area approvals";
            public static final String UUID = "uuid";
        }
    }
}
