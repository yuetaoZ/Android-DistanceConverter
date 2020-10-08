package com.example.distanceconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.distanceconverter.R.id;

public class MainActivity extends AppCompatActivity {

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
                break;
            case R.id.radioButtonKilometersToMiles:
                inputLabel.setText("Kilometers Value:");
                outputLabel.setText("Miles Value:");
                break;
        }
    }
}