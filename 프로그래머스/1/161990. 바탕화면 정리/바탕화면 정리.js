function solution(wallpaper) {
    let minX = 51, minY = 51, maxX = -1, maxY = -1;
    
    wallpaper.forEach((row, index) =>{
        const startFile = row.indexOf("#");
        const endFile = row.lastIndexOf("#");
        if(startFile >= 0){
            minX = Math.min(minX, index);
            maxX = Math.max(maxX, index + 1);
            minY = Math.min(minY, startFile);
            maxY = Math.max(maxY, endFile + 1);
        }
    })
    
    return [minX, minY, maxX, maxY];
}