import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int answer = 1;
		int count = 0;
		
		for(int i = 0; i < 5; i++) {
			arr[i]= sc.nextInt();
		}
		
		while(true) {
			for(int i = 0; i < 5; i++) {
				if(answer % arr[i] == 0) count++;
			}
			if(count >=3) break;
			count = 0;
			answer++;
		}
		System.out.println(answer);
	}

}