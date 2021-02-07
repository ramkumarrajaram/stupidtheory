package codility;

import java.math.BigInteger;

public class Soldeier {

    public static void main(String args[]) {

        int[][] twoDArray = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};


        int x_size = twoDArray[0].length;
        int y_size = twoDArray.length;

        int[][] counterClockWise = new int[x_size][y_size];

        int x_index = 0;
        int y_index = 0;
        for (int i = x_size-1; i >=0 ; i--) {
            for (int j =0; j<y_size; j++) {
                int x = twoDArray[j][i];
                counterClockWise[x_index][y_index] = x;
                y_index++;
            }
            y_index = 0;
            x_index++;
        }

        for (int i = 0; i < counterClockWise.length; i++) {
            for (int j=0; j<counterClockWise[i].length; j++) {
                System.out.print(counterClockWise[i][j] + " ");
            }
            System.out.println();
        }
    }



}
