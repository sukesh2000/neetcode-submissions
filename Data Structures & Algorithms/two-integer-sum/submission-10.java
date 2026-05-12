class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> present = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            Integer j = present.get(search);
            if (j != null && j != i) {
                return new int[]{j, i};
            }
            present.putIfAbsent(nums[i], i);
        }

        return null;
    }
}
