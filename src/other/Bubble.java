package other;

public class Bubble {
    public static void bubbleSort(int[] data) {

        for (int i = 0; i < data.length - 1; i++) {// 控制趟数
            for (int j = 0; j < data.length - i - 1; j++) {

                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }

    }
}
