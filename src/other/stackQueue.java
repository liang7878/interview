package other;

public class stackQueue {
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5};
        int [] b = {4,5,3,2,1};

        System.out.println(VerifySquenceOfBST(a));

        System.out.println("other/test");
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        return verify(sequence, 0, sequence.length-1);
    }

    public static boolean verify(int[] seq, int start, int end) {
        if(start == end) return true;
        if(start == end-1) {
            if(seq[start] <= seq[end]) {
                return true;
            }
        }
        int bar = end;
        for (int i = start; i <= end; i++) {
            if(seq[i] > seq[end]) {
                bar = i;
                break;
            }
            if(i==end) {
                return true;
            }
        }

        for(int i=bar; i<end; i++) {
            if(seq[i] < seq[end]) return false;
        }

        return verify(seq, start, bar-1) && verify(seq, bar, end-1);
    }
//
//    public static boolean IsPopOrder(int [] pushA,int [] popA) {
//        Stack<Integer> input = new Stack<>();
//        Stack<Integer> output = new Stack<>();
//
//        for(int i=popA.length-1; i>=0; i--) {
//            output.push(popA[i]);
//        }
//
//        for(int i=0; i<pushA.length; i++) {
//            input.push(pushA[i]);
//            while(!output.empty() && input.peek() == output.peek()) {
//                input.pop();
//                output.pop();
//            }
//        }
//
//        if(input.size() == 0) {
//            return true;
//        }
//
//        return false;
//    }
}
