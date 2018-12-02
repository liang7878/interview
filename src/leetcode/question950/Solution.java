package leetcode.question950;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int []  a = {17,13,11,2,3,5,7};
        solution.deckRevealedIncreasing(a);
        System.out.println("test");
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = deck.length-1; i >= 0 ; i--) {
            if(queue.isEmpty()) {
                queue.add(deck[i]);
            } else {
                helper(queue);
                queue.push(deck[i]);
            }
        }

        for (int i = 0; i < deck.length; i++) {
            deck[i] = queue.pollFirst();
        }
        return deck;
    }

    void helper(LinkedList<Integer> queue) {
        int tmp = queue.pollLast();
        queue.push(tmp);
    }
}
