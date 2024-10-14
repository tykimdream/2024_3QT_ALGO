package bronze;

import java.util.Scanner;

public class b2_14697_방배정하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int n = sc.nextInt();
		
		for(int i = 0; i <= 50; i++) {
			for(int j = 0; j <= 50; j++) {
				for(int t = 0; t <= 50; t++) {
					if((i * a) + (j * b) + (t * c) == n) {
						answer++;
					}
				}
			}
		}
		System.out.println(answer == 0 ? 0 : 1);
		return;
	}
}
