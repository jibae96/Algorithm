import java.util.*;

class EditTable {
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int table = n;
        
        for(String str : cmd){
            char ch = str.charAt(0);
            if(ch=='U'){
                k -= Integer.parseInt(str.substring(2));
            }else if(ch=='D'){
                k += Integer.parseInt(str.substring(2));
            }else if(ch=='C'){
                stack.push(k);
                table--;
                if(k==table) k--;
            }else{
                int pop = stack.pop();
                if(k>=pop) k++;
                table++;
            }
        }
        
        for(int i=0; i<table; i++){
            answer.append("O");
        }
        
        while(!stack.isEmpty()){
            answer.insert(stack.pop(), "X");
        }
        
        return answer.toString();
    }
}
