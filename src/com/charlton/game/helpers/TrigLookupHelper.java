package com.charlton.game.helpers;

public class TrigLookupHelper {

    public static final double[] cos = genCos();
    public static final double[] sin = genSin();
    public static final double[] tan = getTan();

    private static double[] getTan() {
        double[] cos = new double[360];
        for (int i = 0; i < cos.length; i++) {
            cos[i] = Math.tan(Math.PI / 180 * i);
        }
        return cos;
    }

    public static double[] genCos() {
        double[] cos = new double[360];
        for (int i = 0; i < cos.length; i++) {
            cos[i] = Math.cos(Math.PI / 180 * i);
        }
        return cos;
    }

    public static double[] genSin() {
        double[] sin = new double[360];
        for (int i = 0; i < sin.length; i++) {
            sin[i] = Math.sin(i * Math.PI / 180);
        }
        return sin;
    }
}
