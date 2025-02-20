package алгосы;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.*;

public class n5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double low=-2000;
        double high=2000;
        double epsilon = 1e-7;
        if(a==0){
            return;
        }
        while (abs(high - low) > epsilon) {
            double mid = (low+high)/2;
            double fLow=low*low*low*a+low*low*b+low*c+d;
            double fMid=mid*mid*mid*a+mid*mid*b+mid*c+d;
            double fHigh=high*high*high*a+high*high*b+high*c+d;
            if(fMid==0){
                System.out.println(mid);
                return;
            }
            if((fMid*fLow)<0) {
                high=mid;
            }
            else{
                low=mid;
            }
        }
        double res=(high+low)/2;
        System.out.println(res);
    }
}