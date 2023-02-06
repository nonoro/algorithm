package brute_force.백트래킹._148889_스타트와_링크;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int nums[][], check[];
    static int min = Integer.MAX_VALUE;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        nums = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nums[i][j] = scan.nextInt();
            }
        }
        check = new int[N + 1];
    }

    public static void main(String[] args) {
        input();

        dfs(0, 0);

        System.out.println(min);
    }

    static void dfs(int start, int cnt) {

        if (cnt == N / 2) {
            cal();

            return;
        }

        for (int i = start + 1; i <= N; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                dfs(i, cnt + 1);
                check[i] = 0;
            }
        }


    }

    static void cal() {
        int start = 0, link = 0;
        int a[] = new int[(N / 2) + 1];
        int b[] = new int[(N / 2) + 1];
        int a_index = 1, b_index = 1;

        for (int i = 1; i <= N; i++) {
            if (check[i] == 1) {
                a[a_index++] = i;
            } else {
                b[b_index++] = i;
            }
        }

        start = divide(a);
        link = divide(b);

        int result = Math.abs(start - link);

        min = Math.min(result, min);
    }

    static int divide(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                result = result + nums[arr[i]][arr[j]] + nums[arr[j]][arr[i]];
            }
        }

        return result;
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

