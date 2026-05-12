class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> numExists = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            Integer j = numExists.get(diff);
            if (j != null && !j.equals(i)) {
                return new int[]{j, i};
            }
            numExists.put(nums[i], i);
        }

        return new int[0];
    }
}
