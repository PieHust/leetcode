//Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//
//Two trees are duplicate if they have the same structure with same node values.
//
//Example 1:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//The following are two duplicate subtrees:
//
//      2
//     /
//    4
//and
//
//    4
//Therefore, you need to return above trees' root in the form of a list.
// 使用后序遍历
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        findHelper(root, new HashMap<>(), res);
        return res;
    }
    
    private String findHelper(TreeNode cur, HashMap<String, Integer> map, List<TreeNode> list) {
        if (cur == null) return "#";
        String serial = cur.val + "," + findHelper(cur.left, map, list) + "," + findHelper(cur.right, map, list);
        if (map.getOrDefault(serial, 0) == 1) list.add(cur);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
