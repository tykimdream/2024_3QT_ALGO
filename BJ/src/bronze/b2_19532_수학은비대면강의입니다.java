package bronze;

import java.util.Scanner;

public class b2_19532_수학은비대면강의입니다 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		for(int i = -999; i <= 999; i++) {
			for(int j = -999; j <= 999; j++) {
				if(a * i + b * j == c && d * i + e * j == f) {
					System.out.println(i + " " + j);
					return;
				}
			}
		}
	}

}
