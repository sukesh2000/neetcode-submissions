class Solution {
    public boolean isAnagram(String s, String t) {
               if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> sFrequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sFrequencyMap.put(s.charAt(i), sFrequencyMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> tFrequencyMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tFrequencyMap.put(t.charAt(i), tFrequencyMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = tFrequencyMap.entrySet();
        for (Map.Entry<Character, Integer> entry : sFrequencyMap.entrySet()) {
            if (!Objects.equals(tFrequencyMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }

        return true; 
    }
}
