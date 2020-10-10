package com.example.distanceconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.distanceconverter.R.id;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private boolean convertFromMilesToKilometers = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void radioClicked(View v) {
        TextView inputLabel = (TextView)findViewById(id.inputLabel);
        TextView outputLabel = (TextView)findViewById(id.outputLabel);
        switch (v.getId()) {
            case R.id.radioButtonMilesToKilometers:
                inputLabel.setText("Miles Value:");
                outputLabel.setText("Kilometers Value:");
                convertFromMilesToKilometers = true;
                break;
            case R.id.radioButtonKilometersToMiles:
                inputLabel.setText("Kilometers Value:");
                outputLabel.setText("Miles Value:");
                convertFromMilesToKilometers = false;
                break;
        }
    }

    public void convertButtonClicked(View v) {
        EditText inputValue = findViewById(id.inputValue);
        TextView outputValue = findViewById(id.outputValue);
        if (!inputValue.getText().toString().isEmpty()) {
            String text = inputValue.getText().toString();
            double inputNumber = Double.parseDouble(text);
            double output = convertFromMilesToKilometers == true ? (inputNumber * 1.60934) : (inputNumber * 0.621371);
            outputValue.setText(new DecimalFormat("##.#").format(output));
        }
    }
}