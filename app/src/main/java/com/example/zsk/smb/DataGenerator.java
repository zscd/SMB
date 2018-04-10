package com.example.zsk.smb;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zsk.smb.fragments.HomeFragment;
import com.example.zsk.smb.fragments.ProfileFragment;
import com.example.zsk.smb.fragments.ServiceFragment;
import com.example.zsk.smb.fragments.StatisticsFragment;

/**
 * Created by vicsun on 2018/3/5.
 */

public class DataGenerator {

    public static final int []mTabRes = new int[]{R.drawable.home_frag,R.drawable.service,R.drawable.statistic,R.drawable.mine};
    public static final int []mTabResPressed = new int[]{R.drawable.home_frag_checked,R.drawable.service_checked,R.drawable.statistic_check,R.drawable.mine_checked};
    public static final String[]mTabTitle = new String[]{"首页","服务","统计","我的"};

    public static Fragment[] getFragments(String from){
        Fragment fragments[] = new Fragment[4];
        fragments[0] = HomeFragment.newInstance(from);
        fragments[1] = ServiceFragment.newInstance(from);
        fragments[2] = StatisticsFragment.newInstance(from);
        fragments[3] = ProfileFragment.newInstance(from);
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content,null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);               //将点击的图标改为被点击后的图标
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }
}
