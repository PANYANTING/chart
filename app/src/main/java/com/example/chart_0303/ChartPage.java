package com.example.chart_0303;

import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


import android.os.Bundle;

public class ChartPage extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_page);

        TabHost tabHost = getTabHost();

        TabSpec spec = tabHost.newTabSpec("t1");
        Intent it1 = new Intent(this,ChartPage_category.class);

        spec.setContent(it1); //Setting the activity of t1
        spec.setIndicator("分類報告");  // Naming the name of Tab
        tabHost.addTab(spec);

        TabSpec spec2 = tabHost.newTabSpec("t2");
        Intent it2 = new Intent(this,ChartPage_Month.class);

        spec2.setContent(it2);
        spec2.setIndicator("花費趨勢");
        tabHost.addTab(spec2);


        tabHost.setCurrentTab(1); // Setting the default Tab
    }
}