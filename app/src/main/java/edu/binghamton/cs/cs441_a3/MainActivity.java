package edu.binghamton.cs.cs441_a3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private SeekBar seekBar;
    private TextView seekBarValue;
    private TextView fValueText;
    private int fahrenheitValue;

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

        seekBarValue = findViewById(R.id.seekBarValue);
        fValueText = findViewById(R.id.fahrenheitValue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fahrenheitValue = (progress * 9/5) + 32;
                seekBarValue.setText("Celsius: " + progress);
                fValueText.setText("Fahrenheit: " + fahrenheitValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

public void openActivity2() {
        Intent i = new Intent(this, Activity2.class);
        startActivity(i);
    }
}
