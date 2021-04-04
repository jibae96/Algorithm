public class JoyStick {
    public int solution(String name) {
        int count = 0;
        int len = name.length();
        int minMove = name.length()-1;

        for(int i=0; i<len; i++){
            if(name.charAt(i)<='M'){
                count += name.charAt(i)-'A';
            }else {
                count += 'Z'-name.charAt(i)+1;
            }
            int next = i+1;
            while(next<len && name.charAt(next)=='A'){
                next++;
            }
            minMove = Math.min(minMove, i+len-next+i);
        }
        count += minMove;
        return count;
    }

    public static void main(String[] args) {
        JoyStick joyStick = new JoyStick();
        String name = "JAN";
        joyStick.solution(name);
    }
}
