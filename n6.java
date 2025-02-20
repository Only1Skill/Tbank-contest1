package алгосы;

import java.util.Scanner;

class n6 {
    long merge(int[] a,int l,int m,int r) {
        int n1=m-l+1;
        int n2=r-m;

        int[] L=new int[n1];
        int[] R=new int[n2];
        for (int i=0;i<n1;i++) {
            L[i]=a[l+i];
        }
        for (int j=0;j<n2;j++) {
            R[j]=a[m+1+j];
        }
        long inv=0;
        int i=0;
        int j=0;
        int k=l;

        while (i<n1 && j<n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                inv+=(n1-i);
                j++;
            }
            k++;
        }
        while (i<n1){
            a[k]=L[i];
            k++;
            i++;
        }
        while (j<n2){
            a[k]=R[j];
            k++;
            j++;
        }
        return inv;
    }
    long sortMerge(int[] a,int l,int r) {
        long inv = 0;
        if (l<r) {
            int m = (l + r) / 2;
            inv += sortMerge(a, l, m);
            inv += sortMerge(a, m + 1, r);
            inv += merge(a, l, m, r);
        }
        return inv;
    }
    public static void main(String[] args) {
        n6 ob=new n6();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i=0;i<n;i++) {
            a[i]=sc.nextInt();
        }
        long res=ob.sortMerge(a,0,a.length-1);
        System.out.println(res);
        for(int i:a){
            System.out.print(i + " ");
        }
    }
}
