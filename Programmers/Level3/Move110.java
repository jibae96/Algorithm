import java.util.*;

class Move110 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb;
        
        for(int i=0; i<s.length; i++){
            String str = s[i];
            Stack<Character> stack = new Stack<>();
            int count = 0;
            
            for(int j=0; j<str.length(); j++){
                char z = str.charAt(j);
                
                if(stack.size()>=2){
                    char y = stack.pop();
                    char x = stack.pop();
                    
                    if(x=='1'&&y=='1'&&z=='0'){
                        count++;
                    }else{
                        stack.push(x);
                        stack.push(y);
                        stack.push(z);
                    }
                }else{
                    stack.push(z);
                }
            }
            
            int index = stack.size();
            boolean flag = false;
            sb = new StringBuilder();
            
            while(!stack.isEmpty()){
                if(!flag && stack.peek()=='1'){
                    index--;
                }
                
                if(!flag && stack.peek()=='0'){
                    flag = true;
                }
                
                sb.insert(0,stack.pop());
            }
            
            if(count>0){
                while(count>0){
                    sb.insert(index,"110");
                    index += 3;
                    count--;
                }
                answer[i] = sb.toString();
            }else{
                answer[i] = s[i];
            }
            
        }
        return answer;
    }
}
