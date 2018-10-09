package interview.other;

import java.util.Scanner;

public class Qunar2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String [] line = in.nextLine().split(" ");

        int startx = Integer.parseInt(line[0]);
        int starty = Integer.parseInt(line[1]);
        int endx = Integer.parseInt(line[2]);
        int endy = Integer.parseInt(line[3]);

        boolean [][] mark = new boolean[9][9];
        int [][] tag = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tag[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(getStep(startx, starty, endx, endy, mark, tag));

        System.out.println("succ");
    }

    public static int getStep(int startx, int starty, int endx, int endy, boolean[][] mark, int [][] tag) {
        if(startx > 8 || starty > 8 || startx<1 || starty<1) return -1;
        if(startx == endx && starty == endy)
            return 0;

        int step = tag[startx][starty];

        mark[startx][starty] = true;

        if(startx+1<9 && starty+2<9 && !mark[startx+1][starty+2]){
            if(tag[startx+1][starty+2] != Integer.MAX_VALUE)
                return tag[startx+1][starty+2];

            step = Math.min(step, 1+getStep(startx+1, starty+2, endx, endy, mark, tag));
            if(step == 1) {
                tag[startx][starty] = 1;
                return step;
            }
        }
        if(startx+1<9 && starty-2>0 && !mark[startx+1][starty-2]){
            if(tag[startx+1][starty-2] != Integer.MAX_VALUE) return tag[startx+1][starty-2];

            step = Math.min(step, 1+getStep(startx+1, starty-2, endx, endy, mark, tag));
            if(step == 1) {
                tag[startx][starty] = 1;
                return step;
            }
        }
        if(startx-1>0 && starty+2<9 && !mark[startx-1][starty+2]){
            if(tag[startx-1][starty+2] != Integer.MAX_VALUE) return tag[startx-1][starty+2];
            step = Math.min(step, 1+getStep(startx-1, starty+2, endx, endy, mark, tag));
            if(step == 1) {
                tag[startx][starty] = 1;
                return step;
            }
        }
        if(startx-1>0 && starty-2>0 &&!mark[startx-1][starty-2]){
            if(tag[startx-1][starty-2] != Integer.MAX_VALUE) return tag[startx-1][starty-2];
            step = Math.min(step, 1+getStep(startx-1, starty-2, endx, endy, mark, tag));
            if(step == 1) {
                tag[startx][starty] = 1;
                return step;
            }
        }
        if(startx+2<9 && starty+1<9 && !mark[startx+2][starty+1]){
            if(tag[startx+2][starty+1] != Integer.MAX_VALUE) return tag[startx+2][starty+1];

            step = Math.min(step, 1+getStep(startx+2, starty+1, endx, endy, mark, tag));

            if(step == 1) {
                tag[startx][starty] = 1;
                return step;
            }
        }
        if(startx+2<9 && starty-1>0 &&!mark[startx+2][starty-1]){
            if(tag[startx+2][starty-1] != Integer.MAX_VALUE) return tag[startx+2][starty-1];

            step = Math.min(step, 1+getStep(startx+2, starty-1, endx, endy, mark, tag));
            if(step == 1) {
                tag[startx][starty] = 1;
                return step;
            }
        }
        if(startx-2>0 && starty+1<9 && !mark[startx-2][starty+1]){
            if(tag[startx-2][starty+1] != Integer.MAX_VALUE) return tag[startx-2][starty+1];

            step = Math.min(step, 1+getStep(startx-2, starty+1, endx, endy, mark, tag));
            if(step == 1) {
                tag[startx][starty] = 1;
                return step;
            }
        }
        if(startx-2>0 && starty-1 > 0 && !mark[startx-2][starty-1]){
            if(tag[startx-2][starty-1] != Integer.MAX_VALUE) return tag[startx-2][starty-1];

            step = Math.min(step, 1+getStep(startx-2, starty-1, endx, endy, mark, tag));
            if(step == 1) {
                tag[startx][starty] = 1;
                return step;
            }
        }

        mark[startx][starty] = false;
        if(step < 0) {
            return -1;
        }

        if(step > 0)
            tag[startx][starty] = Math.min(step, tag[startx][starty]);

        return step;
    }
}
