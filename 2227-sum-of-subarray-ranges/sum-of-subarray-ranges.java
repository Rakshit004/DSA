class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        Stack<Integer> max = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!max.isEmpty() && nums[max.peek()] <= nums[i]) {
                max.pop();
            }
            leftmax[i] = max.isEmpty() ? i + 1 : i - max.peek();
            max.push(i);
        }
        max.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!max.isEmpty() && nums[max.peek()] < nums[i]) {
                max.pop();
            }
            rightmax[i] = max.isEmpty() ? n - i : max.peek() - i;
            max.push(i);
        }

        for (int i = 0; i < n; i++) {
            long minimum = (long) nums[i] * (long) left[i] * right[i];
            long maximum = (long) nums[i] * (long) leftmax[i] * rightmax[i];
            sum += (maximum - minimum);
        }

        return sum;
    }
}