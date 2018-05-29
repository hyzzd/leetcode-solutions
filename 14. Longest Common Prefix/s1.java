public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)  
            return "";  
        for (int i = 0; i < strs[0].length(); i++) {  // Simple is beautiful
            for (int j = 1; j < strs.length; j++)  
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i))  
                    return strs[0].substring(0, i);  
        }  
        return strs[0];
    }
}
// Straightforward
// O(s)
// O(1)
