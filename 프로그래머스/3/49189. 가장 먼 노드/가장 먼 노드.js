class PriorityQue{
    constructor(){
        this.values = [];
    }
    
    enque(value, priority){
        this.values.push({value, priority});
        this.sort();
    }
    
    deque(){
        return this.values.shift();
    }
    sort(){
        this.values.sort((a, b) => a.priority - b.priority);
    }
}

function solution(n, edge) {
    const graph = Array(n+1).fill().map(()=>[]);
    for([a, b] of edge){
        graph[a].push([b, 1]);
        graph[b].push([a, 1]);
    }
    
    const distances = Array(n+1).fill().map(() => Infinity);
    distances[0] = distances[1] = 0;
    
    const pq = new PriorityQue();
    pq.enque(1, 0);
    
    while(pq.values.length){
        const {value : current, priority: currentDistance} = pq.deque();
        
        for([next, weight] of graph[current]){
            if(weight > distances[next]) continue;
            
            let distance = currentDistance + weight;
            if(distance < distances[next]){
                distances[next] = distance;
                pq.enque(next, distance);
            }
        }
    }
    let max = Math.max(...distances);
    return distances.filter((e) => e == max).length;
    
}
















