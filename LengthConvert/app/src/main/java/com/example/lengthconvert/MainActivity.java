package com.example.lengthconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    Spinner spinnerDropDownImperial;
    Spinner spinnerDropDownMetric;
    Button convertButton;
    TextView OutPutTextView;

    TextInputEditText inputLength;

    //double InputLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //drop down 1
        spinnerDropDownImperial = findViewById(R.id.DropDownImperial);
        //drop down 2
        spinnerDropDownMetric = findViewById(R.id.DropDownMetric);
        //convert button
        convertButton = findViewById(R.id.buttonConvert);

        inputLength = findViewById(R.id.InputLength);

        OutPutTextView = findViewById(R.id.OutputTextView);

        //drop down 1 items
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.DropDownImperialItems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerDropDownImperial.setAdapter(adapter);

        //drop down 2 items
        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this, R.array.DropDownMetricItems, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerDropDownMetric.setAdapter(adapter2);

        //convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String inputValueImp = spinnerDropDownImperial.getSelectedItem().toString();
                String inputValueMet = spinnerDropDownMetric.getSelectedItem().toString();

                double InputValue = Double.parseDouble(inputLength.getText().toString());
                double foot;
                double output;

                switch (inputValueImp){
                    case "Inch":
                        foot = InputValue * .0833;
                        break;
                    case "Foot":
                        foot = InputValue;
                        break;
                    case "Yard":
                        foot = InputValue * 3;
                        break;
                    default:
                        foot = 0;
                        Toast.makeText(MainActivity.this, "Invalid Imperial Selection", Toast.LENGTH_LONG).show();
                }

                switch (inputValueMet){
                    case "Centimetre":
                        output = foot * 30.48;
                        break;
                    case "Meter":
                        output = foot * .3048;
                        break;
                    default:
                        output = 0;
                        Toast.makeText(MainActivity.this, "Invalid Metric Selection", Toast.LENGTH_LONG).show();
                }

                OutPutTextView.setText(InputValue + " " + inputValueImp + " = " + output + " " + inputValueMet);

            }
        });




    }
}