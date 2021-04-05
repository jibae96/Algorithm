public class CheckBracket {
    boolean solution(String s) {
        int left=0;
        int right=0;
        char [] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++){
            if(ch[i]=='(') left++;
            else right++;
            if(left-right<0) return false;
        }
        if(left==right) return true;
        else return false;
    }

    public static void main(String[] args) {
        CheckBracket checkBracket = new CheckBracket();
        String s1="()()";
        String s2="(())()";
        String s3=")()(";
        String s4="(()(";

        System.out.println(checkBracket.solution(s1));
        System.out.println(checkBracket.solution(s2));
        System.out.println(checkBracket.solution(s3));
        System.out.println(checkBracket.solution(s4));
    }
}
