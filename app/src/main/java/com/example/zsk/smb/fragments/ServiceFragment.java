package com.example.zsk.smb.fragments;

import android.content.Intent;
import android.print.PrinterCapabilitiesInfo;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.zsk.smb.MyFamilyActivity;
import com.example.zsk.smb.OnlineDoctor;
import com.example.zsk.smb.R;
import com.example.zsk.smb.SetClockActivity;

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
        ImageView imageview_1 = (ImageView)view.findViewById(R.id.Activity_AllFunctions_ImageView_Function1);
        ImageView imageview_3 = (ImageView)view.findViewById(R.id.Activity_AllFunctions_ImageView_Function3);
        imageview_1.setOnClickListener(new MyClickListener());
        imageview_3.setOnClickListener(new MyClickListener());
        return view;
    }

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View V) {
//            int i = 1/0;
            if (V.getId() == R.id.Activity_AllFunctions_ImageView_Function1) {
//                int i = 1/0;
                Intent intent = new Intent(getContext(), SetClockActivity.class);
                startActivity(intent);

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

}