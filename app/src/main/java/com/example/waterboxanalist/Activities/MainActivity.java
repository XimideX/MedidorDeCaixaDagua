package com.example.waterboxanalist.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.waterboxanalist.FunctionalClasses.WaterBox;
import com.example.waterboxanalist.R;
import com.example.waterboxanalist.ReportsClasses.Reports;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    TextView meterPercent;
    Button meterButton;
    Button goToReportsAndChartButton;
    WaterBox waterBox;
    ProgressBar percentageBar;
    List<Integer> waterBoxHistoryList;
    Reports reports;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reports = new Reports();


        waterBox = new WaterBox();
        waterBox.setTotalHeight(200);
        meterButton = findViewById(R.id.meterButton);
        goToReportsAndChartButton = findViewById(R.id.goToReportsAndChart);
        meterPercent = (TextView) findViewById(R.id.meterText);
        percentageBar = findViewById(R.id.percentageBar);


        waterBoxHistoryList = new ArrayList<Integer>();
        listView = findViewById(R.id.percentHistory);
        meterButton.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showPercent();
                    }
                }
        );

        goToReportsAndChartButton.setOnClickListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        reports.CreateNotification(this.getBaseContext());
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.hangouts_incoming_call);
        mp.start();
    }

    public void showPercent() {

        int percentWaterBox = (int) waterBox.CalculatePercent(Integer.parseInt(meterPercent.getText().toString()));
        Toast.makeText(this, "percent " + percentWaterBox, Toast.LENGTH_SHORT).show();
        percentageBar.setProgress(percentWaterBox);
        waterBoxHistoryList.add(percentWaterBox);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, waterBoxHistoryList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.goToReportsAndChart) {
            Intent intent = new Intent(MainActivity.this, ReportsAndChartsActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
