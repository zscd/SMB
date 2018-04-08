package com.example.zsk.smb.fragments;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zsk.smb.R;

/**
 * Created by zsk on 2018/3/26.
 */

public class ServiceFragment extends Fragment{
    private String mFrom;

    public static ServiceFragment newInstance(String from){
        ServiceFragment fragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from",from);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mFrom = getArguments().getString("from");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.smb_service_fragment,null);
        //TextView textView = (TextView) view.findViewById(R.id.title_from);
        //TextView content = (TextView) view.findViewById(R.id.fragment_content);
        //textView.setText(mFrom);
        //content.setText("ProfileFragment");
        return view;
    }

}
