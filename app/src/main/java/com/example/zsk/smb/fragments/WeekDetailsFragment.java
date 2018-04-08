package com.example.zsk.smb.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zsk.smb.ByStagesData;
import com.example.zsk.smb.ByStagesView;
import com.example.zsk.smb.R;

/**
 * Created by zsk on 2018/3/28.
 */

public class WeekDetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.smb_detail_week_fragment,null);
        ByStagesView bs = (ByStagesView) view.findViewById(R.id.smb_week_bs);
        ByStagesData bsd = new ByStagesData();
        bsd.setStart("22:30");
        bsd.setEnd("7:35");
        bsd.setStime(new float[]{15, (float)60.5, 56, 78 , 156, 5, 56});
        bsd.setSvalue(new int[]{1,2,1,2,1,0,1});
        bs.setData(bsd);
        return view;
    }
}
