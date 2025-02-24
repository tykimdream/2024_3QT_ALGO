import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> que = new LinkedList<>();
        Queue<int[]> bridge = new LinkedList<>();
        int time = 0;
        
        for(int x : truck_weights){
            que.offer(x);
        }
        
        while(que.isEmpty() == false || bridge.isEmpty() == false){
            int bridge_weight = 0;
            int size =  bridge.size();
            
            for(int i = 0; i < size; i++){
                int[] current = bridge.poll();
                current[1] -= 1;
                if(current[1] > 0){
                    bridge_weight += current[0];    
                    bridge.offer(current);
                }
            }
            
            // 트럭 추가 가능
            if(que.isEmpty() == false && bridge_weight + que.peek() <= weight){
                bridge.offer(new int[]{que.poll(), bridge_length});
            }     
            time++;
        }
        
        return time;
    }
}