package com.example.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        EditText editTextFirst = findViewById(R.id.etFirst);
        EditText editTextSecond = findViewById(R.id.etSecond);
        Button btnCalc = findViewById(R.id.btnStart);
        btnCalc.setOnClickListener(v -> {
            String firstTermStr=editTextFirst.getText().toString();
            String secondTermStr=editTextSecond.getText().toString();
            if (!firstTermStr.isEmpty() && !secondTermStr.isEmpty()){
                double first = Double.parseDouble(firstTermStr);
                double second = Double.parseDouble(secondTermStr);
                if (second>0){
                    double result = first/second;
                    Intent intent = new Intent();
                    intent.putExtra("data",result);
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Invailed terms",Toast.LENGTH_LONG).show();
                }



            }else {
                Toast.makeText(getApplicationContext(),"Invailed terms",Toast.LENGTH_LONG).show();
            }
        });

    }
}