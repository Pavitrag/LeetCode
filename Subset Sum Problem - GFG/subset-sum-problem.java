//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        Arrays.sort(arr);
        
        int max = Arrays.stream(arr).sum();
        int min = Arrays.stream(arr).min().orElse(0);
        
        assert sum >= min && sum <= max;
        
        boolean[][] dp = new boolean[N][Math.max(sum, max) + 1];
        
        for(int i = 0; i < N; i++){
            dp[i][0] = true;
            dp[i][arr[i]] = true;
        }
        for(int i = 0; i < N; i++){
            for(int w = 0; w<= sum; w++){
                if(w - arr[i] >= 0 && i-1 >= 0){
                    dp[i][w] = dp[i-1][w-arr[i]]|| dp[i-1][w];
                    if(sum == w && dp[i][w]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}