import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int count = 0;
        Queue<int[]> que = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            que.add(new int[] {priorities[i], i});
        }
        
        while(que.isEmpty() == false){
            int[] temp = que.poll();
            boolean pushed = false;
            
            for(int[] item : que){
                if(item[0] > temp[0]){
                    pushed = true;
                    break;
                }
            }
            
            if(pushed){
                que.add(temp);
            }else{
                count++;
                if(temp[1] == location) return count;
                
            }
            
        }
        
        return count;
    }
}