package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Long> input = new ArrayList<>();
        String buf = in.nextLine();
        String[] buflist = buf.split(" ");
        for(int i=0; i<buflist.length; i++) {
            input.add(Long.parseLong(buflist[i]));
        }

        long maxGain = 0;
        long rightMax = input.get(input.size()-1);

        for(int j=input.size()-1; j>=0; j--) {
            if(rightMax-input.get(j)>maxGain) {
                maxGain = rightMax-input.get(j);
            }
            if(input.get(j)>rightMax) {
                rightMax = input.get(j);
            }
        }

        System.out.println(maxGain);
    }
}
