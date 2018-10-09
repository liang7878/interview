//package interview;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main19 {
//
//    public static void main(String[] args) {
//        int loop = 10000;
//        Scanner in = new Scanner(System.in);
//
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//
//
//
//        for (int i = 0; i < loop; i++) {
//            String line = in.nextLine();
//            if(line.equals("")) break;
//            String [] nums = line.split(" ");
//            int parent = Integer.parseInt(nums[0]);
//            int child = Integer.parseInt(nums[1]);
//            if(map.get(Integer.parseInt(nums[0]))==null) {
//                map.put(parent, new ArrayList<>());
//            }
//            ArrayList<Integer> childs = map.get(parent);
//            childs.add(child);
//            map.put(parent, childs);
//        }
//
//        int maxdepth = 0;
//
//        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()) {
//            int depth = getDepth(map, entry.getKey());
//            if(depth>maxdepth) {
//                maxdepth = depth;
//            }
//        }
//
//        System.out.println(maxdepth);
//    }
//
//    public static int getDepth(HashMap<Integer, ArrayList<Integer>> map, int root) {
//        ArrayList<Integer> childs = map.get(root);
//
//        if(childs == null || childs.size() == 0) return 1;
//
//        int maxDepth = 0;
//
//        for (int i = 0; i < childs.size(); i++) {
//            int depth = getDepth(map, childs.get(i));
//            if(depth > maxDepth) {
//                maxDepth = depth;
//            }
//        }
//
//        return maxDepth+1;
//    }
//
//}
package interview.other;

import java.util.Scanner;

public class Main19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 10000000;

        int[] height = new int[n];
        int[] binary = new int[n];
        height[0] = 1;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            if(!in.hasNextInt()) {
                break;
            }
            int parent = in.nextInt();
            int child = in.nextInt();
            binary[parent] += 1;
            if (binary[parent] < 3) {
                height[child] = height[parent] + 1;
            }
            max = Math.max(max, height[child]);
        }
        System.out.println(max);
    }
}

