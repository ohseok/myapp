package com.hanbit.user.myapp.Calc;

/**
 * Created by user on 2016-06-04.
 */
public class CalcServiceImpl implements CalcService {


    @Override
    public int plus(int num1, int num2) {
        return num1+num2;
    }

    @Override
    public int minus(int num1, int num2) {
        return num1-num2;
    }

    @Override
    public int multi(int num1, int num2) {
        return num1*num2;
    }

    @Override
    public int divide(int num1, int num2) {
        return num1/num2;
    }

    @Override
    public int nmg(int num1, int num2) {
        return num1%num2;
    }
}
