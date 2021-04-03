public class Number124 {
    public String solution(int n) {
        String answer = "";
        String[] num = {"4","1","2"};
        // 3으로 나누었을 때
        // 나머지가 1일때 마지막 수 1
        // 나머지가 2일때 마지막 수 2
        // 나머지가 0일때 마지막 수 4
        while(n!=0){
            answer = num[n%3]+answer;
            n=(n-1)/3;
        }
        return answer;
    }

    public static void main(String[] args) {
        Number124 num = new Number124();
        num.solution(11);
    }
}
