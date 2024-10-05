class PriorityQueue{
    constructor(){
        this.values = [];
    }
    
    enqueue(value, priority){
        this.values.push({value, priority});
        this.sort();
    }
    
    dequeue(){
        return this.values.shift();
    }
    
    sort(){
        this.values.sort((a, b) => a.priority - b.priority);
    }
}

function solution(n, edge) {
    var answer = 0;
    const graph = Array(n + 1).fill().map(()=>[]);
    for([a, b] of edge){
        graph[a].push([b, 1]);
        graph[b].push([a, 1]);
    }
    
    const distances = Array(n+1).fill().map(()=> Infinity);
    const pq = new PriorityQueue();
    
    pq.enqueue(1, 0);
    distances[0] = distances[1] = 0;
    
    while(pq.values.length){
        const {value : current, priority : currentDistance} = pq.dequeue();
        if(distances[current] < currentDistance) continue;
        
        for([next, weight] of graph[current]){
            let distance = currentDistance + weight
            if(distances[next] > distance){
                distances[next] = distance;
                pq.enqueue(next, distance)
            }
        }
    }
    let max = Math.max(...distances)
    return distances.filter((e) => e == max).length;
}