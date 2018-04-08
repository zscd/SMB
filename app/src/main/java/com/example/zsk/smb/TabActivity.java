package com.example.zsk.smb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zsk.smb.fragments.DayDetailsFragment;
import com.example.zsk.smb.fragments.MonthDetailsFragment;
import com.example.zsk.smb.fragments.WeekDetailsFragment;

import java.util.ArrayList;
import java.util.List;

public class TabActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewpager;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tabLayout = (TabLayout)findViewById(R.id.tab);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DayDetailsFragment());
        fragments.add(new WeekDetailsFragment());
        fragments.add(new MonthDetailsFragment());

        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getSupportFragmentManager(), fragments, new String[]{"日", "周", "月"});
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);
    }
}
