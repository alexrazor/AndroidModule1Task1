package com.alexrazor.firstapp;

import android.app.usage.UsageEvents;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count =0;
    TextView countTextView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView  = (TextView) findViewById(R.id.intTextView);
        countTextView.setText(R.string.valueNotSet);

        editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count>=12){
                    countTextView.setText(increaseCount());
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void onIncreaseButtonClick(View view) {
        countTextView.setText(increaseCount());
    }

    private String increaseCount(){
        if (count>=22){
            return "Stop tapping, dude!!!";
        } else {
            count++;
            return "Value is: " + count;
        }
    }

    public void onResetButtonClick(View view) {
        count =0;
        countTextView.setText(R.string.valueNotSet);
        editText.setText(null);
    }


}
