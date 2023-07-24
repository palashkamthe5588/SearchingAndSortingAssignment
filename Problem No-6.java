 6) You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether the version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Soln :  // Sample API provided by the system
    boolean isBadVersion(int version) {
        // Implementation of this method is not provided as it is part of the system.
        // In reality, it should be implemented by the system or provided by the product API.
        // For the sake of demonstration, we assume that it returns true for bad versions and false for good versions.
        // The implementation is not necessary for understanding the algorithm.
        return true; // Replace this with the actual implementation.
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                // We have found a bad version, but it might not be the first one.
                // Continue searching on the left side to find the first bad version.
                right = mid;
            } else {
                // The current version is good, so we know the first bad version is on the right side.
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int n = 5;
        FirstBadVersion finder = new FirstBadVersion();
        int firstBad = finder.firstBadVersion(n);
        System.out.println("Output: " + firstBad); // Output: 4
    }
}
