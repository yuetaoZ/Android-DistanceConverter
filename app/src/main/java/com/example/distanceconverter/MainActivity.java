package com.example.distanceconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.distanceconverter.R.id;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private boolean convertFromMilesToKilometers = true;
    private TextView convertHistorySlot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertHistorySlot = findViewById(id.conversionHistoryRecord);
        convertHistorySlot.setMovementMethod(new ScrollingMovementMethod());
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
            inputValueSlot.setText("");
        }
    }

    private void updateConvertHistory(double inputNumber, double outputNumber) {
        String convertHistory = convertHistorySlot.getText().toString();
        String inputType, outputType;
        inputType = convertFromMilesToKilometers == true ? " Mi" : " Km";
        outputType = convertFromMilesToKilometers == true ? " Km" : " Mi";

        convertHistorySlot.setText(new DecimalFormat("##.#").format(inputNumber) + inputType + " ==> "
                                    + new DecimalFormat("##.#").format(outputNumber) + outputType + "\n"
                                    + convertHistory);
    }

    public void clearConvertHistory(View v) {
        TextView outputValueSlot = findViewById(id.outputValue);

        convertHistorySlot.setText("");
        outputValueSlot.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("CONVERT_HISTORY", convertHistorySlot.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // Call super first
        super.onRestoreInstanceState(savedInstanceState);

        convertHistorySlot.setText(savedInstanceState.getString("CONVERT_HISTORY"));
    }

}