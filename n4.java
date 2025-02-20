package алгосы;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.*;

public class n4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double C = sc.nextDouble();
        double low=0.0;
        double high=sqrt(C);
        double epsilon = 1e-7;
        while (high - low > epsilon) {
            double mid = (low+high)/2;
            double fMid=mid*mid+sqrt(mid+1);
            if(fMid<C) {
                low=mid;
            }
            else{
                high=mid;
            }
        }
        System.out.println(low);
    }
}
