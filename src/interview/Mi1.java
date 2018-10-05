package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Mi1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();

        while(true) {
            String line = in.nextLine();
            if(line.equals("END")) break;
            lines.add(line);
            String [] nums = line.split("#");
            int scale = Integer.parseInt(nums[0]);
            char [] numChar = nums[1].toCharArray();
            int number = 0;
            for (int i = numChar.length-1; i >= 0 ; i--) {
                number += getNscale(numChar.length-1-i, numChar[i]-48, scale);
            }
            result.add(number);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < result.size(); i++) {
            if(map.get(result.get(i)) == null) {
                map.put(result.get(i), 1);
            } else {
                int count = map.get(result.get(i));
                count++;
                map.put(result.get(i), count);
            }
        }

        ArrayList<Integer> r  = new ArrayList<>();

        for (HashMap.Entry<Integer, Integer> entry: map.entrySet()
             ) {
            if(entry.getValue() == 1) {
                r.add(entry.getKey());
            }
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < r.size(); j++) {
                if(result.get(i) == r.get(j)) {
                    System.out.println(lines.get(i));
                }
            }
        }
    }

    public static int getNscale(int wei, int value, int sacle) {
        if(wei == 0) return value;
        int result = value;
        while(wei!=0) {
            result = result * sacle;
            wei--;
        }
        return result;
    }
}
