import java.util.*;

class Solution {
    static char[] dic = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        
        dfs("");
        
        return list.indexOf(word);
    }
    public static void dfs(String result){
        if(result.length() > 5) return;
        list.add(result);
        
        for(int i = 0; i < 5; i++){
            dfs(result + dic[i]);
        }
    }
}