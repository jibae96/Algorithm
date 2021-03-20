import java.util.*;

public class Kevin1389 {
    static int[][] friendship;
    static int index;
    public void solution(int n){
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(friendship[i][j]>friendship[i][k]+friendship[k][j])
                        friendship[i][j]=friendship[i][k]+friendship[k][j];
                }
            }
        }
        int min=Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            int temp=0;
            for(int j=0; j<n; j++){
                temp += friendship[i][j];
            }
            if(min>temp){
                min=temp;
                index=i;
            }
        }
        System.out.println(index+1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int friends = sc.nextInt();
        int relations = sc.nextInt();
        friendship = new int[friends][friends];
        sc.nextLine();
        for(int i=0; i<friends; i++){
            for(int j=0; j<friends; j++){
                if(i!=j) friendship[i][j]=999999;
            }
        }
        for(int i=0; i<relations; i++){
           int a = sc.nextInt()-1;
           int b = sc.nextInt()-1;
           friendship[a][b]=friendship[b][a]=1;
        }
        Kevin1389 kevin = new Kevin1389();
        kevin.solution(friends);
    }
}
