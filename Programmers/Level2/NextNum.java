public class NextNum {
    public int solution(int n) {
        int count1 = 0; // 이진수로 바꿨을 때 1의 개수
        int number = n;
        while(number!=0){
            if(number%2==1) count1++;
            number /= 2;
        }
        for(int i=n+1; i<1000000;i++){
            int temp = i;
            int count2 = 0;
            while(temp!=0){
                if(temp%2==1) count2++;
                temp /= 2;
            }
            if(count1==count2){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        NextNum nextNum = new NextNum();
        nextNum.solution(78);
    }
}
