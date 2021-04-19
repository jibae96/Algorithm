import java.io.*;
import java.util.*;

// 시간 초과 주의


public class Top{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int testcase = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        stack.push(first);
        indexStack.push(1);
        sb.append("0 ");

        for(int i=1; i<testcase; i++){
            int current = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(current < stack.peek()){
                    sb.append(indexStack.peek()+" ");
                    break;
                }
                stack.pop();
                indexStack.pop();
            }

            if(stack.isEmpty()){
                sb.append("0 ");
            }
            stack.push(current);
            indexStack.push(i+1);
        }
        System.out.print(sb.toString());
    }
}
