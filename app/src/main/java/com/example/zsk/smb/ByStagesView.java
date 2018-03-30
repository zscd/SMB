package com.example.zsk.smb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.jar.Attributes;

/**
 * Created by vicsun on 2018/3/30.
 */

public class ByStagesView extends LinearLayout {
    private LinearLayout ll_1;
    private TextView tv_start;
    private TextView tv_end;
    private Context c;
    protected static int[] colors = {0xfffff5ee, 0xffffe4c4, 0xffdcdcdc}; //清醒、浅睡、深睡

    public ByStagesView(Context context, AttributeSet attrs){
        super(context, attrs);
        c = context;
        LayoutInflater.from(context).inflate(R.layout.bystages, this);

        ll_1 = (LinearLayout) findViewById(R.id.bystages_stages);
        tv_start = (TextView) findViewById(R.id.bystages_tv_start);
        tv_end = (TextView) findViewById(R.id.bystages_tv_end);
    }
    public void setData(ByStagesData b){
        tv_start.setText(b.getStart());
        tv_end.setText(b.getEnd());
        float[] time = b.getWeight();
        int[] classes = b.getSvalue();

        for (int i = 0; i < b.getCount(); i++){
            View v = new View(c);
            v.setBackgroundColor(colors[classes[i]]);
            LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
            lp.weight = time[i];
            lp.width = 0;
            v.setLayoutParams(lp);
            ll_1.addView(v);
        }

    }
}
