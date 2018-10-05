package offer;

public class Robot {
    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        int count = 0;
        int [][] flag = new int[rows][cols];

        reachCount(threshold, rows, cols, flag, 0, 0);
//            }
//        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(flag[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int reachCount(int threshold, int rows, int cols, int[][] flag, int i, int j) {
        if(i<0||i>=rows||j<0||j>=cols||flag[i][j] == 1) return 0;

        int sum = 0;

        int tmprows = i;
        int tmpcols = j;

        while(tmprows !=0 || tmpcols != 0) {
            sum += (tmpcols%10+tmprows%10);
            tmpcols = tmpcols/10;
            tmprows = tmprows/10;
        }

        if(sum > threshold) return 0;

        flag[i][j] = 1;
        reachCount(threshold, rows, cols, flag, i+1, j);
        reachCount(threshold, rows, cols, flag, i-1, j);
        reachCount(threshold, rows, cols, flag, i, j+1);
        reachCount(threshold, rows, cols, flag, i, j-1);

//        int result = 1+ Math.max(reachCount(threshold, rows, cols, flag, i+1, j),
//                Math.max(reachCount(threshold, rows, cols, flag, i-1, j),
//                        Math.max(reachCount(threshold, rows, cols, flag, i, j+1),
//                                reachCount(threshold, rows, cols, flag, i, j-1))));

//        flag[i][j] = 0;

        return 1;
    }
}
