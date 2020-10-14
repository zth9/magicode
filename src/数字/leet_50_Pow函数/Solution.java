package 数字.leet_50_Pow函数;
import java.util.concurrent.Executors;

/**
 * @author: theTian
 * @date: 2020/10/13 11:25
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        synchronized (o){
            o.wait();
        }
    }

    public double myPow(double x, int n) {
        Executors.newFixedThreadPool(3);
        long c = (long)n;
        if (c == 0) return x == 0 ? 0 : 1;
        if (x == 1 || c == 1) return x;
        if (c < 0) {
            x = 1 / x;
            c = -c;
        }
        if (x < 0) return c % 2 == 0 ? quick(-x, c) : -quick(-x, c);
        return quick(x, c);
    }

    private double quick(double x, long n) {
        if (n == 1) return x;
        if (n % 2 == 0) {
            double half = quick(x, n / 2);
            return half * half;
        } else {
            double half = quick(x, (n - 1) / 2);
            return half * half * x;
        }
    }
}
