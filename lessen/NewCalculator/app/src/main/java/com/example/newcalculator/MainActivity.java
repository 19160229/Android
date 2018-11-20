package com.example.newcalculator;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Number number = new Number();
    public static boolean clickSign = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        editText = (EditText) findViewById(R.id.text_input);
        editText.setShowSoftInputOnFocus(false);

        /*
            按下数字键后更改编辑框中的数字
         */
        Button button_0 = (Button) findViewById(R.id.button_0);
        button_0.setOnClickListener(this);
        Button button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(this);
        Button button_2 = (Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(this);
        Button button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(this);
        Button button_4 = (Button) findViewById(R.id.button_4);
        button_4.setOnClickListener(this);
        Button button_5 = (Button) findViewById(R.id.button_5);
        button_5.setOnClickListener(this);
        Button button_6 = (Button) findViewById(R.id.button_6);
        button_6.setOnClickListener(this);
        Button button_7 = (Button) findViewById(R.id.button_7);
        button_7.setOnClickListener(this);
        Button button_8 = (Button) findViewById(R.id.button_8);
        button_8.setOnClickListener(this);
        Button button_9 = (Button) findViewById(R.id.button_9);
        button_9.setOnClickListener(this);

        //小数点
        Button button_dot = (Button) findViewById(R.id.button_dot);
        button_dot.setOnClickListener(this);

        //取负
        Button button_neg = (Button) findViewById(R.id.button_neg);
        button_neg.setOnClickListener(this);

        //百分号
        Button button_per = (Button) findViewById(R.id.button_per);
        button_per.setOnClickListener(this);

        /*
        按下清空或者回退一格
         */
        Button button_clr = (Button) findViewById(R.id.button_clr);
        button_clr.setOnClickListener(this);
        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(this);

        //计算
        Button button_cal = (Button) findViewById(R.id.button_cal);
        button_cal.setOnClickListener(this);

        //按下加、减、乘、除
        Button button_add = (Button) findViewById(R.id.button_add);
        button_add.setOnClickListener(this);
        Button button_sub = (Button) findViewById(R.id.button_sub);
        button_sub.setOnClickListener(this);
        Button button_multi = (Button) findViewById(R.id.button_multi);
        button_multi.setOnClickListener(this);
        Button button_div = (Button) findViewById(R.id.button_div);
        button_div.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_0:
                Calculate.inputNum(editText, "0");
                break;
            case R.id.button_1:
                Calculate.inputNum(editText, "1");
                break;
            case R.id.button_2:
                Calculate.inputNum(editText, "2");
                break;
            case R.id.button_3:
                Calculate.inputNum(editText, "3");
                break;
            case R.id.button_4:
                Calculate.inputNum(editText, "4");
                break;
            case R.id.button_5:
                Calculate.inputNum(editText, "5");
                break;
            case R.id.button_6:
                Calculate.inputNum(editText, "6");
                break;
            case R.id.button_7:
                Calculate.inputNum(editText, "7");
                break;
            case R.id.button_8:
                Calculate.inputNum(editText, "8");
                break;
            case R.id.button_9:
                Calculate.inputNum(editText, "9");
                break;
            case R.id.button_dot:
                Calculate.inputNum(editText, ".");
                break;
            case R.id.button_neg:
                Calculate.inputNum(editText, "-");
                break;
            case R.id.button_per:
                Calculate.inputNum(editText, "%");
                break;
            case R.id.button_clr:
                Calculate.clear(editText, number);
                break;
            case R.id.button_cancel:
                Calculate.cancel(editText);
                break;
            case R.id.button_add:
                Calculate.clickSignal(editText, Number.Signal.add, number);
                break;
            case R.id.button_sub:
                Calculate.clickSignal(editText,Number.Signal.sub,number);
                break;
            case R.id.button_multi:
                Calculate.clickSignal(editText,Number.Signal.multiply,number);
                break;
            case R.id.button_div:
                Calculate.clickSignal(editText,Number.Signal.divide,number);
                break;
            case R.id.button_cal:
                Calculate.calculate(editText, number);
                break;
            default:
                break;
        }
    }
}
