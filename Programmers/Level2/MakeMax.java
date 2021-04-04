public class MakeMax {
    public String solution(String number, int k) {
        char max;
        int index=0;
        StringBuilder sb = new StringBuilder();
        if(number.charAt(0)=='0') return "0";
        for(int i=0; i<number.length()-k; i++){
            max = '0';
            for(int j=index; j<=i+k; j++){
                if(max<number.charAt(j)){
                    max = number.charAt(j);
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MakeMax makeMax = new MakeMax();
        String num = "4177252841";
        int k = 4;
        makeMax.solution(num,k);
    }
}
