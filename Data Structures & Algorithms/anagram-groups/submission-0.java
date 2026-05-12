class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] frequency = new int[26];
        
        for (int i=0; i<s.length(); i++) {
            frequency[s.charAt(i)-'a'] += 1;
            frequency[t.charAt(i)-'a'] -= 1;
        }

        for (int i=0; i<26; i++) {
            if (frequency[i] != 0)
                return false;
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int[] processed = new int[strs.length];

        for(int i=0; i<strs.length; i++) {
            if (processed[i] == 1) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            processed[i] = 1;
            for (int j=i+1; j<strs.length; j++) {
                if (processed[j] == 1) {
                    continue;
                }
                if (isAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    processed[j] = 1;
                }
            }
            result.add(group);
        }

        return result;
    }
}
