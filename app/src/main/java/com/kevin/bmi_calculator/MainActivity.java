package com.kevin.bmi_calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    double result;
    Button btnConvert;
    EditText categoryText;

    String category;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(view -> {
            EditText weightText, heightText, resultText;
            weightText = (EditText) findViewById(R.id.weightText);
            heightText = (EditText) findViewById(R.id.heightText);

            double weight = Double.parseDouble(weightText.getText().toString());


            double height = Double.parseDouble(heightText.getText().toString());

//                Calculate the BMI
            result = weight / (height * height);

            resultText = (EditText) findViewById(R.id.resultText);
            resultText.setText(Double.toString(result));

//            Determine the category of the BMI calculated
            if (result <= 15) {
                category = "Very severely underweight";
            } else if (result > 15 && result <= 16) {
                category = "Severely underweight";
            } else if (result > 16 && result <= 18.5) {
                category = "Underweight";
            } else if (result > 18.5 && result <= 25) {
                category = "Healthy weight";
            } else {
                category = "Overweight";
            }

            categoryText = (EditText) findViewById(R.id.categoryText);
            categoryText.setText(category);
        });

    }
}