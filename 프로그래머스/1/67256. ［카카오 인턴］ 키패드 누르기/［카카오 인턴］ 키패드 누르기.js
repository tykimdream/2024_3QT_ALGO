function solution(numbers, hand) {
    var answer = '';
    const pos = [
        [3, 1],
        [0, 0],
        [0, 1],
        [0, 2],
        [1, 0],
        [1, 1],
        [1, 2],
        [2, 0],
        [2, 1],
        [2, 2],
        [3, 0],
        [3, 2],
    ]
    
    let leftHand = pos[10]
    let rightHand = pos[11]
    
    numbers.forEach((number) =>{
        if(number === 1 || number === 4 || number === 7) {
            answer += 'L'
            leftHand = pos[number]
        }
        else if(number === 3 || number === 6 || number === 9){
            answer += 'R';
            rightHand = pos[number]
        } 
        else{
            // 가까운 위치
            const leftDis = Math.abs(leftHand[0] - pos[number][0]) + Math.abs(leftHand[1] - pos[number][1]);
            const rightDis = Math.abs(rightHand[0] - pos[number][0]) + Math.abs(rightHand[1] - pos[number][1]);
            
            if(leftDis < rightDis){
                answer += 'L'
                leftHand = pos[number]
            } else if(leftDis > rightDis){
                answer += 'R';
                rightHand = pos[number]
            } else{
                if(hand === 'right'){
                    answer += 'R'
                    rightHand = pos[number]
                } else{
                    answer += 'L';
                    leftHand = pos[number]
                }
            }
        }
    })
    return answer;
}