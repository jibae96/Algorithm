class IDrecommand {
    public String solution(String new_id) {

        StringBuilder sb = new StringBuilder();

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        for(int i=0; i<new_id.length(); i++){
            char temp = new_id.charAt(i);
            if(temp>='a' && temp<='z') {
                sb.append(temp);
                continue;
            }
            if(temp=='-' || temp=='_' || temp=='.') {
                sb.append(temp);
                continue;
            }
            if(temp>='0' && temp<='9'){
                sb.append(temp);
                continue;
            }

        }
        //System.out.println(sb);
        new_id = sb.toString();

        // 3단계
        char prev = new_id.charAt(0);
        sb = new StringBuilder();
        sb.append(prev);

        for(int i=1; i<new_id.length(); i++){
            char temp = new_id.charAt(i);
            if(temp=='.' && prev=='.') continue;
            sb.append(temp);
            prev = temp;
        }

        //System.out.println(sb);
        new_id = sb.toString();

        // 4단계
        if(new_id.charAt(0)=='.'){
            new_id = new_id.substring(1);
        }
        if(new_id.length()-1>0 && new_id.charAt(new_id.length()-1)=='.'){
            new_id = new_id.substring(0,new_id.length()-1);
        }

        //System.out.println(new_id+"!");

        // 5단계
        if(new_id.equals("")) new_id+="a";

        // 6단계
        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            if(new_id.charAt(14)=='.') new_id = new_id.substring(0,14);
        }


        // 7단계
        if(new_id.length()<=2){
            while(new_id.length()<3){
                new_id+=new_id.charAt(new_id.length()-1);
            }
        }

        return new_id;
    }

    public static void main(String[] args) {
        String id = "=.=";
        IDrecommand recommand = new IDrecommand();
        recommand.solution(id);
    }
}
