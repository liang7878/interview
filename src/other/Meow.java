package other;

import java.util.ArrayList;
import java.util.Scanner;

public class Meow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String heapline= in.nextLine();
        String[] heapArr = heapline.split(" ");
        ArrayList<Long> heaplist = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < heapArr.length; i++) {
            long tmp = Long.parseLong(heapArr[i]);
            heaplist.add(tmp);
            sum+=tmp;
        }

        long time = in.nextLong();

        long floor = sum/time;
        while(!judgeTime(heaplist, floor, time)) {
            floor++;
        }
        System.out.println(floor);
    }

    public static boolean judgeTime(ArrayList<Long> heapList, long floor, long time) {
        int minflag = 0;

        for (int i = 0; i < heapList.size(); i++) {
            long tmp = heapList.get(i);
            if(tmp == 0) continue;
            if(tmp < floor) {
                time--;
                heapList.set(i, 0l);
                return judgeTime(heapList, floor, time);
            }
            heapList.set(i, tmp-floor);
            time--;
            return judgeTime(heapList, floor, time);
        }
        if(time >=0) {
            return true;
        } else {
            return false;
        }
    }
}
