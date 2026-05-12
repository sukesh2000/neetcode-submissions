class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0)+1);
        }

        for (Integer num: frequency.keySet()) {
            if(frequency.get(num) > 1) {
                return true;
            }
        }

        return false;
    }
}