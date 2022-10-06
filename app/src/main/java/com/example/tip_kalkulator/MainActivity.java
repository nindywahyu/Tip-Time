package com.example.tip_kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etAmount;
    TextView tvPercent;
    SeekBar sbPercent;
    TextView tvTip;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmount = findViewById(R.id.et_amount);
        tvPercent = findViewById(R.id.tv_percent);
        sbPercent = findViewById(R.id.sb_percent);
        tvPercent = findViewById(R.id.tv_tip);
        tvTotal = findViewById(R.id.tv_total);

        sbPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, int i, boolean b) {
                int percent = progress;
                tvPercent.setText(String.valueOf(percent)+"%");
                calculate();
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       etAmount.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void afterTextChanged(Editable editable) {
               calculate();

           }
       });

    }
    private void calculate(){
        if (etAmount.length()==0){
            etAmount.requestFocus();
            etAmount.setError("Enter Amount");
        }else {
            double amount = Double.parseDouble(etAmount.getText().toString());
            int percent = sbPercent.getProgress();
            double tip = amount*percent/100.0;
            double total = amount + tip;
            tvTip.setText(String.valueOf(tip));
            tvTotal.setText(String.valueOf(total));
        }
    }
}