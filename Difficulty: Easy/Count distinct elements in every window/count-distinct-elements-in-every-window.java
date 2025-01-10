//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int i = 0, j = 0;

        while (i < arr.length) {
            // Add current element to the frequency map
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);

            // If the window size is equal to k
            if (i - j + 1 == k) {
                res.add(freqMap.size()); // Add distinct count to the result
                
                // Slide the window
                freqMap.put(arr[j], freqMap.get(arr[j]) - 1);
                if (freqMap.get(arr[j]) == 0) {
                    freqMap.remove(arr[j]); // Remove element if frequency becomes 0
                }
                j++;
            }
            i++;
        }

        return res;
    }
}
