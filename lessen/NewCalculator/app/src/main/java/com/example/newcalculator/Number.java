package com.example.newcalculator;

public class Number {

    public static enum Signal {add, sub, multiply, divide}

    private double firstNum;
    private double secondNum;
    private Signal signal;
    private boolean hasSignal;
    private boolean hasFirstNum;
    private boolean hasSecondNum;

    public Number() {
        hasFirstNum = false;
        hasSecondNum = false;
        hasSignal=false;
    }

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public Signal getSignal() {
        return signal;
    }

    public void setSignal(Signal signal) {
        this.signal = signal;
    }

    public boolean isHasSignal() {
        return hasSignal;
    }

    public void setHasSignal(boolean hasSignal) {
        this.hasSignal = hasSignal;
    }

    public boolean isHasFirstNum() {
        return hasFirstNum;
    }

    public void setHasFirstNum(boolean hasFirstNum) {
        this.hasFirstNum = hasFirstNum;
    }

    public boolean isHasSecondNum() {
        return hasSecondNum;
    }

    public void setHasSecondNum(boolean hasSecondNum) {
        this.hasSecondNum = hasSecondNum;
    }
}

