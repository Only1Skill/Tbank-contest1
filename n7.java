package алгосы;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class n7 {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a.add(i);
        }
        for (int i = 0; i < n; i++) {
            int temp = a.get(i);
            a.set(i, a.get(i / 2));
            a.set(i / 2, temp);
        }
        for (int i:a){
            System.out.print(i+ " ");
        }
    }
}
