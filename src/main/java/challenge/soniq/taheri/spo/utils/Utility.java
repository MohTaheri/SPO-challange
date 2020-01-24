package challenge.soniq.taheri.spo.utils;

public class Utility {

    /**
     * Find the greatest common divisor of two integers
     */
    public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
}
