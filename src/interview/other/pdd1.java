package interview.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class pdd1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String para = in.nextLine();

        String pure = para.replaceAll("\\pP", "");
//                .replaceAll("-", "")
//                .replaceAll("[?]", "")
//                .replaceAll(",", "")
//                .replaceAll(":", "")
//                .replaceAll(";", "")
//                .replaceAll("[.]", "");
        System.out.println(pure);
        String [] words = pure.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if(map.get(words[i].toLowerCase()) == null) {
                map.put(words[i].toLowerCase(), 1);
            } else {
                int count = map.get(words[i].toLowerCase());
                count++;
                map.put(words[i].toLowerCase(), count);
            }
        }

        int max = Integer.MIN_VALUE;

        ArrayList<String> list = new ArrayList<>();

        for (HashMap.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        for (HashMap.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i != list.size()-1) {
                System.out.print(" ");
            } else {
            }
        }

    }
}
