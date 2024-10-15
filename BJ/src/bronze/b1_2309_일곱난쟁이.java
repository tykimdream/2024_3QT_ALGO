package bronze;

import java.io.*;
import java.util.*;

public class b1_2309_�ϰ������� {
	static boolean flag = false;
	static int n = 9;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[n];
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		// 9�� �� 7���� ���� 9C7�� �����̴�.
		// ������ 9C2�� ���� �� ���� �� ������ �Ȼ��� 2���� �̾ƺ���
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
