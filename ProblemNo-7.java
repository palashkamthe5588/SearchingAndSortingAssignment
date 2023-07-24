 7) Given an array of integers, find the inversion of an array. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
N=5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: (2,1) (4,1) and (4,3) forms an inversion in an array

Soln : public class CountInversions {
    public int countInversions(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int[] temp = new int[nums.length];
        return mergeSortAndCount(nums, temp, 0, nums.length - 1);
    }

    private int mergeSortAndCount(int[] nums, int[] temp, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(nums, temp, left, mid);
            count += mergeSortAndCount(nums, temp, mid + 1, right);
            count += mergeAndCount(nums, temp, left, mid, right);
        }
        return count;
    }

    private int mergeAndCount(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += mid - i + 1; // Count the inversions
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy the merged array back to the original array
        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5};
        CountInversions counter = new CountInversions();
        int inversionCount = counter.countInversions(nums);
        System.out.println("Output: " + inversionCount); // Output: 3
    }
}

