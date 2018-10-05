package other;

public class Solution {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        reOrderArray(array);
        System.out.println("pause");
    }


    public static void reOrderArray(int [] array) {
        int length = array.length;

        for(int i=length-1; i>=0; i--){
            if(array[i]%2 == 0) continue;

            if(array[i]%2 == 1) {
                int j = i-1;
                while(array[j]%2==1){
                    j--;
                    if(j<0) return;
                }
                int tmp = array[j];
                for(int k=j; k<i; k++) {
                    array[k] = array[k+1];
                }
                array[i]=tmp;
            }
        }
    }
}


















///**
// * Definition for binary tree
//
// */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
//public class Solution {
//    public static void main(String[] args) {
//        int[] pre = {1,2,3,4,5,6,7};
//        int[] in = {3,2,4,1,6,5,7};
//
//        TreeNode root = reConstructBinaryTree(pre, in);
//        System.out.println("test");
//    }
//
//    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//        if(pre.length == 0 && in.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[0]);
//        int rootIndex = -1;
//
//        for(int i=0; i<in.length; i++) {
//            if(in[i] == root.val) {
//                rootIndex = i;
//                break;
//            }
//        }
//
//        int [] leftChildpre = new int[rootIndex];
//        int [] rightChildpre = new int[pre.length-rootIndex-1];
//
//        int [] leftChildin = new int[rootIndex];
//        int [] rightChildin = new int[pre.length-rootIndex-1];
//
//        for(int i=0; i<in.length; i++) {
//            if(i<rootIndex) {
//                leftChildin[i] = in[i];
//            } else if(i>rootIndex) {
//                rightChildin[i-rootIndex-1] = in[i];
//            }
//        }
//
//        int left = 0;
//        int right = 0;
//
//
//        for(int i=0;i<pre.length; i++) {
//            boolean exist = false;
//
//            for(int j=0; j<leftChildin.length; j++) {
//                if(pre[i]==leftChildin[j]){
//                    leftChildpre[left++] = pre[i];
//                }
//            }
//            for(int j=0; j<rightChildin.length; j++) {
//                if(pre[i]==rightChildin[j]){
//                    rightChildpre[right++] = pre[i];
//                }
//            }
//
//        }
//
//        System.out.println("test");
//
//        root.left = reConstructBinaryTree(leftChildpre, leftChildin);
//        root.right = reConstructBinaryTree(rightChildpre, rightChildin);
//
//        return root;
//    }
//}


//import java.util.ArrayList;
//public class Solution {
//    public int minNumberInRotateArray(int [] array) {
//        if(array.length == 0) return 0;
//
//        int low = 0;
//        int high = array.length - 1;
//        return midinArray(array, low, high);
//    }
//
//    public int midinArray(int [] array, int low, int high) {
//        int mid = (low+high+1)/2;
//
//        if(array[high] < array[mid]){
//            return midinArray(array, mid, high);
//        } else if(array[high] == array[mid]) {
//            return array[mid];
//        } else if(array[high] > array[mid]) {
//            return midinArray(array, low, mid);
//        }
//
//        return 0;
//    }
//}
//
//
////import java.util.*;
////
////public class Solution {
////    public static void main(String args[]) {
////        int[][] arrar = {{1,2,8,9}, {2,4,9,12},{4,7,10,13}, {6,8,11,15}};
////
////        System.out.println(Find(16, arrar));
////    }
////
////    public static boolean Find(int target, int[][] arr) {
////        int x_length = arr.length;
////        int y_length = arr[0].length;
////
////        for(int i=x_length-1, j=0; i>=0&&j<y_length;) {
////            if(arr[i][j]==target) {
////                return true;
////            }
////
////            if(arr[i][j]>target) {
////                i--;
////                continue;
////            }
////
////            if(arr[i][j]<target) {
////                j++;
////            }
////        }
////        return false;
////    }
////
////    public String replaceSpace(StringBuffer str) {
////        return str.replace(str.indexOf(" "), str.indexOf(" ")+1, "%20").toString();
////    }
////
////    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
////        ArrayList<Integer> result = new ArrayList<>();
////        if(listNode.equals(new Object())) {
////            return result;
////        }
////        if(listNode != new Object() && listNode.next == null) {
////            result.add(listNode.val);
////            return result;
////        }
////
////        while(listNode.next != null) {
////            result.add(listNode.val);
////            listNode = listNode.next;
////        }
////
////        result.add(listNode.val);
////        return result;
////    }
////}
////
////class ListNode {
////    int val;
////    ListNode next = null;
////    ListNode(int val) {
////        this.val = val;
////    }
////}