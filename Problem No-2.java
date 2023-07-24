2) Given an array of integer nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If the target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

soln : public class FindTargetRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = findLeftBound(nums, target);
        if (left == -1) {
            return result;
        }

        int right = findRightBound(nums, target);
        result[0] = left;
        result[1] = right;
        return result;
    }

    private int findLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    private int findRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        FindTargetRange finder = new FindTargetRange();
        int[] result = finder.searchRange(nums, target);

        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");
    }
}

