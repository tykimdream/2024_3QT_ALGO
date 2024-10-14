package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class g4_20033_squareNotRectangle_stack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
		int[] heights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        int maxSquareSide = 0;
        
        for(int i = 0; i <= n; i++) {
        	int h = i == n ? 0 : heights[i];
        	
        	while(stack.isEmpty() == false && heights[stack.peek()] > h) {
        		int height = heights[stack.pop()];
        		int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        		int side = Math.min(height, width);
        		
        		maxSquareSide = Math.max(maxSquareSide, side);
        	}
        	stack.push(i);
        }
        System.out.println(maxSquareSide);
	}

}
