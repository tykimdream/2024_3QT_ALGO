import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = 0, answer = 0;
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();				
			}
		}
		
		for(int i = 0; i < n; i++) {
			temp = 0;
			boolean[] cover = new boolean[1001];
			// i번째 cow를 제외한 나머지의 결과 값
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				for(int t = arr[j][0]; t < arr[j][1]; t++) {
					cover[t] = true;
				}
			}
			for(int flag = 0; flag < 1001; flag++) {
				if(cover[flag]) temp++;
			}
			answer = Math.max(answer, temp);
		}
		System.out.println(answer);
		return;
	}

}