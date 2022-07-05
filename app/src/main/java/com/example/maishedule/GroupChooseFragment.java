package com.example.maishedule;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GroupChooseFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choose_group, container, false);

        getActivity().findViewById(R.id.start).setVisibility(View.GONE);

        List<Group> groups = getArguments().getParcelableArrayList("parced_info");

        RecyclerView groupRecycledView = (RecyclerView) view.findViewById(R.id.recycler);
        GroupAdapter .OnGroupClickListener groupClickListener = new GroupAdapter.OnGroupClickListener() {
            @Override
            public void onGroupClick(Group group, int position) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("sPref",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("sPref",group.getGroup());
                editor.commit();
                getActivity().findViewById(R.id.start).setVisibility(View.VISIBLE);
                TextView textView = getActivity().findViewById(R.id.empty_view);
                textView.setText("Выбранная группа: " + sharedPreferences.getString("sPref", null));
                getParentFragmentManager().popBackStack();

                //Log.e("ПРОВЕРКА", group.getGroup());
            }
        };
        groupRecycledView.setAdapter(new GroupAdapter(getContext(),groups,groupClickListener));
    return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}
