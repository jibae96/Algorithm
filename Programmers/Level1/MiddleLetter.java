class MiddleLetter {
    public String solution(String s) {
        String answer = "";
        //System.out.println(s.length()+"~");
        if(s.length()%2==1){
            answer = s.substring(s.length()/2, s.length()/2+1);
        }else{
            answer = s.substring(s.length()/2-1, s.length()/2+1);
        }
        return answer;
    }
}
