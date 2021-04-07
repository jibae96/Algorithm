public class Fibo {
    public static int answer=0;
    public int solution(int n) {
        // F(0)=0 F(1)=1 F(2)=1 F(3)=2 F(4)=3 F(5)=5 ...
        int answer = 0;
        int result;
        int a=0;
        int b=1;

        if(n==0) return 0;
        else if(n==1) return 1;
        else{
            for(int i=1; i<n; i++){
                result = (a+b)%1234567;
                a = b;
                b = result;
                answer = b;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Fibo fibonacci = new Fibo();
        fibonacci.solution(3);
        fibonacci.solution(5);
    }
}
