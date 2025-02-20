package алгосы;

import java.util.Arrays;
import java.util.Scanner;


public class n1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] a1 = new int[a];
        int[] b1 = new int[b];
        for (int i = 0; i < a; i++) {
            a1[i] = sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            b1[i] = sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            boolean res=searchBinary(a1,b1[i]);
            if (res){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    public static boolean searchBinary(int[] arr,int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end+start) / 2;
            if (arr[mid] == key) {
                return true;
            }
            if (arr[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}


