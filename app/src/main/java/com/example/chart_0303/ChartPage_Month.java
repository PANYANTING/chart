package com.example.chart_0303;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.HashMap;

public class ChartPage_Month extends AppCompatActivity {
    LineChart lineChart;
    //SQLiteDataBaseHelper mDBHelper;
    //ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//取得所有資料
    //ArrayList<HashMap<String, String>> getNowArray = new ArrayList<>();//取得被選中的項目資料


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_page_month);

        //arrayList = mDBHelper.showAll();//撈取資料表內所有資料

        lineChart=(LineChart)findViewById(R.id.chart);
        xtext();
        ytext();

        //創建圖表顯示的訊息
        Description description=new Description();
        description.setText("線圖");
        description.setTextSize(20);
        description.setTextColor(Color.GRAY);
        lineChart.setDescription(description);

        //修改圖例
        Legend legend=lineChart.getLegend();
        legend.setTextSize(10);

        //沒資料時的顯示畫面
        lineChart.setNoDataText("沒有資料~~~");
        lineChart.setNoDataTextColor(Color.RED);

        //顯示線圖資料
        ArrayList<Entry> values1=new ArrayList<>();
        values1.add(new Entry(2,10));
        values1.add(new Entry(4,20));
        values1.add(new Entry(5,30));
        values1.add(new Entry(6,40));
        text_all(values1);
    }
    private void xtext() {
        XAxis xAxis=lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    }
    //設定Y軸
    private void ytext() {
        YAxis rightAxis=lineChart.getAxisRight();
        rightAxis.setEnabled(false);
    }

    private void text_all(ArrayList<Entry> values1) {
        //設定線數資料顯示方式
        LineDataSet set1;
        set1=new LineDataSet(values1, "數據資料");
        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);//直方圖
        set1.setColor(Color.BLACK);
        set1.setLineWidth(2);
        set1.setCircleRadius(4);
        set1.enableDashedHighlightLine(5,5,0);
        set1.setHighlightLineWidth(2);
        set1.setHighlightEnabled(true);
        set1.setHighLightColor(Color.RED);
        set1.setValueTextSize(20);
        set1.setDrawFilled(false);

        LineData data=new LineData(set1);
        lineChart.setData(data);
        lineChart.invalidate();
    }
}