package com.jm.uvarov.calc2;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        System.out.println("Enter your expression with numbers from 1 to 10 in Arabic or Roman numerals,\nfor example (a + b) or (a - b) or (a * b) or (a / b):");

        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();
        String str3 = scanner.next();

        int num1 = 0;
        int num2 = 0;
        char operation = 0;

        if (str2.matches("[+-/*]")) {
            operation = str2.charAt(0);
        }
        if (str1.matches("^([1-9]|1[0])$") && str3.matches("^([1-9]|1[0])$")) {
            num1 = num1 + Integer.parseInt(str1.trim());
            num2 = num2 + Integer.parseInt(str3.trim());

            int result = CalcArabNum.calculate(num1, num2, operation);
            System.out.println(result);

        } else if (str1.matches("^(X|IX|V?I{0,3}|IV|I{0,2})$") && str3.matches("^(X|IX|V?I{0,3}|IV|I{0,2})$")) {

            num1 = RomanToArabicReverse.isRomanToArabic(str1);
            num2 = RomanToArabicReverse.isRomanToArabic(str3);

            int result = CalcArabNum.calculate(num1, num2, operation);

            String answer = RomanToArabicReverse.isArabicToRoman(result);
            System.out.println(answer);

        } else
            System.out.println("Incorrect expression.");


    }
}