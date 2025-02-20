
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;


public class n2 {
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
            int res=searchBinary(a1,b1[i]);
            System.out.println(res);
        }
    }
    public static int searchBinary(int[] arr,int key) {
        int start = 0;
        int end = arr.length - 1;
        int closest=arr[0];
        while (start <= end) {
            int mid = (end+start) / 2;
             if (abs(arr[mid] - key) < abs(closest - key) ||
                (abs(arr[mid] - key) == abs(closest - key) && arr[mid] < closest)) {
                    closest = arr[mid];
            }
            if (arr[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return closest;
    }
}


