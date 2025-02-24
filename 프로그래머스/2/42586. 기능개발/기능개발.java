import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<int[]> que = new LinkedList<>();
        
        for(int i = 0; i < speeds.length; i++){
            que.add(new int[]{progresses[i], speeds[i]});
        }
        
        while(que.isEmpty() == false){
            int size = que.size();
            for(int i = 0; i < size; i++){
                int[] current = que.poll();
                current[0] += current[1];
                que.offer(current);
            }
            
            int count = 0;
            while(que.isEmpty() == false && que.peek()[0] >= 100){
                count++;
                que.poll();
            }
            if(count > 0) answer.add(count);
            
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}