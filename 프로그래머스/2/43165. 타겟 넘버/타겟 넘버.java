class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    
    public int dfs(int[] numbers, int index, int sum, int target){
        if(index == numbers.length){
            if(sum == target) return 1;
        }
        for(int i = index; i < numbers.length; i++){
            return dfs(numbers, i + 1, sum + numbers[i], target) + 
                dfs(numbers, i + 1, sum - numbers[i], target);
        }
        return 0;
    }
}