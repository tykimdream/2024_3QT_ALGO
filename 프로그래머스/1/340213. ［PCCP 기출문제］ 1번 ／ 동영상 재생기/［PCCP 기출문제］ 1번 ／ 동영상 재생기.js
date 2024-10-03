function solution(video_len, pos, op_start, op_end, commands) {
    // 초로 변환하고 연산하자
    let video_len_sec = Number(video_len.split(":")[1]) + Number(video_len.split(":")[0]) * 60;
    let pos_sec = Number(pos.split(":")[1]) + Number(pos.split(":")[0]) * 60;
    let op_start_sec = Number(op_start.split(":")[1]) + Number(op_start.split(":")[0]) * 60;
    let op_end_sec = Number(op_end.split(":")[1]) + Number(op_end.split(":")[0]) * 60;
    
    for(let x of commands){
        if(pos_sec >= op_start_sec && pos_sec <= op_end_sec)
                    pos_sec = op_end_sec;
        switch(x){
            case "next":
                pos_sec += 10;
                if(pos_sec >= op_start_sec && pos_sec <= op_end_sec) pos_sec = op_end_sec;
                if(pos_sec > video_len_sec) pos_sec = video_len_sec;
                break;
            case "prev":
                pos_sec -= 10;
                if(pos_sec >= op_start_sec && pos_sec <= op_end_sec) pos_sec = op_end_sec;
                if(pos_sec < 0) pos_sec = 0;
                break;
        }
    }
    
    return String(parseInt(pos_sec/60)).padStart(2, 0) + ":" + String(pos_sec % 60).padStart(2, 0);
}