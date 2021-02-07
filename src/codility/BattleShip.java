package codility;

import java.util.*;

public class BattleShip {

    public static void main(String[] args) {
        BattleShip battleShip = new BattleShip();

        Collection collection = new ArrayList();
        String solution = battleShip.solution(3, "1A 1B,2C 2C", "1B");
        System.out.println(solution);
    }

    public String solution(int N, String S, String T) {
        List<Ship> ships = parseShips(S);
        List<Point> hits = parseHits(T, N * N);

        int touched = 0, sunken = 0;
        for (Ship current : ships) {
            int touching = current.getHits(hits);
            if (touching > 0) {
                if (touching == current.getSize()) {
                    sunken++;
                } else {
                    touched++;
                }
            }
        }

        return "" + sunken + "," + touched;
    }

    public List<Point> parseHits(String hits, int maxHits) {
        List<Point> hitsList = new ArrayList<>(maxHits);
        String[] coords = hits.split(" ");
        for (String coord : coords) {
            hitsList.add(new Point(coord));
        }
        return hitsList;
    }

    public List<Ship> parseShips(String ships) {
        List<Ship> shipsList = new ArrayList<Ship>();
        String[] shipsCoords = ships.split(",");
        for (String shipCoord : shipsCoords) {
            String[] coords = shipCoord.split(" ");
            shipsList.add(new Ship(new Point(coords[0]), new Point(coords[1])));
        }
        return shipsList;
    }

    static public class Point {
        int x;
        int y;

        public Point(String coord) {
            x = (coord.toUpperCase().charAt(1)) - ('A');
            y = (coord.charAt(0)) - ('1');
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean greaterOrEqual(Point other) {
            return x >= other.x && y >= other.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static class Ship {
        private final Point topLeft;
        private final Point bottomRight;

        public Ship(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        public int getSize() {
            return (Math.abs(topLeft.getX() - bottomRight.getX()) + 1)
                    * (Math.abs(topLeft.getY() - bottomRight.getY()) + 1);
        }

        @Override
        public String toString() {
            return "(" + topLeft + ", " + bottomRight + ")";
        }

        public int getHits(List<Point> shots) {
            int hits = 0;
            for (Point shot : shots) {
                if (shot.greaterOrEqual(topLeft) && bottomRight.greaterOrEqual(shot)) {
                    hits++;
                }
            }

            return hits;
        }
    }
}
