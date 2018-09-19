//Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
//
//Examples:
//Input: S = "a1b2"
//Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//Input: S = "3z4"
//Output: ["3z4", "3Z4"]
//
//Input: S = "12345"
//Output: ["12345"]
//Note:
//
//S will be a string with length at most 12.
//S will consist only of letters or digits.
class Solution {
    
    public List<String> letterCasePermutation(String S) {
        List<String> strs = new ArrayList<>();
        if (S.length() == 0) {strs.add(S); return strs;}
        letterCaseHelper(strs, S, "", 0);
        return strs;
    }
    
    public void letterCaseHelper(List<String> strs, String s, String path, int i) {
        char c = s.charAt(i);
        if (i == s.length() - 1) {
            if (Character.isLetter(c)) {
                strs.add(path + Character.toLowerCase(c));
                strs.add(path + Character.toUpperCase(c));
            } else {
                strs.add(path + c);
            }
        } else {
            if (Character.isLetter(c)) {
                letterCaseHelper(strs, s, path + Character.toLowerCase(c), i+1);
                letterCaseHelper(strs, s, path + Character.toUpperCase(c), i+1);
            } else {
                letterCaseHelper(strs, s, path + c, i+1);
            }
        }
    }
}
