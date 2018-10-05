package codility;

public class RotateArray {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4};

        solution(array, 3);

        System.out.println("other/test");

    }
    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if(A.length == 0 || A.length == 1 || K==0) {
            return A;
        }

        ArrNode head = new ArrNode(A[0]);
        ArrNode pri = head;

        for (int i = 1; i < A.length; i++) {
            ArrNode tmp = new ArrNode(A[i]);
            tmp.pre = pri;
            pri = tmp;
            if(i==A.length-1) {
                head.pre = tmp;
            }
        }

        pri =head;


        while(pri.next == null) {
            pri.pre.next = pri;
            pri = pri.pre;
        }

        pri = head;

        while(K!=0) {
            pri = pri.pre;
            K--;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = pri.val;
            pri = pri.next;
        }

        return A;
    }

    static class ArrNode{
        int val;
        ArrNode pre = null;
        ArrNode next = null;

        public ArrNode(int val) {
            this.val = val;
        }
    }
}
