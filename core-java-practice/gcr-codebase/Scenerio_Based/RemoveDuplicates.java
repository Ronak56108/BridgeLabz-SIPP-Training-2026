import java.util.Arrays;
import java.util.Scanner;

/**
 * LeetCode Problem 2: Remove Duplicates from Sorted Array - Problem 26
 * 
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * Return the number of unique elements.
 * 
 * Example 1: Input: [1,1,2] → Output: 2, nums = [1,2,_]
 * Example 2: Input: [0,0,1,1,1,2,2,3,3,4] → Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 */
public class RemoveDuplicates {
    
    /**
     * Remove duplicates from sorted array using two-pointer approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int pointer = 1; // Pointer for unique elements position
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        
        return pointer; // Number of unique elements
    }
    
    /**
     * Display array with specified length
     */
    public static void displayArray(int[] nums, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
            if (i < length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();
            
            if (size <= 0) {
                throw new IllegalArgumentException("Array size must be positive");
            }
            
            int[] nums = new int[size];
            System.out.println("Enter sorted array elements:");
            
            for (int i = 0; i < size; i++) {
                System.out.print("Element " + (i + 1) + ": ");
                nums[i] = scanner.nextInt();
            }
            
            // Verify array is sorted
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    throw new IllegalArgumentException("Array must be sorted in non-decreasing order");
                }
            }
            
            System.out.println("\nOriginal array: " + Arrays.toString(nums));
            
            int uniqueCount = removeDuplicates(nums);
            
            System.out.println("Number of unique elements: " + uniqueCount);
            System.out.print("Modified array: ");
            displayArray(nums, uniqueCount);
            
            // Test cases
            System.out.println("\n--- Test Cases ---");
            
            int[] test1 = {1, 1, 2};
            int result1 = removeDuplicates(test1);
            System.out.println("Input: [1, 1, 2]");
            System.out.println("Output: " + result1 + ", nums = ");
            displayArray(test1, result1);
            
            int[] test2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
            int result2 = removeDuplicates(test2);
            System.out.println("\nInput: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]");
            System.out.println("Output: " + result2 + ", nums = ");
            displayArray(test2, result2);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}
