import java.util.HashMap;

public class SquareTest {

    private static HashMap<String, Square> squareMap = new HashMap<String, Square>();

    public static void main(String args[]) {

        int N = 5;
        int rowCount = 3;
        int columnCount = 6;

        int currPosX = 2;
        int currPosY = 3;

        String direction = "EEWNS";

        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j <= columnCount; j++) {

                Square sq = new Square();
                sq.row = i;
                sq.column = j;
                sq.status = (currPosX == i && currPosY == j);

                squareMap.put(i + "" + j, sq);
            }
        }

        char[] cDirection = direction.toCharArray();

        int lastXPosition = 0;
        int lastYPosition = 0;

        for (int d = 0; d < cDirection.length; d++) {
            System.out.println(cDirection[d]);
            Square currentSq;
            if (cDirection[d] == 'E') {
                currPosY += 1;
                currentSq = checkSquare(currPosX, currPosY, false, false);
            } else if (cDirection[d] == 'W') {
                currPosY -= 1;
                currentSq = checkSquare(currPosX, currPosY, false, true);
            } else if (cDirection[d] == 'N') {
                currPosX -= 1;
                currentSq = checkSquare(currPosX, currPosY, true, true);
            } else {
                currPosX += 1;
                currentSq = checkSquare(currPosX, currPosY, true, false);
            }
            squareMap.put(currPosX + "" + currPosY, currentSq);

            if (currentSq.status) {
                lastXPosition = currentSq.row;
                lastYPosition = currentSq.column;
            }
        }

        System.out.println(lastXPosition + " " + lastYPosition);
    }

    private static Square checkSquare(int xPos, int yPos, boolean isX, boolean isNeg) {

        System.out.println(xPos + " " + yPos);
        Square sq = squareMap.get(xPos + "" + yPos);
        if (sq.status) {
            if (isX) {
                if (isNeg)
                    xPos -= 1;
                else
                    xPos += 1;
            } else {
                if (isNeg)
                    yPos -= 1;
                else
                    yPos += 1;
            }
            return checkSquare(xPos, yPos, isX, isNeg);
        } else {
            sq.status = true;
            return sq;
        }
    }
}

class Square {

    int row, column;
    boolean status;
}