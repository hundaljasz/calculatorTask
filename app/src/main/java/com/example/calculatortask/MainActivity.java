package com.example.calculatortask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button plus,minus,calculate;
    EditText n1,n2;
    TextView res;

    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plus  = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        calculate = findViewById(R.id.cal);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        res = findViewById(R.id.result);
        plus.setOnClickListener(V -> {
            operation = "+";
        });
        minus.setOnClickListener(V -> {
            operation = "-";
        });
        calculate.setOnClickListener(V -> {
            String inputn1 = n1.getText().toString().trim();
            String inputn2 = n2.getText().toString().trim();
            if(TextUtils.isEmpty(inputn1)) {
                Toast.makeText(MainActivity.this, "Input Field Number 1 is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(inputn2)) {
                Toast.makeText(MainActivity.this, "Input Field Number 2 is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            int number1 = Integer.parseInt(inputn1);
            int number2 = Integer.parseInt(inputn2);
            if(operation == "+") {
                res.setText(number1 + " " + operation + " " + number2 + " = " + (number1+number2));
            }else if(operation == "-") {
                res.setText(number1 + " " + operation + " " + number2 + " = " + (number1-number2));
            } else {
                Toast.makeText(MainActivity.this, "Please Select an Operation.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}