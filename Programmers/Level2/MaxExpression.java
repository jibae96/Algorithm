import java.util.*;

public class MaxExpression {
    // +:0     -:1     *:2
    // 연산자 3가지
    HashMap<Character, Integer> hm;
    // 수식에서의 연산자들
    ArrayList<Character> expressionOpers;

    public long solution(String expression){
        long answer = 0;
        hm = new HashMap<>();
        expressionOpers = new ArrayList<>();
        hm.put('+',0);
        hm.put('-',1);
        hm.put('*',2);

        // 모든 연산자 우선순위 개수 (6가지)
        int [][] operPriority = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,1,0},{2,0,1}};

        // 수식에서 연산자를 arraylist에 넣고 공백으로 바꾸기
        char[] temp = expression.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<temp.length; i++){
            if(temp[i]=='+'){
                expressionOpers.add('+');
                temp[i]=' ';
            }else if(temp[i]=='-'){
                expressionOpers.add('-');
                temp[i]=' ';
            }else if(temp[i]=='*'){
                expressionOpers.add('*');
                temp[i]=' ';
            }
            sb.append(temp[i]);
        }
        String[] nums = sb.toString().split(" ");
        Long[] numbers = new Long [nums.length];
        for(int i=0; i<numbers.length; i++){
            numbers[i]=Long.parseLong(nums[i]);
        }
        // 계산하면서 가장 큰 절댓값 저장
        for(int i=0; i<operPriority.length; i++){
            long result = Math.abs(calc(operPriority[i],numbers));
            System.out.println(result+"!");
            answer = Math.max(answer,result);
        }
        System.out.println(answer);
       return answer;
    }
    public long calc(int[] operPriority, Long[] numbers){

        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        for(int i=0; i<numbers.length; i++)
            nums.add(numbers[i]);
        for(int i=0; i<expressionOpers.size(); i++)
            ops.add(expressionOpers.get(i));

        for(int i=0; i<3; i++){
            for(int j=0; j<ops.size(); j++){
                if(operPriority[hm.get(ops.get(j))]==i){
                    long a = nums.remove(j);
                    long b = nums.remove(j);
                    long total = doOpers(a,b,ops.get(j));
                    nums.add(j,total);
                    ops.remove(j);
                    j--;
                }
            }
        }
        return nums.remove(0);
    }
    public long doOpers(long a, long b, char op){
        switch(op){
            case '+':
                return a+b;
            case '-' :
                return a-b;
            case '*' :
                return a*b;
        }
        return 0;
    }
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        MaxExpression me = new MaxExpression();
        me.solution(expression);
    }
}
