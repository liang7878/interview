package other;

import java.util.Scanner;

public class Back {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        int count = 0;

        for (int i = 0; i < m; i++) {
            if(isP(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean isP(int n) {
        int num[] = new int[32];
        int temp, j, k;
        boolean flag = true;
        int i = 2;
        temp = n;
        j = 0;
        flag = true;
        do{
            num[j] = temp % i;
            temp = temp / i;
            j += 1;
        }
        while (temp != 0);
        for (k = 0; k <= ((j) / 2); k++){
            if (num[k] == num[j - k - 1]) continue;
            else {
                flag = false;
                break;
            }
        }
        if (flag == true) {
            return true;
        }
        if (flag == false) return false;
        return false;
    }

}