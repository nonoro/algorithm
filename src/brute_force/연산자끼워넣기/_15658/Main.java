package brute_force.연산자끼워넣기._15658;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.*;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, max, min;
    static int[] nums, operator, order;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        nums = new int[N + 1];
        operator = new int[5];
        order = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }

        for (int i = 1; i <= 4; i++) {
            operator[i] = scan.nextInt();
        }

        max = MIN_VALUE;
        min = MAX_VALUE;
    }

    public static void main(String[] args) {
        input();

        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    static void rec_func(int k) {
        if (N == k) {
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (operator[cand] >= 1) {
                    order[k] = cand;
                    operator[cand]--;
                    rec_func(k + 1);
                    operator[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    private static int calculator() {
        int firstNum = nums[1];
        for (int i = 1; i <= N; i++) {
            if (order[i] == 1) {
                firstNum += nums[i + 1];
            }

            if (order[i] == 2) {
                firstNum -= nums[i + 1];
            }

            if (order[i] == 3) {
                firstNum *= nums[i + 1];
            }

            if (order[i] == 4) {
                firstNum /= nums[i + 1];
            }
        }
        return firstNum;
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
