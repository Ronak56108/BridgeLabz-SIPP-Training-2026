package recursion.level2;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate All Permutations
 * 
 * Description:
 * Write a recursive function to generate all permutations of a string.
 * 
 * Input: "ABC"
 * Output: [ABC, ACB, BAC, BCA, CAB, CBA]
 * 
 * Approach:
 * - Backtracking: fix each character at position and permute the rest
 * - For a string of length n, there are n! permutations
 * - Use character swapping to generate permutations
 * - Restore state after recursion (backtrack)
 * 
 * Time Complexity: O(N! * N) - N! permutations, each taking O(N) to process
 * Space Complexity: O(N!) - for storing all permutations
 */
public class GeneratePermutations {
    
    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        backtrackPermutations(str.toCharArray(), 0, result);
        return result;
    }
    
    private static void backtrackPermutations(char[] arr, int index, List<String> result) {
        // Base case: if we've fixed all positions, add permutation to result
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }
        
        // Recursive case: try each character at current position
        for (int i = index; i < arr.length; i++) {
            // Swap current index with i
            swap(arr, index, i);
            
            // Recurse with next position
            backtrackPermutations(arr, index + 1, result);
            
            // Backtrack: swap back
            swap(arr, index, i);
        }
    }
    
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        System.out.println("Generate All Permutations");
        
        String str1 = "ABC";
        List<String> perms1 = generatePermutations(str1);
        System.out.println("Permutations of '" + str1 + "':");
        System.out.println(perms1);
        System.out.println("Total permutations: " + perms1.size());
        
        System.out.println();
        
        String str2 = "AB";
        List<String> perms2 = generatePermutations(str2);
        System.out.println("Permutations of '" + str2 + "':");
        System.out.println(perms2);
        System.out.println("Total permutations: " + perms2.size());
        
        System.out.println();
        
        String str3 = "A";
        List<String> perms3 = generatePermutations(str3);
        System.out.println("Permutations of '" + str3 + "':");
        System.out.println(perms3);
        System.out.println("Total permutations: " + perms3.size());
    }
}
