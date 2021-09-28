public class App {

    public static void main(String[] arg) {
        swap(5, 10);
        int N = 15;
        int[] k = new int[]{10, 5};
        int K = k.length;
        System.out.println(arrange(N, K, k));
        System.out.println(color(10, 5));
    }

    public static void swap(int a, int b) {
        System.out.println("Before A is: " + a + " B is: " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After A is: " + a + " B is: " + b);
    }
//Problem 5 using for loops
    public static int arrange(int N, int K, int[] k) {
        int[][] C = new int[N + 1][N + 1];
        int i, j;

        for (i = 0; i <= N; i++) {
            for (j = 0; j <= i; j++) {


                if (j == 0 || j == i) {
                    C[i][j] = 1;
                }
                else {
                    C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]);
                }
            }
        }
        int[] dp = new int[K + 1];
        int count = 0;

        dp[0] = 1;
        for (i = 0; i < K; i++)
        {

            dp[i + 1] = (dp[i] * C[count + k[i] - 1][k[i] - 1]);
            count += k[i];
        }

        return dp[K];
    }
//Problem 5 using recursion
    public static int color(int k1, int k2) {
        if(k1 <0 || k2 <0)
        {
            return -1;
        }
        else if (k2 == 1) {
            return 1;
        }
        else if (k1 == 1) {
            return k2;
        }
        else {
            int result = color(k1 - 1, k2) + color(k1, k2 - 1);
            return result;
        }


    }
}
