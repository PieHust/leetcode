//Given an integer n, return 1 - n in lexicographical order.
//
//For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
//
//Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }
        
        //List<Integer> res = IntStream.rangeClosed(1, n).boxed().collect(toList());
        //res.sort((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
        return res;
    }
    
    private void dfs(int cur, int n, List<Integer> res) {
        if (cur <= n) {
            res.add(cur);
            for (int i = 0; i < 10; i++) {
                dfs(cur * 10 + i, n, res);
            }
        }
    }
}
