import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//        LongestArithmetic solver = new LongestArithmetic();
//        int testCount = Integer.parseInt(in.next());
//        for (int i = 1; i <= testCount; i++)
//            solver.solve(i, in, out);
//        out.close();

        List<Integer> integers = computeDivision(Arrays.asList(100, 91), 6);

        System.out.println(integers);
    }

    public static List<Integer> computeDivision(List<Integer> inputArray, int division) {

        List<Integer> list = new ArrayList<>();
        for (Integer integer : inputArray) {
            BigDecimal divide = BigDecimal.valueOf(integer)
                    .divide(BigDecimal.valueOf(division), 0, BigDecimal.ROUND_UNNECESSARY);
            Integer intValue = divide.intValue();
            list.add(intValue);
        }
        return list;
    }

    static class LongestArithmetic {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int n = sc.nextInt();

            int a[] = new int[n];
            for (int i = 0; i < n; ++i)
                a[i] = sc.nextInt();

            int diff = Integer.MIN_VALUE, cnt = 0;
            int ans = 0;
            for (int i = 1; i < n; ++i) {
                if (a[i] - a[i - 1] != diff) {
                    ans = Math.max(ans, cnt + 1);
                    cnt = 1;
                    diff = a[i] - a[i - 1];
                } else
                    cnt++;
            }
            ans = Math.max(ans, cnt + 1);
            out.println("Case #" + testNumber + ": " + ans);
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

