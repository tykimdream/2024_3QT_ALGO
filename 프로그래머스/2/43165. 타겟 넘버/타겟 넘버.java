class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    
    public int dfs(int[] numbers, int index, int sum, int target){
        if(index == numbers.length){
            if(sum == target) return 1;
            return 0;
        }
        
        return dfs(numbers, index + 1, sum + numbers[index], target) + 
                dfs(numbers, index + 1, sum - numbers[index], target);
    }
}