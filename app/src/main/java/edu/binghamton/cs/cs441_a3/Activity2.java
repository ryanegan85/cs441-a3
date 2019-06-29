package edu.binghamton.cs.cs441_a3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    private Button button;
    private String values;
    private int celsiusValue;
    private ImageView imageView;
    private TextView textView;
    private TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        values = getIntent().getStringExtra("TEMP_STRING");
        celsiusValue = Integer.parseInt(getIntent().getStringExtra("TEMP_VALUE"));
        imageView = findViewById(R.id.imageView);
        message = findViewById(R.id.textView2);

        textView.setText(values);
        if(celsiusValue <= 10) {
            imageView.setImageResource(R.drawable.temp0to10c);
            message.setText("Better bring a jacket!");
        }
        if(celsiusValue >= 11 && celsiusValue <= 20) {
            imageView.setImageResource(R.drawable.temp11to20c);
            message.setText("A cool, crisp fall day.");
        }
        if(celsiusValue >= 21 && celsiusValue <= 30) {
            imageView.setImageResource(R.drawable.temp21to30c);
            message.setText("April showers bring May flowers.");
        }
        if(celsiusValue >= 31 && celsiusValue <= 40) {
            imageView.setImageResource(R.drawable.temp31to40c);
            message.setText("A perfectly balmy beach day.");
        }
        if(celsiusValue >= 41 && celsiusValue <= 60) {
            imageView.setImageResource(R.drawable.temp41to60c);
            message.setText("Hope you brought some water!");
        }
        if(celsiusValue >= 61 && celsiusValue <= 80) {
            imageView.setImageResource(R.drawable.temp61to80c);
            message.setText("Maybe we should've vacationed somewhere else...");
        }
        if(celsiusValue >= 81) {
            imageView.setImageResource(R.drawable.temp81to100c);
            message.setText("(Warning: spontaneous combustion may occur)");
        }

    }

    public void openActivity1() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
