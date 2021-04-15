import java.io.*;
import java.util.*;

public class ParenthesisValue {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        Stack<String> stack = new Stack<>();
        int answer = 0;

        for(int i=0; i<sentence.length(); i++){
            String current = sentence.substring(i,i+1);
            switch (current){
                case "(" :
                    stack.push(current);
                    break;
                case "[" :
                    stack.push(current);
                    break;
                case ")" :
                    int count1 = 0;
                    while(!stack.isEmpty()){
                        String temp = stack.peek();
                        if(temp.equals("(")){
                            //System.out.println("come1");
                            if(count1==0){
                                stack.pop();
                                stack.push("2");
                                break;
                            }else{
                                stack.pop();
                                stack.push(String.valueOf(count1*2));
                                break;
                            }
                        }else{
                            try{
                                count1 += Integer.parseInt(temp);
                                stack.pop();
                            }catch (Exception e){
                                break;
                            }
                        }
                    }

                    break;
                case "]" :
                    int count2 = 0;
                    while(!stack.isEmpty()){
                        String temp = stack.peek();
                        
                        if(temp.equals("[")){
                            if(count2==0){
                                stack.pop();
                                stack.push("3");
                                break;
                            }else{
                                stack.pop();
                                stack.push(String.valueOf(count2*3));
                                break;
                            }
                        }else{
                            try{
                                count2 += Integer.parseInt(temp);
                                stack.pop();
                            }catch (Exception e){
                                break;
                            }
                        }
                    }
                    break;
            }
            //System.out.println("@"+stack);
        }
        for(String s : stack){
            try{
                answer += Integer.parseInt(s);
            }catch (Exception e){
                System.out.println("0");
                return;
            }
        }
        System.out.println(answer);
    }
}
