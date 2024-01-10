package array;

import java.util.ArrayList;
import java.util.Arrays;

public class TraverseMatrix {
    public static void main(String[] args) {
        TraverseMatrix obj = new TraverseMatrix();
        obj.printMatrix(getMatrix());
        obj.printPrefixSumMatrix(getMatrix());
    }

    private static ArrayList<ArrayList<Integer>> getMatrix() {
        return new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(4, 5, 6)),
                new ArrayList<>(Arrays.asList(7, 8, 9)),
                new ArrayList<>(Arrays.asList(10, 11, 12))));
    }

    private void printPrefixSumMatrix(ArrayList<ArrayList<Integer>> matrix) {
        int row = matrix.size();
        int col = matrix.get(0).size();
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                int sum = matrix.get(i).get(j);
//                if(i != 0){
//                    sum += matrix.get(i-1).get(j);
//                }
                if(j != 0){
                    sum += matrix.get(i).get(j-1);
                }
                matrix.get(i).set(j, sum);
            }
        }
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                int sum = matrix.get(i).get(j);
                if(i != 0){
                    sum += matrix.get(i-1).get(j);
                }
//                if(j != 0){
//                    sum += matrix.get(i).get(j-1);
//                }
                matrix.get(i).set(j, sum);
            }
        }
        System.out.println("** Printing Prefix Sum Matrix **");
        printMatrix(matrix);
    }

    private void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        int row = matrix.size();
        int col = matrix.get(0).size();
        for(int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                System.out.print(matrix.get(i).get(j) + "\t\t");
            }
            System.out.println();
        }
    }
}
