package brute_force._15651_중복허용_완전탐색;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        // selected 의 배열 크기를 M + 1 을 하는 이유
        // M 의 자리까지는 값을 넣어야해서 k == M 일때 출력을 하게되면 M 의 자리까지 안들어가고 M - 1 자리까지만 들어가기 때문에
        // M + 1 을 해서 빈자리를 만들어 k 의 값이 배열의 빈자리의 인덱스와 같게되면 전에 빌더에 모아놨던 것을 출력한다.
        selected = new int[M + 1];
    }

    static int N, M;
    static int[] selected;

    static void rec_func(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++) {
                selected[k] = cand;

                rec_func(k + 1);
                selected[k] = 0;
            }
        }
    }


    // Recurrence Function (재귀 함수)
    // 만약 M 개를 전부 고름   => 조건에 맞는 탐색을 한 가지 성공한 것!
    // 아직 M 개를 고르지 않음 => k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    public static void main(String[] args) {
        input();

        // 1 번째 원소부터 M 번째 원소를 조건에 맞는 모든 방법을 찾아줘
        rec_func(1);
        System.out.println(sb.toString());
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
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
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
