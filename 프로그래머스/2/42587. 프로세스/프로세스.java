import java.util.*;

class Solution {
    class Node implements Comparable<Node>{
        int p;
        int id;
        
        public Node(int p, int i){
            this.p = p;
            this.id = i;
        }
        
        @Override
        public int compareTo(Node a){
            return a.p - this.p;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Node> que = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0; i < priorities.length; i++){
            Node node = new Node(priorities[i], i);
            que.offer(node);
            pq.offer(node);
        }
        
        int count = 0;
        
        while(que.isEmpty() == false){
            Node current = que.poll();
            
            if(current.p >= pq.peek().p){
                pq.poll();
                count++;
                if(current.id == location) return count;
            }else{
                que.offer(current);
            }
        }
        
        return count;
    }
}