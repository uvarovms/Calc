package com.jm.uvarov.calc2;

public class CalcArabNum {

       public static int calculate(int num1, int num2, char operation){
        int result = 0;
        switch (operation){
            case '+': result = num1 + num2;
                break;
            case '-': result = num1 - num2;
                break;
            case '*': result = num1 * num2;
                break;
            case '/': result = num1 / num2;
                break;
            default:throw  new IllegalArgumentException("Incorrect operation sign");
        }
        return result;
    }
}



