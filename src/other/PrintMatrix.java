package other;

import java.util.ArrayList;
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0) return new ArrayList<Integer>();

        return getList(matrix, 0, 0, matrix.length, matrix[0].length);
    }

    public ArrayList<Integer> getList(int [][] matrix, int x, int y, int length, int width) {
        ArrayList<Integer> result = new ArrayList<>();

        if(length>2 && width >2) {
            //left
            for(int i=0; i<length-1; i++) {
                result.add(matrix[x+i][y]);
            }

            //down
            for(int i=0; i<width-1; i++) {
                result.add(matrix[x+length-1][y+i]);
            }
            //right

            for(int i=0; i<length-1; i++) {
                result.add(matrix[x+length-1-i][y+width-1]);
            }

            for(int i=0; i<width-1; i++) {
                result.add(matrix[x][y+width-1-i]);
            }
            //up

//            result.addAll(getList(int[][] matrix, x+1, y+1, length-2, width-2));
        } else {
//            if(length == 1)

        }

        return new ArrayList<>();
    }
}