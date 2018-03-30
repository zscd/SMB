package com.example.zsk.smb;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class testBSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bs);
        ByStagesView bs = (ByStagesView)findViewById(R.id.test_bs);
        ByStagesData bsd = new ByStagesData();
        bsd.setStart("21:30");
        bsd.setEnd("4:30");
        bsd.setStime(new float[]{15, (float)60.5, 56, 78 , 156, 5, 56});
        bsd.setSvalue(new int[]{1,2,1,2,1,0,1});
        bs.setData(bsd);
    }

}
