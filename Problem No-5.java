5) Find the majority element in the array. A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element). 
Input: A[]={3, 3, 4, 2, 4, 4, 2, 4, 4}
Output: 4
Explanation: The frequency of 4 is 5 which is greater than half of the size of the array size. 

Soln:
    public class MajorityElement {
    public int findMajorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        // Verify if the candidate is the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        }

        // If there is no majority element, you can return -1 or any value to indicate it.
        // In this case, I'll return -1.
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        MajorityElement finder = new MajorityElement();
        int majorityElement = finder.findMajorityElement(nums);
        System.out.println("Output: " + majorityElement); // Output: 4
    }
}