package com.example.newcalculator;

import android.icu.text.UnicodeSetSpanner;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class Calculate {

    public static double add(double firstNum, double secondNum) {
        BigDecimal first=new BigDecimal(firstNum);
        BigDecimal second=new BigDecimal(secondNum);
        BigDecimal res=first.add(second);
        int intPartLength=getIntPartLength(res.doubleValue());
        return res.setScale(10-intPartLength,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double sub(double firstNum, double secondNum) {
        BigDecimal first=new BigDecimal(firstNum);
        BigDecimal second=new BigDecimal(secondNum);
        BigDecimal res=first.subtract(second);
        int intPartLength=getIntPartLength(res.doubleValue());
        return res.setScale(10-intPartLength,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double multi(double firstNum, double secondNum) {
        BigDecimal first=new BigDecimal(firstNum);
        BigDecimal second=new BigDecimal(secondNum);
        BigDecimal res=first.multiply(second);
        int intPartLength=getIntPartLength(res.doubleValue());
        return res.setScale(10-intPartLength,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double division(double firstNum, double secondNum) {
        BigDecimal first=new BigDecimal(firstNum);
        BigDecimal second=new BigDecimal(secondNum);
        BigDecimal res=first.divide(second,10,BigDecimal.ROUND_HALF_UP);
        int intPartLength=getIntPartLength(res.doubleValue());
        return res.setScale(10-intPartLength,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double percent(double firstNum) {
        return firstNum / 100;
    }

    public static void inputNum(EditText editText, String num) {
        if (MainActivity.clickSign == true) {
            editText.setText("");
            MainActivity.clickSign = false;
        }
        String content = editText.getText().toString();
        if (content.length() == 11) {
            Toast.makeText(editText.getContext(), "Input Error", Toast.LENGTH_SHORT).show();
        } else if (num.equals(".")) {
            if (content.indexOf(".") == -1) {
                content += num;
            }
        } else if (num.equals("-")) {
            if ((!content.equals("")) && content.indexOf("-") == -1) {
                content = num + content;
            }
        } else if (num.equals("%")) {
            if (content.indexOf("%") == -1) {
                content += num;
            }
        } else {
            if (content.equals("0"))
                content = num;
            else
                content = content + num;
        }
        editText.setText(content);
        editText.setSelection(content.length());
    }

    public static void clear(EditText editText,Number number) {
        editText.setText("");
        number.setHasFirstNum(false);
        number.setHasSignal(false);
    }

    public static void cancel(EditText editText) {
        String content = editText.getText().toString();
        if (!content.equals("")) {
            content = content.substring(0, content.length() - 1);
        }
        editText.setText(content);
        editText.setSelection(content.length());
    }

    public static void clickSignal(EditText editText, Number.Signal signal, Number number) {
        if (number.isHasFirstNum()) {
            calculate(editText,number);
        }
        number.setHasFirstNum(true);
        number.setHasSignal(true);
        number.setSignal(signal);
        double num = parseDouble(editText);
        number.setFirstNum(num);
        MainActivity.clickSign = true;
    }

    public static void calculate(EditText editText, Number number) {
        String content = "";
        if (number.isHasFirstNum() == false) {
            double res = parseDouble(editText);
            content = doubleToString(res);

        } else if (number.isHasFirstNum()) {
            double secondNum = parseDouble(editText);
            if (MainActivity.clickSign==true) {
                content = doubleToString(number.getFirstNum());
            } else {
                Number.Signal signal = number.getSignal();
                double res;
                switch (signal) {
                    case add:
                        res = add(number.getFirstNum(), secondNum);
                        content = doubleToString(res);
                        break;
                    case sub:
                        res=sub(number.getFirstNum(),secondNum);
                        content=doubleToString(res);
                        break;
                    case multiply:
                        res=multi(number.getFirstNum(),secondNum);
                        content=doubleToString(res);
                        break;
                    case divide:
                        if (secondNum==0){
                            content="";
                            Toast.makeText(editText.getContext(),"Error",Toast.LENGTH_SHORT).show();
                        }else {
                            res = division(number.getFirstNum(), secondNum);
                            content = doubleToString(res);
                        }
                        break;
                    default:
                        break;
                }
                number.setHasSignal(false);
                number.setHasFirstNum(false);
            }
        }
        editText.setText(content);
        editText.setSelection(content.length());
    }

    public static String doubleToString(double num) {
        String res;
        if (isDecimalUseful(num) == false) {
            res = String.valueOf((int) num);
        } else {
            res = String.valueOf(num);
        }
        return res;
    }

    public static double parseDouble(EditText editText) {
        String content = editText.getText().toString();
        if (content.indexOf("%") != -1) {
            int index = content.indexOf("%");
            if (index != content.length() - 1) {
                Toast.makeText(editText.getContext(), "Error", Toast.LENGTH_SHORT).show();
                return 0;
            }else if (index==0){
                Toast.makeText(editText.getContext(), "Error", Toast.LENGTH_SHORT).show();
                return 0;
            }
            else {
                double res = Double.parseDouble(
                        content.substring(0, content.length() - 1)) / 100;
                return res;
            }
        }
        double res = Double.parseDouble(content);
        return res;
    }

    public static boolean isDecimalUseful(double firstNum) {
        double temp = (int) firstNum;
        if (temp == firstNum) {
            return false;
        } else {
            return true;
        }
    }

    public static int getIntPartLength(double num){
        double temp=(int)num;
        return String.valueOf(temp).length();
    }

}