import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> bri = new LinkedList<>();
        
        for(int t : truck_weights) que.add(new int[] {t, -1});
        
        while(que.isEmpty() == false){
            int[] temp = que.peek();
            
            int curW = 0;
            if(bri.isEmpty() == false){
                for(int[] t : bri){
                    curW += t[0];
                }
            }
            
            // 다리에 빈 자리가 있는 지 && 다리에 올라갈 수 있는 상태인지 (중량 확인)
            if(bri.size() < bridge_length && curW + temp[0] <= weight){
                que.poll();
                bri.add(temp);
            }
            
            // 다리에 있던 애들 시간 추가
            for(int[] t : bri){
                t[1]++;
            }
        
            while(bri.size() > 0 && bri.peek()[1] == bridge_length - 1){
                bri.poll(); 
            }
            answer++;
        }
        
        while(bri.isEmpty() == false){
            // 다리에 있던 애들 시간 추가
            for(int[] t : bri){
                t[1]++;
            }
        
            while(bri.size() > 0 && bri.peek()[1] == bridge_length){
                bri.poll(); 
            }
            answer++;
        }
        
        return answer;
    }
}