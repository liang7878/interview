package other;

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {9,8,7,6,5,4,3,2,1};
        bSort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void bSort(int[] data) {
        for(int i=0; i<data.length-1; i++) {
            for(int j=data.length-1; j>0; j--) {
                if(data[j] < data[j-1]) {
                    int tmp = data[j];
                    data[j] = data[j-1];
                    data[j-1]=tmp;
                }
            }
        }
    }
}
