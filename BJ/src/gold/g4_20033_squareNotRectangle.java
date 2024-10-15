package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class g4_20033_squareNotRectangle {
	static int n;
	static int[] arr;
	static int start = 1, end = 0, mid = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(arr[i], end);
		}

		while (start <= end) {
			mid = (start + end) / 2;

			if (valid(mid)) {
				// �� ����������
				start = mid + 1;
			} else {
				// �������
				end = mid - 1;
			}
		}
		System.out.println(mid);
	}

	public static boolean valid(int side) {
	    int count = 0;
	    for (int height : arr) {
	        if (height >= side) {
	            count++;
	            if (count >= side) return true;
	        } else {
	            count = 0;
	        }
	    }
	    return false;
	}
	
//	public static boolean valid(int height) {
//		for (int i = 0; i < n; i++) {
//			if (arr[i] < height)
//				continue;
//			for (int j = i; j < n; j++) {
//				// ���̺��� ���������� Ȯ�� or ���簢���� �������
//				// ���簢���� ���� == return true;
//				if (j - i == height)
//					return true;
//				if (arr[i] > arr[j]) {
//					// j �������� �����ص���
//					i = j - 1;
//					break;
//				}
//			}
//		}
//
//		return false;
//	}

}
