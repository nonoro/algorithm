package brute_force.백트래킹._9663_N_Queen;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class Main2 {
    static StringBuilder sb = new StringBuilder();
    static int N, noc;
    static int[] col;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();

        col = new int[N + 1];
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        sb.append(noc);
        System.out.println(sb.toString());
    }

    static void rec_func(int row) {
        if (row == N + 1) {
            noc++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++) {
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) {
            return true;
        }

        if (r1 - c1 == r2 - c2) {
            return true;
        }

        if (r1 + c1 == r2 + c2) {
            return true;
        }

        return false;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
