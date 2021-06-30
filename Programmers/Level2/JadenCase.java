class JadenCase {
    public String solution(String s) {
        String answer = "";
        answer += s.substring(0,1).toUpperCase();

        for(int i=1; i<s.length(); i++){
            String current = s.charAt(i)+"";
            if (current.equals(" ")) answer += " ";
            else if(s.charAt(i-1)==' ') answer += current.toUpperCase();
            else answer += current.toLowerCase();
        }

        return answer;
    }
}
