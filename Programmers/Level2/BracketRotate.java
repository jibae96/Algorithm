import java.util.*;

class BracketRotate {
    int answer;
    public int solution(String s) {
        answer = 0;

        for(int i=0; i<s.length(); i++){
            s = s.substring(1) + s.substring(0,1);
            //System.out.println(s);
            check(s);
        }
        return answer;
    }

    public void check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char current = s.charAt(i);
            if(current=='[' || current=='{' || current=='('){
                stack.push(current);
            }else{
                if(current==']'){
                    if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
                    else stack.push(current);
                }
                else if(current=='}'){
                    if(!stack.isEmpty() && stack.peek()=='{') stack.pop();
                    else stack.push(current);
                }
                else if(current==')'){
                    if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                    else stack.push(current);
                }

            }
        }

        if(stack.isEmpty()) answer++;
    }
}
