package com.example.maishedule;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ConcurrentModificationException;
import java.util.List;

public class SheduleFragment extends Fragment {

    private Information mInformation;

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shedule_list, container, false);

        List<Group> groups = getArguments().getParcelableArrayList("parced_info");
        SharedPreferences sPref =  getActivity().getSharedPreferences("sPref", Context.MODE_PRIVATE);
        String group = sPref.getString("sPref",null);
        // if (sPref.contains("sPref"))
        Log.e("ПРОВЕРКА", group);
        RecyclerView sheduleRecycledView = (RecyclerView) view.findViewById(R.id.list);
        SheduleAdapter.OnSheduleClickListener sheduleClickListener = new SheduleAdapter.OnSheduleClickListener() {
            @Override
            public void onSheduleClick(Group groups, int position) {
                //Intent infoIntent = new Intent(SheduleFragment.this, Information.class);
                //infoIntent.putExtra("shedule",groups);
                //startActivity(infoIntent);
            }
        };
        sheduleRecycledView.setAdapter(new SheduleAdapter(getContext(),groups, sheduleClickListener));

        return view;
    }

   // @Override
   // public void onLoadFinished(Loader<List<Group>> loader,List<Group> groups) {
    //    mProgressBar.setVisibility(View.GONE);

    //    mEmptyStateTextView.setText("Расписание не найдено.");

     //   if(groups != null && !groups.isEmpty()) {
      //      mEmptyStateTextView.setVisibility(View.GONE);
      //      RecyclerView sheduleRecycledView = (RecyclerView) findViewById(R.id.list);
       //     SheduleAdapter.OnSheduleClickListener sheduleClickListener = new SheduleAdapter.OnSheduleClickListener() {
        //        @Override
      //          public void onSheduleClick(Group shedule, int position) {
                    //Intent infoIntent = new Intent(SheduleFragment.this, Information.class);
                    //infoIntent.putExtra("shedule",shedule);
                    //startActivity(infoIntent);
      //          }
      //      };
     //       mAdapter = new SheduleAdapter(this, groups, sheduleClickListener);
     //       sheduleRecycledView.setAdapter(mAdapter);
     //   }
    //}
}
