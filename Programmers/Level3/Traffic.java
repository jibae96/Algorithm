public class Traffic {
    public void getTimes(String[] lines, int [] start, int [] finish){
        int index = 0;

        for(String line : lines){
            String [] temp = line.split(" ");
            String [] time = temp[1].split(":");
            int timeToMil = 0;
            timeToMil += Integer.parseInt(time[0])*60*60*1000;
            timeToMil += Integer.parseInt(time[1])*60*1000;
            timeToMil += (int)(Double.parseDouble(time[2])*1000);
            finish[index] = timeToMil;

            int process = (int) (Double.parseDouble(temp[2].substring(0,temp[2].length()-1))*1000);
            start[index] = timeToMil-process+1;

            //System.out.println(start[index]+" ~ "+finish[index]);
            index++;
        }
    }
    public int solution(String[] lines) {
        int answer = 0;
        int [] startTime = new int[lines.length];
        int [] finishTime = new int[lines.length];
        int [] count = new int[lines.length];

        getTimes(lines, startTime, finishTime);

        for(int i=0; i<lines.length; i++){
            int area = finishTime[i]+1000;
            for(int j=i; j<lines.length; j++){
                int start = startTime[j];
                if(start < area){
                    count[i]++;
                }
            }
        }

        for(int i=0; i<count.length; i++){
            if(answer < count[i]) answer = count[i];
            //System.out.print(count[i]+" ");
        }

        return answer;
    }

    public static void main(String[] args) {
        Traffic s = new Traffic();
        String[] lines ={"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(s.solution(lines));
    }

}
