import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int x : scoville){
            pq.offer(x);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            int mix = pq.poll() + pq.poll() * 2;
            // System.out.println(mix);
            pq.offer(mix);
            answer++;
            // System.out.println(pq.peek());
        }
        
        // return answer;
        return  pq.peek() < K ?  -1 : answer;
    }
}