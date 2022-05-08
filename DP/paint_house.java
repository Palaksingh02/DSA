import java.io.*;
import java.util.*;

public class paint_house {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] col = new int[n][3];
        for(int i = 0 ; i<n ; i++ ){
            for(int j = 0 ;  j <3 ; j++){
                col[i][j] = sc.nextInt();
            }
        }
        
        int[][] dp = new int[n][3];
        for(int i = 0 ; i<3 ; i++){
            dp[0][i] = col[0][i];
        }
        
        for(int i = 1 ; i<n ; i++){
            for(int j = 0 ; j<3 ; j++){
                if(j==0){
                    dp[i][j] = col[i][j]+ Math.min(dp[i-1][1],dp[i-1][2]);
                }
                else if(j==1){
                    dp[i][j] = col[i][j]+ Math.min(dp[i-1][0],dp[i-1][2]);
                }
                else{
                    dp[i][j] = col[i][j]+ Math.min(dp[i-1][0],dp[i-1][1]);
                }
            }
        }
        
        System.out.println(Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2])));
    }
}