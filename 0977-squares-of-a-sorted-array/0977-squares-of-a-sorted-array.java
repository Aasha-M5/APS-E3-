import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0, right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                result[pos] = leftSq;
                left++;
            } else {
                result[pos] = rightSq;
                right--;
            }
            pos--;
        }

        return result;
    }

    // For testing
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(obj.sortedSquares(nums)));
    }
}
