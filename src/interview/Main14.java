package interview;

import java.util.Scanner;

/*
4 3
4 3
3 2
2 1
* */

public class Main14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String [] nm = in.nextLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        int [][] NN = new int[N+1][N+1];
        int [][] kechufa = new int[N+1][N+1];
        int [][] kebeida = new int[N+1][N+1];


        for (int i = 0; i < M; i++) {
            String [] se = in.nextLine().split(" ");
            int start = Integer.parseInt(se[0]);
            int end = Integer.parseInt(se[1]);
            NN[start][end] = 1;
            kechufa[start][end] = 1;
            kebeida[end][start] = 1;
            kechufa[start][0]++;
            kebeida[end][0] ++;
            kechufa[0][end] ++;
            //对start，所有end点可达的他都可达
            for (int j = 1; j < N+1; j++) {
                if(kechufa[end][j] == 1 && kechufa[start][j] == 0) {
                    kechufa[start][0]++;
                    kechufa[start][j] = 1;
                }
                if(kebeida[start][j] == 1 && kebeida[end][j] == 0) {
                    kebeida[end][0] ++;
                    kebeida[end][j] = 1;
                }
            }
            //对end，所有start点可接收的他都能接收

        }

        int [] achufa = new int[N+1];
        int [] adaoda = new int[N+1];

        int [] bchufa = new int[N+1];
        int [] bdaoda = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(kechufa[i][j] == 1) {
                    adaoda[j] ++;
                    achufa[i] ++;
                }

                if(kebeida[i][j] == 1) {
                    bdaoda[i] ++;
                    bchufa[j] ++;
                }
            }
        }

        int result = 0;

        for (int i = 1; i < N+1; i++) {
            if(Math.max(adaoda[i], bdaoda[i]) > Math.max(achufa[i], bchufa[i])) result++;
        }




        System.out.println(result);


    }
}
