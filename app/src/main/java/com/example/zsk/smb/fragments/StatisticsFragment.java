package com.example.zsk.smb.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.zsk.smb.DetailsActivity;
import com.example.zsk.smb.R;

import java.util.ArrayList;
import java.util.List;


public class StatisticsFragment extends Fragment {
    private ListView listView;
    public static StatisticsFragment newInstance(String from){
        StatisticsFragment fragment = new StatisticsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from",from);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test,null);
        listView = (ListView)view.findViewById(R.id.testListView);
        HistoryAdapter adapter = new HistoryAdapter(getContext(), R.layout.listview_item);

        adapter.add("2018/03/28");
        adapter.add("2018/03/29");
        adapter.add("2018/03/30");
        adapter.add("2018/03/31");
        adapter.add("2018/04/01");
        adapter.add("2018/04/02");
        adapter.add("2018/04/03");
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String date = (String) listView.getItemAtPosition(position);
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
        return view;
    }

    class HistoryAdapter extends ArrayAdapter<String> {
        private int mResourceId;

        public HistoryAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
            this.mResourceId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String date = getItem(position);
            LayoutInflater inflater = getLayoutInflater(null);
            View view = inflater.inflate(mResourceId, null);
            TextView history_item = (TextView) view.findViewById(R.id.history_item);

            history_item.setText(date);

            return view;
        }
    }
}
