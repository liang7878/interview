package other;

import java.util.*;

public class Add {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        Stack<Long> test = new Stack<>();

        Stack<Long> input = new Stack<>();

        for (int i = 0; i < 13; i++) {
            input.push(in.nextLong());
        }
        long times = in.nextLong();
        for(long i =0; i<times; i++) {
            int k =in.nextInt();
            input = shuffle(input, k);
        }

        for (int i = 0; i < 13; i++) {
            System.out.print(input.pop() + " ");
        }
    }

    public static Stack<Long> shuffle(Stack<Long> origin, int x) {
        Stack<Long> a = new Stack<>();
        Stack<Long> b = new Stack<>();
        ArrayList<Long> result = new ArrayList<>();
        //a右手，b左手
        for (int i = 0; i < 13; i++) {
            if(i<6) {
                a.add(origin.pop());
            } else {
                b.add(origin.pop());
            }
        }

        a = reverse(a);
        b = reverse(b);

        boolean flag= true;
        int count = 0;
        for (int i = 0; i < 13; i++) {
            if(flag) {
                origin.add(b.pop());
                count++;
            }else {
                origin.add(a.pop());
                count++;
            }
            if(count == x) {
                flag = !flag;
                count = 0;
            }

        }

        return reverse(origin);
    }

    public static Stack<Long> reverse(Stack<Long> input) {
        Stack<Long> result = new Stack<>();

        while(!input.empty()) {
            result.push(input.pop());
        }

        return result;
    }
}
