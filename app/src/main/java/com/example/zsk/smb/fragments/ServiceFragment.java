package com.example.zsk.smb.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.zsk.smb.OnlineDoctor;
import com.example.zsk.smb.R;

/**
 * Created by zsk on 2018/3/26.
 */

public class ServiceFragment extends Fragment{

    public static ServiceFragment newInstance(String from){
        ServiceFragment fragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from",from);
        fragment.setArguments(bundle);
        return fragment;
    }
//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        if(getArguments()!=null){
//            mFrom = getArguments().getString("from");
//        }
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.smb_service_fragment,null);
        ListView lv = (ListView)view.findViewById(R.id.clockListView);
        ClockAdapter ca = new ClockAdapter();
        lv.setAdapter(ca);
        return view;
    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View V) {
//            int i = 1/0;
            if (V.getId() == R.id.Activity_AllFunctions_ImageView_Function1) {
//                int i = 1/0;


            } else if (V.getId() == R.id.Activity_AllFunctions_ImageView_Function2) {

                //Intent intent = new Intent(getContext(), );
                //startActivity(intent);
            } else if (V.getId() == R.id.Activity_AllFunctions_ImageView_Function3) {
                Intent intent = new Intent(getContext(), OnlineDoctor.class);
                startActivity(intent);
            } else if (V.getId() == R.id.Activity_AllFunctions_ImageView_Function4) {

                //Intent intent = new Intent(getContext(), t2.class);
                //startActivity(intent);
            } else if (V.getId() == R.id.Activity_AllFunctions_ImageView_Function5) {
                //Intent intent = new Intent(getContext(), Activity_Matk_Mainpage.class);
                //startActivity(intent);
            } else if (V.getId() == R.id.Activity_AllFunctions_ImageView_Function6) {

                //Intent intent = new Intent(getContext(), t3.class);
                //startActivity(intent);
            }
        }

    }

    class ClockAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 3;//数目
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getActivity().getLayoutInflater();
            View view;

            if (convertView==null) {
                //因为getView()返回的对象，adapter会自动赋给ListView
                view = inflater.inflate(R.layout.clock_item, null);
            }else{
                view=convertView;
                Log.i("info","有缓存，不需要重新生成"+position);
            }

            return view;
        }
        @Override
        public long getItemId(int position) {//取在列表中与指定索引对应的行id
            return 0;
        }
        @Override
        public Object getItem(int position) {//获取数据集中与指定索引对应的数据项
            return null;
        }
    };


}