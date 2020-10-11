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
        EditText inputValueSlot = findViewById(id.inputValue);
        TextView outputValueSlot = findViewById(id.outputValue);

        if (!inputValueSlot.getText().toString().isEmpty()) {
            String text = inputValueSlot.getText().toString();
            double inputNumber = Double.parseDouble(text);
            double outputNumber = convertFromMilesToKilometers == true ? (inputNumber * 1.60934) : (inputNumber * 0.621371);
            outputValueSlot.setText(new DecimalFormat("##.#").format(outputNumber));

            updateConvertHistory(inputNumber, outputNumber);
        }
    }

    private void updateConvertHistory(double inputNumber, double outputNumber) {
        TextView convertHistorySlot = findViewById(id.conversionHistoryRecord);
        String convertHistory = convertHistorySlot.getText().toString();
        String inputType, outputType;
        inputType = convertFromMilesToKilometers == true ? " Mi" : " Km";
        outputType = convertFromMilesToKilometers == true ? " Km" : " Mi";

        convertHistorySlot.setText(new DecimalFormat("##.#").format(inputNumber) + inputType + " ==> "
                                    + new DecimalFormat("##.#").format(outputNumber) + outputType + "\n"
                                    + convertHistory);
    }


}