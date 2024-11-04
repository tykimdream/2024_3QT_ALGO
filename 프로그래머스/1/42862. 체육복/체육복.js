function solution(n, lost, reserve) {
    var answer = 0;
    const student = Array(n).fill(1);
    for(r of reserve){
        student[r - 1]++;
    }
    
    for(l of lost){
        student[l - 1]--;
    }
    
    for(let i = 0; i < n; i++){
        if(student[i] == 0){
            if(student[i - 1] && student[i - 1] > 1){
                student[i]++;
                student[i - 1]--;
            } else if(student[i + 1] && student[i + 1] > 1){
                student[i]++;
                student[i + 1]--;
            }
        }
    }
    
    
    return student.filter(e => e > 0).length;
}