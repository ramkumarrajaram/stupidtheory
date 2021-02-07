package kickstart;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Ramkumar Rajaram
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NumberSolver solver = new NumberSolver();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NumberSolver {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int initialNumber = sc.nextInt();
            int finalNumber = sc.nextInt();

            int initialNumberCount = getNumberCount(initialNumber);
            int finalNumberCount = getNumberCount(initialNumber);

            

            int boringCount = 0;
            for (int number = initialNumber; number <= finalNumber; number++) {
                int digitCount = 1;

                boolean isBoring = false;
                while (number != 0) {
                    if ((number % 2 == 0 && digitCount % 2 == 0) || (number % 2 != 0 && digitCount % 2 != 0)) {
                        isBoring = true;
                    }
                    number /= 10;
                    ++digitCount;
                    if (isBoring) {
                        ++boringCount;
                    }
                }
            }

            out.println("Case #" + testNumber + ": " + boringCount);
        }

        private int getNumberCount(int initialNumber) {
            int initialNumberCount = 0;
            while (initialNumber != 0) {
                initialNumber /= 10;
                initialNumberCount++;
            }
            return initialNumberCount;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}


