// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public int solution(String pos) {
			final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
			final int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

			char ch = 'A';
			int cnt = 0;
			char[] tmp = pos.toCharArray();

			int x = (tmp[0] - ch) + 1;
			int y = tmp[1] - '0';

			for(int d = 0; d < 8; d++){
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx > 0 && nx < 8 && ny > 0 && ny <= 8){
					cnt++;
				}
			}
			
        return cnt;
    }
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String pos = "A7";
        int ret = sol.solution(pos);
    	
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}