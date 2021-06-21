class Compression {
    public int solution(String s) {
        int answer = 0;
        String prev;
        int index;
        int count;
        int totalLen = s.length();
        String result;
        int lastIndex;

        // i개 단위로 잘라 압축했을 때
        for(int i=1; i<=s.length()/2; i++){
            prev = "";
            index = 0;
            count = 1;
            result = "";

            while(index<s.length()){
                //System.out.println(prev+"@");
                lastIndex = (index+i>s.length()) ? s.length() : index+i;

                if(s.substring(index,lastIndex).equals(prev)){
                    count++;
                    prev = s.substring(index,lastIndex);
                }else{
                    if(count!=1)
                        result += count;
                    result += prev;
                    prev = s.substring(index,lastIndex);
                    count = 1;
                }
                index += i;
            }
            if(count!=1)
                result += count;
            result += prev;

            totalLen = Math.min(totalLen, result.length());
            //System.out.println(result);
        }

        return totalLen;
    }
}
