function solution(today, terms, privacies) {
    var answer = [];
    const Terms = terms.reduce((acc, cur) => {
        const [type, exp] = cur.split(' ')
        acc[type] = Number(exp);
        return acc
    }, {})
    
    const todayDate = new Date(today);
    
    privacies.forEach((e, index) =>{
        const [date, type] = e.split(' ');
        // type에 따른 날짜 비교
        
        const privacyDate = new Date(date);
        privacyDate.setMonth(privacyDate.getMonth() + Terms[type]);
        
        if(privacyDate <= todayDate){
            answer.push(index + 1)
        }
    })
    
    return answer;
}