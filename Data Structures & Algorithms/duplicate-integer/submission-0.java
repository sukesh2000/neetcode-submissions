class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : frequency.keySet()) {
            if (frequency.get(key) > 1) {
                return true;
            }
        }
        return false;
    }
}