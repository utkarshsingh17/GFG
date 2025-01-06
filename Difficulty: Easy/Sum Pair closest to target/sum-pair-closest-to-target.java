//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int closestsum=Integer.MAX_VALUE;
        List<Integer> output=new ArrayList<>();
        int start=0;
        int end=arr.length-1;
        int mindiff=Integer.MAX_VALUE;
        while(start<end){
          int sum=arr[start]+arr[end];
          int diff=Math.abs(target-sum);
          if(diff<mindiff){
              output.clear();
              output.add(arr[start]);
              output.add(arr[end]);
              mindiff=Math.min(mindiff,diff);
          }
          if(diff==mindiff&&Math.abs(arr[start]-arr[end])>Math.abs(output.get(0)-output.get(1))){
              output.clear();
              output.add(arr[start]);
              output.add(arr[end]);
          }
          
         if(sum==target)break;
         else if(sum<target) start++;
         else end--;
          
        }
        return output;
    }
}