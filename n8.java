package алгосы;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class n8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        List<Character> chars = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }
        Collections.sort(chars);
        boolean isSymmetric = true;
        int size=chars.size();
        for(int i = 0; i < chars.size(); i++){
            if(!chars.get(i).equals(chars.get(size-i-1))){
                isSymmetric = false;
                break;
            }
            else{
                for (char c : chars) {
                    System.out.print(c);
                }
            }
        }
        br.close();
    }
}
