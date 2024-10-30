class Solution {
    public int[] solution(int brown, int yellow) {
        int totalCarpet = brown + yellow;
        
        for(int w = 3; w <= Math.sqrt(totalCarpet); w++){
            if(totalCarpet % w == 0){
                int h = totalCarpet / w;
                if((w-2) * (h-2) == yellow){
                    return new int[] {h, w};
                }
            }
            
        }
        
        
        return new int[] {};
    }
}