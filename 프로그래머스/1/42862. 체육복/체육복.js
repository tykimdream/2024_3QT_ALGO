function solution(n, lost, reserve) {
    let students = Array(n).fill(1);
    
    for(let l of lost) students[l - 1]--;
    for(let r of reserve) students[r - 1]++;
    
    for(let i = 0; i < n; i++){
        if(students[i] == 0){
            if(students[i - 1] == 2){
                students[i - 1] = 1;
                students[i] = 1;
            } else if(students[i + 1] == 2){
                students[i + 1] = 1;
                students[i] = 1;
            }
        }
    }
    
    return students.filter(e => e > 0).length;
}