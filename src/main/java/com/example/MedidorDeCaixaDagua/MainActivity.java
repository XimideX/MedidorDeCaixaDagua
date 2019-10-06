package com.example.MedidorDeCaixaDagua;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.FunctionalClasses.Reports;
import com.example.FunctionalClasses.WaterBoxHistory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView meterPercent;
    Button meterButton;
    WaterBox waterBox;
    ProgressBar percentageBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reports reports = new Reports();
        reports.CreateNotification(this.getBaseContext());

        waterBox = new WaterBox();
        waterBox.setTotalHeight(200);
        meterButton = new Button(this);
        meterButton = findViewById(R.id.meterButton);
        meterPercent = (TextView) findViewById(R.id.meterText);
        percentageBar = findViewById(R.id.percentageBar);


        meterButton.setOnClickListener(
            new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   showPercent();
               }
            }
        );

        List<WaterBoxHistory> waterBoxHistoryList = new ArrayList<WaterBoxHistory>();
        waterBoxHistoryList.add(reports.checkWaterBoxLevel(waterBox));


    }

    public void showPercent() {
//        final teste = meterPercent.getText();
        int percentWaterBox = (int) waterBox.CalculatePercent(Integer.parseInt(meterPercent.getText().toString()));
        Toast.makeText(this, "percent " + percentWaterBox, Toast.LENGTH_SHORT).show();
        percentageBar.setProgress(percentWaterBox);
    }
}
