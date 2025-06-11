class Solution {
    private int findNextGreater(int[] nums2, int startIdx, int target) {
        for (int i = startIdx + 1; i < nums2.length; i++) {
            if (nums2[i] > target) {
                return nums2[i];
            }
        }
        return -1;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Initialize result array
        int[] ans = new int[nums1.length];
        
        // For each element in nums1
        for (int i = 0; i < nums1.length; i++) {
            // Find the matching element in nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    // Find next greater element
                    ans[i] = findNextGreater(nums2, j, nums1[i]);
                    break;
                }
            }
        }
        
        return ans;
    }
}