import java.util.*;

class DiskController {
    class MyJob{
        int requestTime;
        int spendTime;
        public MyJob(int requestTime, int spendTime){
            this.requestTime = requestTime;
            this.spendTime = spendTime;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;

        Queue<MyJob> waiting = new LinkedList<>();
        PriorityQueue<MyJob> queue = new PriorityQueue<>(new Comparator<MyJob>(){
            @Override
            public int compare(MyJob job1, MyJob job2){
                return job1.spendTime-job2.spendTime;
            }
        });

        Arrays.sort(jobs, (o1,o2)->{
            return o1[0]-o2[0];
        });

        for(int [] job : jobs){
            waiting.add(new MyJob(job[0],job[1]));
        }

        int count = 0;
        int current = waiting.peek().requestTime;

        while(count<jobs.length){
            while(!waiting.isEmpty() && waiting.peek().requestTime <= current){
                queue.add(waiting.poll());
            }
            if(!queue.isEmpty()){
                MyJob myJob = queue.poll();
                current += myJob.spendTime;
                answer += (current - myJob.requestTime);
                count++;
            }else{
                current++;
            }
        }
        return answer/count;
    }
}
