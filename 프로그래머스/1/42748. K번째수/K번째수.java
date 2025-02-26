import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int idx = 0; idx < commands.length; idx++) {
            int[] command = commands[idx];
            int i = command[0] - 1;
            int j = command[1];     
            int k = command[2] - 1;
            
            int[] subArray = Arrays.copyOfRange(array, i, j);
            Arrays.sort(subArray);
            answer[idx] = subArray[k];

        }
        return answer;
    }
}