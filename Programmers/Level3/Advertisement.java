import java.util.*;

class Advertisement {
    public String solution(String play_time, String adv_time, String[] logs) {

        int playTime = toSec(play_time);
        int advTime = toSec(adv_time);

        int[] count = new int[playTime+1];

        //System.out.println(playTime +"_"+advTime);

        for(String log : logs){
            String[] logTime = log.split("-");
            int start = toSec(logTime[0]);
            int end = toSec(logTime[1]);

            for(int i=start; i<end; i++)
                count[i]++;
        }

        int advStart = 0;
        int advEnd = advTime;
        long sum = 0;

        for(int i=advStart; i<advEnd; i++){
            sum += count[i];
        }

        long max = sum;
        int maxStartTime = 0;

        while(advEnd <= playTime){
            sum -= count[advStart];
            sum += count[advEnd];
            if(sum>max){
                max = sum;
                maxStartTime = advStart+1;
            }
            advStart++;
            advEnd++;
        }

        return secToString(maxStartTime);
    }

    public int toSec(String time){
        String[] temp = time.split(":");
        int total = 0;
        total += Integer.parseInt(temp[0])*60*60;
        total += Integer.parseInt(temp[1])*60;
        total += Integer.parseInt(temp[2]);

        return total;
    }

    public String secToString(int time){
        int hour = time/3600;
        time %= 3600;
        int min = time/60;
        time %=60;

        return String.format("%02d:%02d:%02d", hour, min, time);
    }
}
