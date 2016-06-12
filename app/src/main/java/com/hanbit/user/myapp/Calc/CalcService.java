package com.hanbit.user.myapp.Calc;

/**
 * Created by user on 2016-06-04.
 */
public interface CalcService {
    public  int  plus(int num1, int num2);
    public int minus(int num1, int num2);
    public int multi(int num1, int num2);
    public int divide(int num1, int num2); // 몫
    public int nmg(int num1, int num2); // 나머지
}
