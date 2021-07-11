class Palindrome{
    public int solution(String s){
        int answer = 0;

        for(int i=s.length(); i>0; i--){
            for(int j=0; j+i<=s.length(); j++){
                boolean palindrome = true;
                for(int k=0; k<i/2; k++){
                    if(s.charAt(j+k)!=s.charAt(j+i-k-1)){
                        palindrome = false;
                        break;
                    }
                }
                if(palindrome) return i;
            }
            
        }
        
        return 1;
    }
}
