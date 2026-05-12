class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int reqNum = target - nums[i];
            Integer j = indexMap.get(reqNum);
            if (j != null && j != i) {
                if (i>j)
                    return new int[]{j, i};
                else
                    return new int[]{i, j};
            }
            indexMap.put(nums[i], i);
        }
        
        return new int[0];
    }
}
