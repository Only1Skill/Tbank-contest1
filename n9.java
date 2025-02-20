package алгосы;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Set;
import static java.lang.System.out;
import java.io.InputStreamReader;
import java.util.HashSet;


public class n9 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input[i]);


            Set<Integer> arrSet = new HashSet<>();
            int current = n;
            int[] res = new int[n + 1];
            res[0] = 1;

            for (int i = 0; i < n; i++) {arrSet.add(arr[i]);while (arrSet.contains(current)) {arrSet.remove(current);current--;}res[i + 1] = arrSet.size() + 1;}

            StringBuilder sb = new StringBuilder();

            for (int val : res)
                sb.append(val).append(" ");

            out.println(sb.toString().trim());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
