class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> numExists = new HashMap<>();

        for (int i = 0; i < n; i++) {
            numExists.putIfAbsent(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int remainingSum = target - nums[i];
            Integer j = numExists.get(remainingSum);
            if (j != null && !j.equals(i)) {
                int[] ans;
                if (i>j)
                    ans = new int[]{j, i};
                else
                    ans = new int[]{i, j};
                return ans;
            }
        }

        return new int[]{-1, -1};
    }
}
