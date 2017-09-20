class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] characters= s.toCharArray();
		List<Character> subStrings = new ArrayList<>();
		int max = 0;
        int tmp = 0;
		for (int i = 0; i < characters.length; i++) {
			int index = subStrings.lastIndexOf(characters[i]) + 1;
			subStrings.add(characters[i]);
			if (index > 0 && index > tmp) {
				tmp = index;
			}
			int size = subStrings.size()-tmp;
			if(size > max) {
				max = size;
			}
		}
		return max;
    }
}
