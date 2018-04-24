package com.example.zsk.smb.fragments;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

import com.example.zsk.smb.R;
import com.example.zsk.smb.TabActivity;
//import com.shinelw.library.ColorArcProgressBar;
import com.example.zsk.smb.ColorArcProgressBar;
//import static com.example.zsk.smb.R.id.textView;

/**
 * Created by zsk on 2018/3/26.
 */

public class HomeFragment extends Fragment{

    private String mFrom;
    private ColorArcProgressBar bar1;

    public static HomeFragment newInstance(String from){
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.smb_home_fragment,null);
        Button button = (Button) view.findViewById(R.id.fragment_more_info_button);
        bar1 = (ColorArcProgressBar)view.findViewById(R.id.smb_homefragment_score);
        bar1.setCurrentValues(72);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(getActivity(), TabActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}

