package interview.wap;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int T = Integer.parseInt(scan.nextLine());
            for(int caseNUM = 0; caseNUM < T; caseNUM++){
                String[] str = scan.nextLine().split(" ");
                int rows = Integer.parseInt(str[0]);
                int cols = Integer.parseInt(str[1]);
                char[][] grids = new char[rows][cols];
                int[][] dp = new int[rows][cols];

                for(int i=0;i<rows;i++){
                    String s = scan.nextLine();
                    for(int j=0;j<cols;j++){
                        if(i==0 && j==0){
                            grids[0][0] = '\\';
                            if(s.charAt(0) == '/'){
                                dp[0][0] = 1;
                            }
                        }else if(i==0){
                            if(s.charAt(j) == grids[i][j-1]){
                                if(grids[i][j-1] == '\\')
                                    grids[i][j] = '/';
                                else
                                    grids[i][j] = '\\';
                                dp[i][j] = dp[i][j-1] + 1;
                            }else{
                                grids[i][j] = s.charAt(j);
                                dp[i][j] = dp[i][j-1];
                            }

                        }else if(j == 0){
                            if(s.charAt(j) == grids[i-1][j]){
                                if(grids[i-1][j] == '\\')
                                    grids[i][j] = '/';
                                else
                                    grids[i][j] = '\\';

                                dp[i][j] = dp[i-1][j] + 1;
                            }else{
                                grids[i][j] = s.charAt(j);
                                dp[i][j] = dp[i-1][j];
                            }
                        }else{
                            if(s.charAt(j) != grids[i-1][j-1]){
                                if(grids[i-1][j-1] == '\\')
                                    grids[i][j] = '\\';
                                else
                                    grids[i][j] = '/';

                                dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                            }else{
                                grids[i][j] = s.charAt(j);
                                dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                            }
                        }

                    }
                }
                if(grids[rows-1][cols-1] == '\\')
                    System.out.println(dp[rows-1][cols-1]);
                else
                    System.out.println(-1);
            }

        }
        scan.close();
    }

}
