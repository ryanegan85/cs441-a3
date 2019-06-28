package edu.binghamton.cs.cs441_a3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private SeekBar seekBar;
    private TextView cValueText;
    private TextView fValueText;
    private EditText fValue;
    private EditText cValue;
    private int fahrenheitValue;
    private int celsiusValue;
    private boolean setChanged = false;
    private String cAndFString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(100);

        cValueText = findViewById(R.id.seekBarValue);
        fValueText = findViewById(R.id.fahrenheitValue);

        fValue = findViewById(R.id.editFahrenheit);
        cValue = findViewById(R.id.editCelsius);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    fahrenheitValue = (progress * 9/5) + 32;
                    cValueText.setText("Celsius: " + progress);
                    fValueText.setText("Fahrenheit: " + fahrenheitValue);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        fValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!setChanged) {
                    if (count > 0) {
                        int temp = Integer.parseInt(s.toString());
                        if (temp < 32) temp = 32;
                        if (temp > 212) temp = 212;
                        fahrenheitValue = temp;

                        setChanged = true;
                        celsiusValue = (fahrenheitValue - 32) * 5 / 9;
                        cValueText.setText("Celsius: " + celsiusValue);
                        fValueText.setText("Fahrenheit: " + fahrenheitValue);
                        seekBar.setProgress(celsiusValue);
                        cValue.setText(Integer.toString(celsiusValue), TextView.BufferType.EDITABLE);
                    }
                } else {
                    setChanged = false;
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!setChanged) {
                    if (count > 0) {
                        int temp = Integer.parseInt(s.toString());
                        if (temp < 0) temp = 0;
                        if (temp > 100) temp = 100;
                        celsiusValue = temp;
                    }

                    setChanged = true;
                    fahrenheitValue = (celsiusValue * 9 / 5) + 32;
                    cValueText.setText("Celsius: " + celsiusValue);
                    fValueText.setText("Fahrenheit: " + fahrenheitValue);
                    seekBar.setProgress(celsiusValue);
                    fValue.setText(Integer.toString(fahrenheitValue), TextView.BufferType.EDITABLE);
                } else {
                    setChanged = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

public void openActivity2() {
        Intent i = new Intent(this, Activity2.class);
        cAndFString = fahrenheitValue + " F, " + celsiusValue + " C!";
        i.putExtra("TEMP_STRING", "The current temperature is " + cAndFString);
        i.putExtra("TEMP_VALUE", Integer.toString(celsiusValue));
        startActivity(i);
    }
}
