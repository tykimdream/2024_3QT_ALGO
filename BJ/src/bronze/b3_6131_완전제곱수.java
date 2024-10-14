package bronze;

import java.util.Scanner;

public class b3_6131_완전제곱수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		
		for(int i = 1; i <= 500; i++) {
			for(int j = 1; j <= 500; j++) {
				if(Math.pow(i, 2) == Math.pow(j, 2) + n) answer++;
			}
		}
		System.out.println(answer);
		return;
	}

}
