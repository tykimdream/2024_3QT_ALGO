package silver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class s4_5883_������9S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int temp = 0;
		int answer = 0;
		
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < n;i++) {
			arr[i] = sc.nextInt();
			set.add(arr[i]);
		}

		// set���� �ϳ��� ������, �ش� �뷮�� �����ϴ� ������ ����
		for(int x : set) {
			// ������ ���� x
			for(int i = 0; i < n; i++) {
				temp = 0;
				for(int j = i; j < n; j++) {
					if(arr[i] == arr[j]) temp++;
					else if(arr[j] == x) continue;
					else break;
				}
				answer = Math.max(answer, temp);
			}
		}
		System.out.println(answer);
	}

}
