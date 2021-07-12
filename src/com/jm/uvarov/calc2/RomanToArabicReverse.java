package com.jm.uvarov.calc2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RomanToArabicReverse {

    enum RomanNum {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNum(int val) {
            this.value = val;
        }

        public int getValue() {
            return value;
        }
        //Определяем метод для явного получения римских цифр в порядке убывания значений.
        public static List<RomanNum> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNum e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }

    public static int isRomanToArabic(String romanstr) {
        String romanNumeral = romanstr.toUpperCase();
        int resNum = 0;

        List<RomanNum> romanNumerals = RomanNum.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNum symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                resNum = resNum + symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(romanstr + " cannot be converted to Roman numeral");
        }

        return resNum;
    }

    public static String isArabicToRoman(int num) {
        if ((num <= 0) || (num > 4000)) {
            throw new IllegalArgumentException(num + " is not in range from 0 to 4000");
        }

        List<RomanNum> romanNumerals = RomanNum.getReverseSortedValues();

        int i = 0;
        StringBuilder strb = new StringBuilder();

        while ((num > 0) && (i < romanNumerals.size())) {
            RomanNum currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= num) {
                strb.append(currentSymbol.name());
                num = num - currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return strb.toString();
    }

}


