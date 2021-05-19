import java.util.*;

public class PairRemove {
    public int solution(String s){
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(temp);
            }else{
                char top = stack.peek();
                if(temp==top) stack.pop();
                else stack.push(temp);
            }

        }

        if(stack.isEmpty()) answer = 1;
        else answer = 0;

        return answer;
    }
}
