package brute_force.백트래킹._1182_부분_수열의_합;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, S, ans;
    static int[] nums;

    static void input() {
        FastReader scan = new FastReader();

        N = scan.nextInt();
        S = scan.nextInt();

        nums = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }
    }

    public static void main(String[] args) {
        input();

        rec_func(1, 0);

        if (S == 0) {
            ans--;
        }
        System.out.println(ans);
    }

    static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (value == S) {
                ans++;
            }
        } else {
            // k 번째 원소를 포함시킬 지 결정하고 재귀호출해주기
            // Include
            rec_func(k + 1, value + nums[k]);
            // Not Include
            rec_func(k + 1, value);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
