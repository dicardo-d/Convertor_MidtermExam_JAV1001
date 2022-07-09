package com.example.convertor_midtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
  // creating array for the spinner
        String[] Conversion = {"in to cm", "cm to in", "miles to km","km to miles","lb to kg", "kg to lb","oz to gram", "gram to oz","cups to liter", "liter to cups", "c to f" , "f to c", "c to k", "f to k"};
        String currentValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinner3);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Conversion, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);


        EditText yourEditText = (EditText) findViewById(R.id.editText1);
        EditText yourEditText2 = (EditText) findViewById(R.id.editText2);

        Button button = (Button) findViewById(R.id.calCButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (yourEditText.getText().toString().isEmpty()) {
                    yourEditText2.setText("please enter a valid value");
                }
                else if (spin.getSelectedItem().equals("in to cm")) {
                            yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText())) * 2.54));
                        }
                else if (spin.getSelectedItem().equals("cm to in")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText())) / 2.54));
                }
                else if (spin.getSelectedItem().equals("km to miles")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText())) * 0.62));
                }
                else if (spin.getSelectedItem().equals("miles to km")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText()))  * 1.60934));
                }
                else if (spin.getSelectedItem().equals("kg to lb")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText()))  * 2.2));
                }
                else if (spin.getSelectedItem().equals("lb to kg")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText()))  * 0.45));
                }
                else if (spin.getSelectedItem().equals("gram to oz")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText()))  * 0.04));
                }
                else if (spin.getSelectedItem().equals("oz to gram")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText()))  * 28.35));
                }
                else if (spin.getSelectedItem().equals("liter to cups")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText()))  * 4.17));
                }
                else if (spin.getSelectedItem().equals("cups to liter")) {
                    yourEditText2.setText(String.valueOf(Double.parseDouble(String.valueOf(yourEditText.getText()))   * 0.24));
                }
                else if (spin.getSelectedItem().equals("c to f")) {
                    Double tempValue = Double.parseDouble(String.valueOf(yourEditText.getText()));
                    yourEditText2.setText(String.valueOf((tempValue * 1.8) + 32));
                }
                else if (spin.getSelectedItem().equals("f to c")) {
                    Double tempValue = Double.parseDouble(String.valueOf(yourEditText.getText()));
                    yourEditText2.setText(String.valueOf((tempValue - 32) * 5/9));
                }
                else if (spin.getSelectedItem().equals("c to k")) {
                    Double tempValue = Double.parseDouble(String.valueOf(yourEditText.getText()));
                    yourEditText2.setText(String.valueOf(tempValue + 273.15));
                }
                else if (spin.getSelectedItem().equals("f to k")) {
                Double tempValue = Double.parseDouble(String.valueOf(yourEditText.getText()));
                yourEditText2.setText(String.valueOf((tempValue - 32)* 5/9 +273.15));
            }
                else {
                    yourEditText.setText("not a valid number");
                }




            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        //you get the position
        // variable to store position ex 4

        currentValue = Conversion[position];
   //     toast.makeText(getApplicationContext(),Conversion[position], Toast.LENGTH_LONG).show);
     }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}