package interview.other;

import java.util.HashMap;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
//        String str = "BACCAAHEFGHFF";
        if(str == null || str.equals("")) {
            System.out.println("NULL");
            return;
        }
        Character result = getChar(str);
        if(result == null) {
            System.out.println("NULL");
        } else {
            System.out.println(result);
        }

    }

    public static Character getChar(String str) {

        char[] arr = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int time = map.get(arr[i]);
                map.put(arr[i], ++time);
            } else {
                map.put(arr[i], 1);
            }
        }

        int pos = -1;
        for (int i = arr.length-1; i >= 0; i--) {
            if(map.get(arr[i]) == 1) {
                return arr[i];
            }
        }

        return null;
    }


}
