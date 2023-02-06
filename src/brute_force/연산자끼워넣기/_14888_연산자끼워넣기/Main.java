package brute_force.연산자끼워넣기._14888_연산자끼워넣기;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, max, min;
    static int[] nums, operators, order;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt(); // 입력할 숫자의 갯수
        // 길이가 N 인 배열인데 실제 크기는 N + 1 로 하는 이유
        // 배열의 0 번째 자리는 사용하지 않기 때문
        nums = new int[N + 1];      // 실제 숫자가 저장될 배열
        operators = new int[5];     // 연산자의 갯수가 저장될 배열 인덱스번호 1 2 3 4 = + - * /
        order = new int[N + 1];     // 연산자 순서가 기록될 배열

        for (int i = 1; i <= N; i++) {
            nums[i] = scan.nextInt();
        }

        for (int i = 1; i <= 4; i++) {
            operators[i] = scan.nextInt();
        }

       /*  max 에 최소값으로 min 에 최대값으로 초기화 해주는 이유
         나중에 아래에서 나오는 값을가지고 그 값중에 최대의 값을 뽑아야 하는데
         - 값이 나올수도 잇고 그렇기 때문에 max 나 min 을 0 으로 초기화하지 않고
         max 의 경우 int 범위의 가장 작은 값으로 초기화 함으로써 아래에서 구한 값들과 비교했을때
         가장 낮은값과 비교하여 점점 큰 값을 찾을 수 있고
         min 의 경우 int 범위의 가장 큰 값으로 초기화 함으로써 아래에서 구한 값들과 비교했을때
         가장 큰 값과 비교하여 점점 작은 값을 찾을 수 있기 때문이다.*/
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        input();

        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
    }

    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        } else if (operator == 2) {
            return operand1 - operand2;
        } else if (operator == 3) {
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
    }

    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    int new_value = calculator(value, cand, nums[k + 1]);
                    rec_func(k + 1, new_value);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
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
