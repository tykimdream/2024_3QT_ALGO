import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        final int LEN = numbers.length;
        String[] stringifyNumbers = new String[LEN];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < LEN; i++){
            stringifyNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(stringifyNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        for(int i = 0; i < LEN; i++){
            sb.append(stringifyNumbers[i]);
        }
        
        if(stringifyNumbers[0].equals("0")) {
            return "0";
        }
        
        return sb.toString();
    }
}