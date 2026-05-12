class Solution {
    public String longestCommonPrefix(String[] strs) {
        int shortestLen = strs[0].length();
        for (int i=1; i<strs.length; i++) {
            if (strs[i].length() < shortestLen)
                shortestLen = strs[i].length();
        }

        int prefixLen = 0;
        boolean found = false;
        for (int i=0; i<shortestLen; i++) {
            for (int j=1; j<strs.length; j++) {
                if(strs[j].charAt(i) != strs[j-1].charAt(i)) {
                    found = true;
                    break;
                }
            }
            if(found)
                break;
            prefixLen = i+1;
        }

        return strs[0].substring(0, prefixLen);
    }
}