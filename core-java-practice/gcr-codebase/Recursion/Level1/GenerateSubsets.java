package recursion.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate All Subsets (Power Set)
 * 
 * Description:
 * Write a recursive function to generate all subsets of an array.
 * 
 * Input: [1, 2, 3]
 * Output: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
 * 
 * Approach:
 * - Backtracking: for each element, include it or exclude it
 * - For array of size n, there are 2^n subsets
 * - Recursive case: include element, recurse; exclude element, recurse
 * 
 * Time Complexity: O(N * 2^N) - N for each subset, 2^N subsets
 * Space Complexity: O(2^N) - for storing all subsets
 */
public class GenerateSubsets {
    
    public static List<List<Integer>> generateSubsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(arr, 0, new ArrayList<>(), result);
        return result;
    }
    
    private static void backtrackSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case: if we've processed all elements, add current subset
        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Include current element
        current.add(arr[index]);
        backtrackSubsets(arr, index + 1, current, result);
        
        // Exclude current element (backtrack)
        current.remove(current.size() - 1);
        backtrackSubsets(arr, index + 1, current, result);
    }
    
    public static void main(String[] args) {
        System.out.println("Generate All Subsets (Power Set)");
        
        int[] arr1 = {1, 2, 3};
        List<List<Integer>> subsets1 = generateSubsets(arr1);
        System.out.println("Subsets of [1, 2, 3]:");
        System.out.println(subsets1);
        System.out.println("Total subsets: " + subsets1.size());
        
        System.out.println();
        
        int[] arr2 = {1, 2};
        List<List<Integer>> subsets2 = generateSubsets(arr2);
        System.out.println("Subsets of [1, 2]:");
        System.out.println(subsets2);
        System.out.println("Total subsets: " + subsets2.size());
    }
}
