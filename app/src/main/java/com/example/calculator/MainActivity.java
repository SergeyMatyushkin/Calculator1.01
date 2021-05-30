package com.example.calculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private Button Themes;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);

        display = findViewById(R.id.Text_View_1);
        display.setShowSoftInputOnFocus(false);
        display.setEnabled(false);

        display.setOnClickListener(v -> {
            if ("Enter in a value".equals(display.getText().toString())) {
                display.setText("");
            }

        });



    }




    private void updateText (String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void button_AC (View view){
        display.setText("");


    }
    public void button_backspace (View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }
    public void button_1 (View view){
        updateText("1");

    }
    public void button_2 (View view){
        updateText("2");

    }
    public void button_3 (View view){
        updateText("3");

    }
    public void button_4 (View view){
        updateText("4");

    }
    public void button_5 (View view){
        updateText("5");

    }
    public void button_6 (View view){
        updateText("6");

    }
    public void button_7 (View view){
        updateText("7");

    }
    public void button_8 (View view){
        updateText("8");

    }
    public void button_9 (View view){
        updateText("9");
    }
    public void button_0 (View view){
        updateText("0");

    }
    public void button_investments (View view){
        updateText("+");

    }
    public void button_subtraction (View view){
        updateText("-");

    }
    public void button_multiplication (View view){
        updateText("*");

    }
    public void button_point (View view){
        updateText(".");


    }
    public void button_equals (View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression (userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void button_division (View view){
        updateText("/");

    }

    public void button_Themes (View view){
        Themes = findViewById(R.id.button_Themes);
        Themes.setOnClickListener(v->{
            Intent intent = new Intent(this, ThemesActivity.class);
            this.startActivity(intent);
        });
    }





}