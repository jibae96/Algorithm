public class Parentheses {
    public boolean isBalanced(String str){
        int left=0;
        int right=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') left++;
            else right++;
            if(left-right<0) return false;
        }
        return true;
    }
    public String solution(String p) {
        // ()))((()
        String answer = "";
        if(p=="") return "";
        if(isBalanced(p)) return p;
        int i;
        int left=0;
        int right=0;
        String u = ""; // 더 이상 분리할 수 없는 균형잡힌 괄호 문자열
        String v = ""; // 나머지 문자열
        String temp;
        for(i=0; i<p.length(); i++){
            if(p.charAt(i)=='(') left++;
            else right++;
            if(left==right){
                break;
            }
        }
        u = p.substring(0,i+1);
        v = p.substring(i+1,p.length());
        if(isBalanced(u)){
            answer = u;
            answer += solution(v);
        }
        else {
            answer += "(";
            answer += solution(v);
            answer += ")";

            u = u.substring(1,u.length()-1);
            for(int j=0; j<u.length(); j++){
                if(u.charAt(j)=='(') answer+=")";
                else answer+="(";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Parentheses parentheses = new Parentheses();
        String s = "()))((()";
        parentheses.solution(s);
    }
}
