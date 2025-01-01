//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res=new ArrayList<>();
        ArrayList<String> input=new ArrayList<>();
        for(String s:arr)input.add(s);
        
        while(input.isEmpty()==false){
            ArrayList<String> ans=new ArrayList<>();
            int size=input.size();
            for(int i=0;i<size;i++){
                if(ans.isEmpty()==true){
                    ans.add(input.get(i));
                }
                else{
                    if(isAnagram(input.get(0),input.get(i))==true){
                        ans.add(input.get(i));
                        
                    }
                }
            }
            for(String s:ans)input.remove(s);
            //System.out.println(ans);
            res.add(ans);
        }
        return res;
        
    }
    public static boolean isAnagram(String s1,String s2){
        char arr1[]=s1.toCharArray();
        char arr2[]=s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        //System.out.println(Arrays.equals(arr1,arr2));
        return Arrays.equals(arr1,arr2);
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends