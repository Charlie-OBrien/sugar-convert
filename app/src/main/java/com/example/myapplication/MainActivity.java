package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.math.BigDecimal;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {


    //
    private EditText txtInputGrams;
    private Button btnConvert;
    private TextView lblOutput;
    private TextView lblOutputDaily;




    public void checkGuess() {
        String guessText = txtInputGrams.getText().toString();
        String message = "";

        try {
           BigDecimal guess = new BigDecimal(guessText);
            BigDecimal TEASPOONS = new BigDecimal("0.24");
            BigDecimal answer = TEASPOONS.multiply(guess).setScale(2,1);
            message = answer + " tsp";
            DailyValue();

        } catch (Exception e) {
            message = "ERROR " + e.toString();
        } finally {
            lblOutput.setText(message);

            txtInputGrams.requestFocus();
            txtInputGrams.selectAll();
        }
    }

    public void DailyValue(){
        String messageTest = "";
        try {
            messageTest = "SEE THIS";
        }
        catch (Exception e) {
            messageTest = "Error " + e.toString();
        }
        finally {
            lblOutputDaily.setText(messageTest);    //this
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInputGrams = (EditText) findViewById(R.id.txtInputGrams);
        btnConvert = (Button) findViewById(R.id.btnConvert);
        lblOutput = (TextView) findViewById(R.id.lblOutput);
        lblOutputDaily = (TextView) findViewById(R.id.lblOutputDaily);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }
        });

    }
}