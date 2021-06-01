package com.example.calculator;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.radiobutton.MaterialRadioButton;

import static com.example.calculator.R.style.Calculator;
import static com.example.calculator.R.style.Theme_Calculator;
import static com.example.calculator.R.style.buton_style;

public class ThemesActivity extends AppCompatActivity {

    private static final String NameSharedPreference = "CALCULATOR";


    private static final int buton_style_dark = 0;
    private static final int buton_style = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thems);

        setTheme(getAppTheme(R.style.buton_style));
        setContentView(R.layout.thems);
        initThemeChooser();


        findViewById(R.id.button_Back).setOnClickListener(v -> {
            finish();
        });


    }


    private void initThemeChooser() {

        initRadioButton(findViewById(R.id.radioButton_light),
                buton_style);
        initRadioButton(findViewById(R.id.radioButton_dark),
                buton_style_dark);
        RadioGroup rg = findViewById(R.id.radioButtons);

        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(buton_style))).setChecked(true);


    }


    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраним настройки
                setAppTheme(codeStyle);
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });

    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(String.valueOf(buton_style), codeStyle);


    }


    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(String.valueOf(buton_style), codeStyle);
        editor.apply();


    }


    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case buton_style_dark:
                return R.style.buton_style_dark;
            default:
                return R.style.buton_style;
        }
    }

}

