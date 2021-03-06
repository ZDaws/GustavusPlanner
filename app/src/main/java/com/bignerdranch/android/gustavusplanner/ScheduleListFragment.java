package com.bignerdranch.android.gustavusplanner;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScheduleListFragment extends Fragment {

    //final Context context = this;
    private String result;
    private RecyclerView mScheduleRecyclerView;
    private ScheduleAdapter mAdapter;
    private TextView mScheduleTitleTextView;
    private TextView mScheduleDateTextView;
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
    public void onResume() {
        super.onResume();
        updateUI();
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
                LayoutInflater li = LayoutInflater.from(getContext());
                View promptsView = li.inflate(R.layout.schedule_name_prompt, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView.findViewById(R.id.editTextDialogUserInput);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text
                                        Schedule schedule = new Schedule();
                                        result = userInput.getText().toString();
                                        schedule.setName(result);
                                        ScheduleLab.get(getActivity()).addSchedule(schedule);
                                        Intent intent = CourseListActivity
                                                .newIntent(getActivity(), schedule.getId());
                                        startActivity(intent);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateUI() {
        ScheduleLab scheduleLab = ScheduleLab.get(getActivity());
        List<Schedule> schedules = scheduleLab.getSchedules();

        if (mAdapter == null) {
            mAdapter = new ScheduleAdapter(schedules);
            mScheduleRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setSchedules(schedules);
            mAdapter.notifyDataSetChanged();
        }
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

            mScheduleTitleTextView = (TextView) itemView.findViewById(R.id.schedule_title);
            mScheduleDateTextView = (TextView) itemView.findViewById(R.id.schedule_date);
        }

        public void bind(Schedule schedule) {
            mSchedule = schedule;
            mScheduleTitleTextView.setText(mSchedule.getName());
            mScheduleDateTextView.setText(DateFormat.format("EEEE, MMM d, yyyy",
                    mSchedule.getDate()));
        }

        @Override
        public void onClick(View view) {
            Intent intent = CourseListActivity
                    .newIntent(getActivity(), mSchedule.getId());
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

        public void setSchedules(List<Schedule> schedules) {
            mSchedules = schedules;
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

}
