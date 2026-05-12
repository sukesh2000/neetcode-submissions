class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> numExists = new HashMap<>();

        for (int i = 0; i < n; i++) {
            numExists.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int remainingSum = target - nums[i];
            Integer j = numExists.get(remainingSum);
            if (j != null && !j.equals(i)) {
                return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }
}
