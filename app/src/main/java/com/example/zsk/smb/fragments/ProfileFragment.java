package com.example.zsk.smb.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zsk.smb.ChangeDevice;
import com.example.zsk.smb.LoginActivity;
import com.example.zsk.smb.MyFamilyActivity;
import com.example.zsk.smb.R;



public class ProfileFragment extends Fragment {


    private String mFrom;
    public static ProfileFragment newInstance(String from){
        ProfileFragment fragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from",from);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.smb_user_fragment,null);
        RelativeLayout relativeLayout1 = (RelativeLayout)view.findViewById(R.id.user_function_1);       //我的家人
        RelativeLayout relativeLayout2 = (RelativeLayout)view.findViewById(R.id.user_function_2);       //更换设备
        RelativeLayout relativeLayout4 = (RelativeLayout)view.findViewById(R.id.user_function_4);      //退出登录
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("flag", "1");
                startActivity(intent);
                getActivity().finish();
            }
        });
        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyFamilyActivity.class);
               // intent.putExtra("flag", "1");
                startActivity(intent);
                //getActivity().finish();
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChangeDevice.class);
                // intent.putExtra("flag", "1");
                startActivity(intent);
                //getActivity().finish();
            }
        });

        return view;
    }
}
