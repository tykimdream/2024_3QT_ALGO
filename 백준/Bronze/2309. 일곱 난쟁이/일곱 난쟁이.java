import java.io.*;
import java.util.*;

public class Main {
	static boolean flag = false;
	static int n = 9;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[n];
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		// 9개 중 7개를 고르는 9C7의 문제이다.
		// 하지만 9C2가 뭔가 더 빠를 거 같으니 안뽑을 2명을 뽑아보자
		comb(0, 0, new boolean[n], arr);
		return;
	}
	public static void comb(int index, int depth, boolean[] selected, int[] arr) {
		if(flag) return;
		
		if(depth == 2) {
			int sum = 0;
			for(int i = 0; i < n; i++) {
				if(selected[i] == false) sum += arr[i];
			}
			if(sum == 100) {
				
				for(int i = 0; i < n; i++) {
					if(selected[i] == false) System.out.println(arr[i]);
				}
				flag = true;
			}
			return;
		}
		for(int i = index; i < n; i++) {
			selected[i] = true;
			comb(i + 1, depth + 1, selected, arr);
			selected[i] = false;
		}
	}

}