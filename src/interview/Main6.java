package interview;

import java.util.Scanner;

public class Main6 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            boolean matrix[][] = new boolean[a][a];

            while (b > 0) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                matrix[x][y] = true;
                matrix[y][x] = true;
                b--;
            }

            int result[] = new int[a];

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    if (matrix[i][j]) {
                        result[i]++;
                    }
                }
            }

            boolean flag = true;

            for (int i = 0; i < a; i++) {
                for (int j = i; j < a; j++) {
                    if (!matrix[i][j]) {
                        if (result[i] != result[j]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (!flag) break;
            }

            if (!flag) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            N--;
        }
    }
}