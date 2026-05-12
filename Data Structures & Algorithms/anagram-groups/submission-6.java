class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s: strs) {
            int[] frequency = new int[26];
            for (char c: s.toCharArray()) {
                frequency[c-'a']++;
            }

            String key = Arrays.stream(frequency)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(","));
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
