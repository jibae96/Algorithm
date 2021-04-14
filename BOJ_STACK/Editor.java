import java.util.*;
import java.io.*;

public class Editor{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String word = st.nextToken();
        StringBuilder sb = new StringBuilder();
        StringBuilder tempsb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        Stack<Character> temp = new Stack<>();

        for(int i=0; i<word.length(); i++){
            stack.push(word.charAt(i));
        }
        st = new StringTokenizer(br.readLine());
        int test = Integer.parseInt(st.nextToken());
        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch(order){
                case "L" :
                    if(!stack.isEmpty()) {
                        temp.push(stack.pop());
                    }
                    break;
                case "P" :
                    stack.push(st.nextToken().charAt(0));
                    break;
                case "D" :
                    if(!temp.isEmpty()){
                        stack.push(temp.pop());
                    }
                    break;
                case "B" :
                    if(!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        while(!temp.isEmpty()){
            tempsb.append(temp.pop());
        }

        System.out.println(sb.reverse().toString()+tempsb.toString());
    }
}
