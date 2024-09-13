import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		int N = sc.nextInt();
		
		// 택, 영, 남
		for(int t = 1; t < N; t++) {
			for(int y = 1; y < N; y++) {
				for(int n = 1; n < N; n++) {
					if(t + y + n == N && 
						n >= y + 2 &&
						t % 2 == 0) {
						answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
		return;
	}

}