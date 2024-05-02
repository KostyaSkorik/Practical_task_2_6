package com.example.simpleapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.DatagramPacket;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    private TextView tvTextValue;
    private Button btnStart;
    private DecimalFormat myformat = new DecimalFormat("#.###");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.btnStartActivity);
        tvTextValue=findViewById(R.id.tvText);
        btnStart.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Log.i("simple_app_tag","Click start button");
        if (v.getId()==R.id.btnStartActivity){
            Intent intent = new Intent(this,CalcActivity.class);
            activityResultLaunch.launch(intent);

        }
    }

    ActivityResultLauncher<Intent> activityResultLaunch=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData()!=null){
                        double res=result.getData().getDoubleExtra("data",0);
                        Log.d("simple_app_tag","Result: "+myformat.format(res));
                        tvTextValue.setText("Результат деления: "+myformat.format(res));
                    }
                }
            });

}