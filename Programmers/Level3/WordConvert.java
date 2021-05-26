import java.util.*;

class WordConvert {
    boolean [] visited;
    int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        
        dfs(begin,target,words,0);
        
        return answer;
    }
    
    public void dfs(String current, String target, String[] words, int count){
        int index = 0;
        //System.out.println(current+"!");
        if(current.equals(target)){
            //System.out.println(current+"success");
            answer = count;
            return;
        }
        for(int i=0; i<words.length; i++){
            if(visited[i]==false){
                for(int j=0; j<current.length(); j++){
                    if(current.charAt(j)==words[i].charAt(j))
                        index++;
                }
                if(index==current.length()-1){
                    visited[i]=true;
                    dfs(words[i],target,words,count+1);
                    visited[i]=false;
                }
                index=0;
            }
        }
    }
}
