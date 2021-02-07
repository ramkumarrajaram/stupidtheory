package kickstart;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Ramkumar Rajaram
 */
public class ATMQueue {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ATMQueueSolver solver = new ATMQueueSolver();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Person {
        private int index;
        private int money;

        public int getMoney() {
            return this.money;
        }
    }

    static class ATMQueueSolver {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int numberOfPersons = sc.nextInt();
            int maxAmountPerRound = sc.nextInt();

            List<Person> personList = new LinkedList<>();

            for (int i=1; i<=numberOfPersons; i++) {
                Person person = new Person();
                person.index = i;
                int amount = sc.nextInt();
                if(maxAmountPerRound == amount) {
                    person.money = amount / maxAmountPerRound;
                } else {
                    person.money = amount / maxAmountPerRound + 1;
                }
                personList.add(person);
            }

            personList.sort(Comparator.comparingInt(Person::getMoney));

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < personList.size(); i++) {
                builder.append(personList.get(i).index).append(" ");
            }

            out.println("Case #" + testNumber + ": " + builder.toString().trim());
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


