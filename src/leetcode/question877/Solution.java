package leetcode.question877;

import java.util.ArrayList;

public class Solution {
    static int alex = 0;
    static int bitch = 0;
    static boolean flag = true;
    static boolean result = true;

    public static boolean stoneGame(int[] piles) {

//        stoneListGame(pilesList);

        return result;
    }

    public static void stoneListGame(ArrayList<Integer> pilesList) {
        if(pilesList.size() == 1) {
            if(flag) {
                alex += pilesList.get(0);
            } else {
                bitch += pilesList.get(0);
            }
            if(alex>bitch) {
                result = true;
                return;
            }else {
                result = false;
                return;
            }
        }

        if(flag) {
            for (int i = 0; i < 2; i++) {
                ArrayList<Integer> cp = new ArrayList<>();
                for (int j = 0; j < pilesList.size(); j++) {
                    cp.add(pilesList.get(i));
                }

                if(i==0) {
                    //head
                    int tmp = cp.remove(0);
                    alex += tmp;
                    flag = !flag;
                    stoneListGame(cp);
                    alex -= tmp;
                } else {
                    //tail
                    int tmp = cp.remove(cp.size()-1);
                    alex += tmp;
                    flag = !flag;
                    stoneListGame(cp);
                    alex -= tmp;
                }
            }
        } else {
            for (int i = 0; i < 2; i++) {
                ArrayList<Integer> cp = new ArrayList<>();
                for (int j = 0; j < pilesList.size(); j++) {
                    cp.add(pilesList.get(i));
                }

                if(i==0) {
                    int tmp1 = cp.remove(0);
                    bitch += tmp1;
                    flag = !flag;
                    stoneListGame(cp);
                    bitch -= tmp1;
                } else {
                    int tmp1 = cp.remove(cp.size()-1);
                    bitch += tmp1;
                    flag = !flag;
                    stoneListGame(cp);
                    bitch -= tmp1;
                }
            }
        }

        return;
    }

    public static void main(String[] args) {
        int[] test = {5,3,4,5};

        System.out.println(stoneGame(test));
    }
}
