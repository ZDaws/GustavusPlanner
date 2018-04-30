package com.bignerdranch.android.gustavusplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ScheduleListFragment extends Fragment {

    private RecyclerView mScheduleRecyclerView;
    private ScheduleAdapter mAdapter;
    private TextView mTitleTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_list, container, false);

        mScheduleRecyclerView = (RecyclerView) view.findViewById(R.id.schedule_recycler_view);
        mScheduleRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        ScheduleLab scheduleLab = ScheduleLab.get(getActivity());
        List<Schedule> schedules = scheduleLab.getSchedules();

        mAdapter = new ScheduleAdapter(schedules);
        mScheduleRecyclerView.setAdapter(mAdapter);
    }

    private class ScheduleHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {

        private Schedule mSchedule;
        public ScheduleHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_schedule, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.schedule_title);
        }
        public void bind (Schedule schedule) {
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
    }

}
