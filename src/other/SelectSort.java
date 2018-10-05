package other;

public class SelectSort {
    public static void main(String[] args) {
        int[] data = {9,8,7,6,5,4,3,2,1};
        bSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void bSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = 0;
            int step = 0;
            for(int k=0; k<data.length; k++) {
                if(data[k] < data[min]) {
                    min = k;
                }
            }

            if(min != step) {
                int tmp = data[min];
            }

        }
    }
}
