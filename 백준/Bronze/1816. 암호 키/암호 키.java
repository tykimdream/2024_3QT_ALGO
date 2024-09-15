import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        long input;
        for (int i = 0; i < N; i++) {
            input = sc.nextLong();
            sb.append(isAppropriateKey(input) ? "YES" : "NO").append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }

    public static boolean isAppropriateKey(long input) {
        for (int i = 2; i <= 1000000; i++) {
            if (input % i == 0)
                return false;
        }
        return true;
    }
}