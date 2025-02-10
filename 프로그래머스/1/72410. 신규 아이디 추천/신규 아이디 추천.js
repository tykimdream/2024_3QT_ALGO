function solution(new_id) {
    let preprocessed = new_id
        .toLowerCase()
        .replace(/[^a-z0-9._-]/g, '')
        .replace(/\.{2,}/g, '.')
        .replace(/^\.|\.$/g, '')
    
    preprocessed = preprocessed.length === 0 ? 'a' : preprocessed;
    preprocessed = preprocessed.slice(0, 15).replace(/\.$/g, '');
    
    const lastWord = preprocessed[preprocessed.length - 1];
    while(preprocessed.length < 3){
            preprocessed += lastWord
    }
    
    return preprocessed
}