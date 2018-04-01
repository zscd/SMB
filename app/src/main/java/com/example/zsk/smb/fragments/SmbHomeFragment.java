package com.example.zsk.smb.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zsk.smb.R;

/**
 * Created by zsk on 2018/3/24.
 */

public class SmbHomeFragment extends Fragment {
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        view = inflater.inflate(R.layout.smb_detail_fragment,container,false);
        return view;
    }

}

