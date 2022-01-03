package com.shipping.util;

public class unitConverter {
    public static float inch2cm(float inches){
        return inches*2.54f;
    }

    public static float cm2inche(float cm){
        return cm*0.393701f;
    }

    public static float pound2gram(float pound){
        return pound*453.592f;
    }

    public static float gram2pound(float gram){
        return gram*0.00220462f;
    }
}
