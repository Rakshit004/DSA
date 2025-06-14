class Solution {
    private void leftMax(int[] height, int[] prefix) {
        prefix[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
    }

    private void rightMax(int[] height, int[] sufix) {
        sufix[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            sufix[i] = Math.max(sufix[i + 1], height[i]);
        }
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] prefix = new int[n];
        int[] sufix = new int[n];
        int total = 0;

        leftMax(height, prefix);
        rightMax(height, sufix);

        for (int i = 0; i < n; i++) {
            int waterAtIndex = Math.min(prefix[i], sufix[i]) - height[i];
            if (waterAtIndex > 0) {
                total += waterAtIndex;
            }
        }

        return total;
    }

}