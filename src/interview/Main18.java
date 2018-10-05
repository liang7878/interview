package interview;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<String, Integer> result = new TreeMap<>();
        in.useDelimiter(" ");
        while(in.hasNext()) {
            String nextline = in.nextLine();
            if(nextline.equals("")|| nextline == null) break;
            String [] line = nextline.split(" ");
            int sum = 0;
            for (int i = 1; i < line.length; i++) {
                sum = sum + Integer.parseInt(line[i]);
            }

            result.put(line[0], sum/line.length);

            if(!in.hasNext()) {
                break;
            }
        }

        while (!result.isEmpty()) {
            Map.Entry<String, Integer> entry = result.pollFirstEntry();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
