package com.bignerdranch.android.gustavusplanner;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleListFragment extends Fragment {

    private RecyclerView mScheduleRecyclerView;
    private ScheduleAdapter mAdapter;
    private TextView mTitleTextView;
    private MenuInflater inflater;
    private ArrayList toDelete = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_list, container, false);

        mScheduleRecyclerView = (RecyclerView) view.findViewById(R.id.schedule_recycler_view);
        mScheduleRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_schedule_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_schedule:
                Schedule schedule = new Schedule();
                ScheduleLab.get(getActivity()).addSchedule(schedule);
                Intent intent = new Intent(getActivity(), CourseListActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        ScheduleLab scheduleLab = ScheduleLab.get(getActivity());
        List<Schedule> schedules = scheduleLab.getSchedules();

        mAdapter = new ScheduleAdapter(schedules);
        mScheduleRecyclerView.setAdapter(mAdapter);
    }

    public MenuInflater getMenuInflater() {
        return inflater;
    }

    private class ScheduleHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Schedule mSchedule;

        public ScheduleHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_schedule, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.schedule_title);
        }

        public void bind(Schedule schedule) {
            mSchedule = schedule;
            mTitleTextView.setText(mSchedule.getName());
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(), CourseListActivity.class);
            startActivity(intent);
        }
    }

    private class ScheduleAdapter extends RecyclerView.Adapter<ScheduleHolder> {

        private List<Schedule> mSchedules;

        public ScheduleAdapter(List<Schedule> schedules) {
            mSchedules = schedules;
        }

        @Override
        public ScheduleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ScheduleHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(ScheduleHolder holder, int position) {
            Schedule schedule = mSchedules.get(position);
            holder.bind(schedule);
        }

        @Override
        public int getItemCount() {
            return mSchedules.size();
        }

        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_delete:
                    for (Object item : toDelete) {
                        mSchedules.remove(item);
                    }
                    actionMode.finish();
                    return true;
                default:
                    return false;
            }
        }

        public void onDestroyActionMode(ActionMode actionMode) {
            toDelete.clear();
        }
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sub_toolbar, menu);
        return true;
    }

    public void onItemCheckedStateChanged(ActionMode actionMode, int position, long id, boolean checked) {
        if (checked) {
            toDelete.add(mAdapter.getItemId(position));
        } else {
            toDelete.remove(mAdapter.getItemId(position));
        }
    }



    private int calculatePosition(String StartTime) { //Figure out where the class should show up on the schedule, in dp
        int position=0;
        String hour="";
        String minute="";
        char AM_PM;

        int i=0;
        while (StartTime.charAt(i) != ':') {
            hour=hour+StartTime.charAt(0);
            i++;
        }
            i++;
        while(StartTime.charAt(i)!='A' && StartTime.charAt(i)!='P') {
            minute=minute+StartTime.charAt(i);
            i++;
        }
        AM_PM=StartTime.charAt(i);

        if(AM_PM=='A' || hour=="12") {
            position=30*(Integer.parseInt(hour) - 8) + (Integer.parseInt(minute)/2); // 8:00AM=0dp 9:00AM=30dp 10:00AM=60dp 11:AM=90dp 12:00PM=120dp
        }
        else {
            position=30*(Integer.parseInt(hour) + 4) + (Integer.parseInt(minute)/2); // 1:00PM=150dp 11:00PM=450dp
        }

        return position;
    }

    private int calculateLengthOfCourse(String StartTime, String EndTime) { //Figure out how the height of a course, in dp
        int height=0;

        String hourStartString="";
        int hourStart=0;
        String minuteStart="";
        char AM_PM_Start;

        String hourEndString="";
        int hourEnd=0;
        String minuteEnd="";
        char AM_PM_End;

        int timeStart=0;
        int timeEnd=0;

        int i=0;
        while (StartTime.charAt(i) != ':') {
            hourStartString=hourStartString+StartTime.charAt(0);
            i++;
        }
        i++;
        while(StartTime.charAt(i)!='A' && StartTime.charAt(i)!='P') {
            minuteStart=minuteStart+StartTime.charAt(i);
            i++;
        }
        AM_PM_Start=StartTime.charAt(i);
        if(AM_PM_Start=='A' || hourStartString=="12") {
            hourStart= Integer.parseInt(hourStartString);
        }
        else {
            hourStart= Integer.parseInt(hourStartString) + 12;
        }
        timeStart=60*hourStart + Integer.parseInt(minuteStart);

        i=0;
        while (EndTime.charAt(i) != ':') {
            hourEndString=hourEndString+EndTime.charAt(0);
            i++;
        }
        i++;
        while(EndTime.charAt(i)!='A' && EndTime.charAt(i)!='P') {
            minuteEnd=minuteEnd+EndTime.charAt(i);
            i++;
        }
        AM_PM_End=EndTime.charAt(i);
        if(AM_PM_End=='A' || hourEndString=="12") {
            hourEnd= Integer.parseInt(hourEndString);
        }
        else {
            hourEnd= Integer.parseInt(hourEndString) + 12;
        }
        timeEnd=60*hourEnd + Integer.parseInt(minuteEnd);

        height=timeEnd-timeStart;

        return height;
    }

}
