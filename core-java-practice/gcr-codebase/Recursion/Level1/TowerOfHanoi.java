package recursion.level2;

/**
 * Tower of Hanoi
 * 
 * Description:
 * Solve the Tower of Hanoi problem: move N disks from source rod to destination rod.
 * Rules:
 * - Only one disk can be moved at a time
 * - A larger disk cannot be placed on a smaller disk
 * - All disks must be moved from source to destination using auxiliary rod
 * 
 * Input: N = 3, Source = A, Destination = C, Auxiliary = B
 * Output: Sequence of moves (e.g., Move disk 1 from A to C, etc.)
 * 
 * Approach:
 * - Base case: if n == 1, move disk from source to destination
 * - Recursive case (for n disks):
 *   1. Move n-1 disks from source to auxiliary (using destination as temporary)
 *   2. Move largest disk from source to destination
 *   3. Move n-1 disks from auxiliary to destination (using source as temporary)
 * 
 * Time Complexity: O(2^N) - 2^N - 1 moves required
 * Space Complexity: O(N) - due to recursion stack
 */
public class TowerOfHanoi {
    
    public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Step 1: Move n-1 disks from source to auxiliary using destination
        towerOfHanoi(n - 1, source, auxiliary, destination);
        
        // Step 2: Move largest disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Step 3: Move n-1 disks from auxiliary to destination using source
        towerOfHanoi(n - 1, auxiliary, destination, source);
    }
    
    public static void main(String[] args) {
        System.out.println("Tower of Hanoi");
        
        System.out.println("\nSolving Tower of Hanoi with 3 disks:");
        System.out.println("Move disks from Rod A to Rod C using Rod B:");
        towerOfHanoi(3, 'A', 'C', 'B');
        
        System.out.println("\n\nSolving Tower of Hanoi with 2 disks:");
        System.out.println("Move disks from Rod X to Rod Z using Rod Y:");
        towerOfHanoi(2, 'X', 'Z', 'Y');
    }
}
