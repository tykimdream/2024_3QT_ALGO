class Solution {
    public int solution(int[][] sizes) {
        int w = 1;
        int h = 1;
        
        for(int i = 0; i < sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            w = Math.max(w, max);
            h = Math.max(h, min);
        }
        return w * h;
    }
}