class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int c = 0;
            boolean alreadyAdded = false;

            for (int k = 0; k < result.size(); k++) {
                if (nums[i] == result.get(k)) {
                    alreadyAdded = true;
                    break;
                }
            }

            if (alreadyAdded) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    c++;
                }
            }

            if (c > n / 3) {
                result.add(nums[i]);
            }
        }

        return result;
    }
}