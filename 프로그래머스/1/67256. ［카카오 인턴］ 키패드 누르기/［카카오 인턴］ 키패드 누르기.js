function solution(numbers, hand) {
    let answer = '';
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
        if(number === 1 || number === 4 || number === 7) left(number)
        else if(number === 3 || number === 6 || number === 9)right(number)

        else{
            const leftDis = Math.abs(leftHand[0] - pos[number][0]) + Math.abs(leftHand[1] - pos[number][1]);
            const rightDis = Math.abs(rightHand[0] - pos[number][0]) + Math.abs(rightHand[1] - pos[number][1]);

            if(leftDis < rightDis) left(number)            
            else if(leftDis > rightDis) right(number)
            else{
                if(hand === 'right') right(number)
                else left(number)
            }
        }
    })
    
    function left(number){
        answer += 'L'
        leftHand = pos[number]
    }
    
    function right(number){
        answer += 'R'
        rightHand = pos[number]
    }
    
    return answer;
}