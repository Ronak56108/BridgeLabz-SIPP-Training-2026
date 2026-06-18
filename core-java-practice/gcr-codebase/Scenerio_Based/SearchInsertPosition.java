import java.util.Scanner;

/**
 * LeetCode Problem 5: Search Insert Position - Problem 35
 * 
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * 
 * Example 1: nums = [1,3,5,6], target = 5 → Output: 2
 * Example 2: nums = [1,3,5,6], target = 2 → Output: 1
 * Example 3: nums = [1,3,5,6], target = 7 → Output: 4
 */
public class SearchInsertPosition {
    
    /**
     * Find search insert position using binary search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left; // Position where target should be inserted
    }
    
    /**
     * Linear search approach (for comparison)
     */
    public static int searchInsertLinear(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
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
                
                // Verify array is sorted
                if (i > 0 && nums[i] < nums[i - 1]) {
                    throw new IllegalArgumentException("Array must be sorted in non-decreasing order");
                }
            }
            
            System.out.print("Enter target value: ");
            int target = scanner.nextInt();
            
            int position = searchInsert(nums, target);
            
            System.out.println("\nTarget value: " + target);
            System.out.println("Insert position: " + position);
            
            // Show array visualization
            System.out.print("Array: [");
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]);
                if (i < nums.length - 1) System.out.print(", ");
            }
            System.out.println("]");
            
            if (position < nums.length && nums[position] == target) {
                System.out.println("Target found at index " + position);
            } else {
                System.out.println("Target not found. Insert at index " + position);
                System.out.println("Array would become: [");
                for (int i = 0; i < nums.length; i++) {
                    if (i == position) System.out.print(target + ", ");
                    System.out.print(nums[i]);
                    if (i < nums.length - 1) System.out.print(", ");
                }
                if (position == nums.length) System.out.print(", " + target);
                System.out.println("]");
            }
            
            // Test cases
            System.out.println("\n--- Test Cases ---");
            
            int[] test1 = {1, 3, 5, 6};
            System.out.println("Test 1: nums = [1, 3, 5, 6], target = 5");
            System.out.println("Output: " + searchInsert(test1, 5));
            
            System.out.println("\nTest 2: nums = [1, 3, 5, 6], target = 2");
            System.out.println("Output: " + searchInsert(test1, 2));
            
            System.out.println("\nTest 3: nums = [1, 3, 5, 6], target = 7");
            System.out.println("Output: " + searchInsert(test1, 7));
            
            int[] test4 = {1};
            System.out.println("\nTest 4: nums = [1], target = 1");
            System.out.println("Output: " + searchInsert(test4, 1));
            
            System.out.println("\nTest 5: nums = [1], target = 3");
            System.out.println("Output: " + searchInsert(test4, 3));
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}
