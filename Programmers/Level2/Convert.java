public class Convert {
    public int[] solution(String s){
            int[] answer = new int [2];
            int count = 0;
            int zero = 0;
            StringBuilder sb;
            while(!s.equals("1")){
                sb = new StringBuilder(); //
                int len = s.length();
                s = s.replaceAll("0","");
                zero += (len-s.length());
                int temp = s.length();
                System.out.println(temp);
                while(temp>0){
                    sb.append(temp%2);
                    temp /= 2;
                }
                s=sb.reverse().toString();
                count++;
            }
            answer[0]=count;
            answer[1]=zero;
            System.out.println(answer[0]+" "+answer[1]);
            return answer;
    }
    public static void main(String[] args) {
        String s = "1111111";
        Convert convert = new Convert();
        convert.solution(s);
    }
}
