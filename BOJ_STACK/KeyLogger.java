import java.util.*;
import java.io.*;

public class KeyLogger{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Character> stack = new Stack<>();
        Stack<Character> next = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(st.nextToken());

        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine());
            String password = st.nextToken();
            for(int j=0; j<password.length(); j++){
                char ch = password.charAt(j);
                switch(ch){
                    case '-': // 백 스페이스
                        if(!stack.isEmpty()){
                            stack.pop();
                        }
                        break;
                    case '<' :
                        if(!stack.isEmpty()){
                            next.push(stack.pop());
                        }
                        break;
                    case '>' :
                        if(!next.isEmpty()){
                            stack.push(next.pop());
                        }
                        break;
                    default :
                        stack.push(ch);
                }
            }
            while(!stack.isEmpty()){
                next.push(stack.pop());
            }
            while(!next.isEmpty()){
                sb.append(next.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
