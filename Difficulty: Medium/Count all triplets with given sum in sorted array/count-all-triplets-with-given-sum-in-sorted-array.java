//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        int count=0;
        
       for(int i=0;i<arr.length-2;i++){
           int j=i+1;
           int k=arr.length-1;
           while(j<k){
               int cur=arr[i]+arr[j]+arr[k];
               if(cur<target){
                  
                   j++;
               }
               else if(cur>target){
                   k--;
               }else{
                   count++;
                   int temp=j+1;
                   while(temp<k&&arr[temp]==arr[temp-1]){
                       count++;
                       temp++;
                   }
                   k--;
               }
           }
           
       }
       return count;
    }
}