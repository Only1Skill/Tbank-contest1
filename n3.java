package алгосы;

import java.util.Scanner;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

public class n3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int low=1;
        int high=a;
        while (low<high) {
            int mid = (int) ceil((double)(low+high)/2);
            System.out.println(mid);
            System.out.flush();
            String s = sc.next();
            if(s.equals("<")) {
                high=mid-1;
            }
            else{
                low=mid;
            }
        }
        System.out.println("! "+low);
        System.out.flush();
    }
}
