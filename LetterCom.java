//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
//Example:
//
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//
//Although the above answer is in lexicographical order, your answer could be in any order you want.

import java.util.*;
import static java.util.stream.Collectors.toList;

class Solution {

    static Map<Character, Character[]> dic;
    static {
        dic = new HashMap<>();
        dic.put('2', new Character[] {'a', 'b', 'c'});
        dic.put('3', new Character[] {'d', 'e', 'f'});
        dic.put('4', new Character[] {'g', 'h', 'i'});
        dic.put('5', new Character[] {'j', 'k', 'l'});
        dic.put('6', new Character[] {'m', 'n', 'o'});
        dic.put('7', new Character[] {'p', 'q', 'r', 's'});
        dic.put('8', new Character[] {'t', 'u', 'v'});
        dic.put('9', new Character[] {'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        char[] d = digits.toCharArray();
        Character[][] chars = new Character[d.length][];
        for (int i = 0;i < d.length; i++) {
            chars[i] = dic.get(d[i]);
        }
        return comb(chars, 0);
    }

    public List<String> comb(Character[][] chars, int i) {
        List<String> strs = new ArrayList<>();
        if (i == chars.length - 1) {
            return Arrays.stream(chars[i]).map(String::valueOf).collect(toList());
        } else {
            for (Character c : chars[i]) {
                for (String str : comb(chars, i + 1))
                    strs.add(String.valueOf(c) + str);
            }
            return strs;
        }
    }
}
