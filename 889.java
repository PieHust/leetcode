//Return any binary tree that matches the given preorder and postorder traversals.
//
//Values in the traversals pre and post are distinct positive integers.
//
// 
//
//Example 1:
//
//Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//Output: [1,2,3,4,5,6,7]
// 
//
//Note:
//
//1 <= pre.length == post.length <= 30
//pre[] and post[] are both permutations of 1, 2, ..., pre.length.
//It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode tree = new TreeNode(pre[0]);
        if (pre.length > 1) {
            if (pre[1] != post[post.length - 2]) {
                int prei = findIndex(pre, post[post.length - 2]);
                int posti = findIndex(post, pre[1]);
                
                tree.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, prei),
                                                 Arrays.copyOfRange(post, 0, posti + 1));
                tree.right = constructFromPrePost(Arrays.copyOfRange(pre, prei, pre.length),
                                                 Arrays.copyOfRange(post, posti, post.length - 1));
                                                 
            } else {
                tree.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, pre.length),
                                                Arrays.copyOfRange(post, 0, post.length - 1));
                
            }
        }
        return tree;
    }
    
    private int findIndex(int[] num, int t) {
        for (int i = 0;i < num.length; i++) {
            if (num[i] == t) 
                return i;
        }
        return -1;
    }
}
