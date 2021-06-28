class Song {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String temp;
        int max = 0;

        m = m.replaceAll("C#","H");
        m = m.replaceAll("D#","I");
        m = m.replaceAll("F#","J");
        m = m.replaceAll("G#","K");
        m = m.replaceAll("A#","L");

        for(String mInfo : musicinfos){
            String [] info = mInfo.split(",");

            int hour = Integer.parseInt(info[1].substring(0,2))-Integer.parseInt(info[0].substring(0,2));
            int min = Integer.parseInt(info[1].substring(3))-Integer.parseInt(info[0].substring(3));

            int time = hour*60 + min;
            temp = "";

            info[3] = info[3].replaceAll("C#","H");
            info[3] = info[3].replaceAll("D#","I");
            info[3] = info[3].replaceAll("F#","J");
            info[3] = info[3].replaceAll("G#","K");
            info[3] = info[3].replaceAll("A#","L");


            for(int i=0; i<Math.floor(time/info[3].length()); i++){
                temp += info[3];
            }

            temp += info[3].substring(0,time%info[3].length());

            //System.out.println(m+"!");
            //System.out.println(temp);

            
            // 곡이 2개 이상이라면 가장 긴 곡으로 선정해야하기 때문
            if(temp.contains(m)){
                if(time>max){
                    answer = info[2];
                    max = time;
                }
            }

        }
        if(answer.equals("")) answer = "(None)";

        return answer;
    }

}
