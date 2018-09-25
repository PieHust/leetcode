//Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
//Example:
//
//Input: 5
//Output:
//[
//         [1],
//        [1,1],
//       [1,2,1],
//      [1,3,3,1],
//     [1,4,6,4,1]
//
//]
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        } else if (numRows == 1) {
            result.add(Arrays.asList(1));
                                
        } else if (numRows == 2) {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1,1));
                                            
        } else {
             result.add(Arrays.asList(1));
             result.add(Arrays.asList(1,1));
             for (int i = 3; i <= numRows; i++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(1);
                for (int j = 1; j < i - 1; j++) {
                    tmp.add(result.get(i - 2).get(j-1) + result.get(i - 2).get(j));
                }
                tmp.add(1);
                result.add(tmp);
            }
                                                
        }
         return result;
                            
    }
}
