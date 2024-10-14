package silver;

import java.util.Arrays;
import java.util.Scanner;

public class s3_7696_반복하지않는수 {
	static final int MAX = 1000000;
    static int[] nonDuplicateNumbers = new int[MAX + 1];
    static boolean[] used = new boolean[10];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        precompute();
        
        while (true) {
            int t = sc.nextInt();
            if (t == 0) break;
            System.out.println(nonDuplicateNumbers[t]);
        }
    }

    public static void precompute() {
        int count = 1;
        for (int i = 1; count <= MAX; i++) {
            if (isNonDuplicateNumber(i)) {
                nonDuplicateNumbers[count++] = i;
            }
        }
    }

    public static boolean isNonDuplicateNumber(int n) {
    	Arrays.fill(used, false);
    	
        while (n > 0) {
            int digit = n % 10;
            if (used[digit]) return false;
            used[digit] = true;
            n /= 10;
        }
        return true;
    }
}