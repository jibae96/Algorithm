import java.util.*;

class WordChain {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashSet<String> hs = new HashSet<>();
        String prev = words[0];
        int index = -1;

        hs.add(words[0]);

        for(int i=1; i<words.length; i++){
            if(words[i].charAt(0)!=prev.charAt(prev.length()-1)){
                index = i;
                break;
            }else if(hs.contains(words[i])){
                index = i;
                break;
            }else{
                hs.add(words[i]);
                prev = words[i];
            }
        }

        if(index==-1) return answer;
        answer[0] = index%n+1;
        answer[1] = index/n+1;

        return answer;
    }
}
